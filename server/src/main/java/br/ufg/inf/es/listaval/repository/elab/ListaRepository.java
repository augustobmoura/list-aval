package br.ufg.inf.es.listaval.repository.elab;

import br.ufg.inf.es.listaval.model.elab.AreaConhecimento;
import br.ufg.inf.es.listaval.model.elab.Lista;
import br.ufg.inf.es.listaval.model.elab.Questao;
import br.ufg.inf.es.listelab.ListaApi;
import br.ufg.inf.es.listelab.invoker.ApiException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ListaRepository {

	final ListaApi listaApi;

	public ListaRepository(ListaApi listaApi) {
		this.listaApi = listaApi;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public Optional<Lista> findById(UUID id) {
		try {
			Map resultado = (Map) listaApi.consulteListaPorId(id.toString()).getResultado();

			if (resultado != null) {
				String listaId = (String) resultado.get("id");
				String titulo = (String) resultado.get("titulo");
				String usuario = (String) resultado.get("usuario");
				List<Map> questoesDiscursiva = (List<Map>) resultado.get("questoesDiscursiva");

				List<Questao> questoes = questoesDiscursiva.stream().map(q -> {
					Double numero = (Double) resultado.get("numero");
					Map questaoMap = (Map) q.get("questao");
					String idQuestao = (String) questaoMap.get("id");
					String enunciado = (String) questaoMap.get("enunciado");
					Map areaDeConhecimento = (Map) questaoMap.get("areaDeConhecimento");
					String codigo = (String) areaDeConhecimento.get("codigo");
					String descricao = (String) areaDeConhecimento.get("descricao");
					AreaConhecimento areaConhecimento = new AreaConhecimento(codigo, descricao);

					List<String> tags = (List<String>) questaoMap.get("tags");
					Questao questao = new Questao(UUID.fromString(idQuestao), enunciado, areaConhecimento);
					questao.setPalavrasChave(tags.toArray(new String[0]));
					return questao;
				}).collect(Collectors.toList());

				Lista lista = new Lista(UUID.fromString(listaId), questoes);
				lista.setUsuarioCadastro(usuario);

				return Optional.of(lista);
			} else {
				return Optional.empty();
			}
		} catch (ApiException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
}
