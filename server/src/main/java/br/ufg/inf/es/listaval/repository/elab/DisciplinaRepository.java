package br.ufg.inf.es.listaval.repository.elab;

import br.ufg.inf.es.listaval.model.Disciplina;
import br.ufg.inf.es.listelab.DisciplinaApi;
import br.ufg.inf.es.listelab.invoker.ApiException;
import br.ufg.inf.es.listelab.model.DtoResultadoDisciplina;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class DisciplinaRepository {

	private final Map<String, Disciplina> disciplinaByCode;
	private final DisciplinaApi disciplinaApi;

	public DisciplinaRepository(DisciplinaApi disciplinaApi) {
		this.disciplinaApi = disciplinaApi;
		disciplinaByCode = new LinkedHashMap<>();
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void loadDisciplinas() {
		disciplinaByCode.clear();
		try {
			DtoResultadoDisciplina dtoResultadoDisciplina = this.disciplinaApi.consulteLista();
			List<Map> resultado = (List<Map>) dtoResultadoDisciplina.getResultado();

			if (resultado != null) {
				this.disciplinaByCode.putAll(resultado.stream().map(map -> {
					String id = (String) map.get("id");
					String codigo = (String) map.get("codigo");
					String descricao = (String) map.get("descricao");
					return new Disciplina(UUID.fromString(id), codigo, descricao);
				}).collect(Collectors.toMap(Disciplina::getCodigo, Function.identity())));
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

	public Optional<Disciplina> findByCode(String code) {
		if (disciplinaByCode.isEmpty()) {
			this.loadDisciplinas();
		}
		return Optional.ofNullable(disciplinaByCode.get(code));
	}

}
