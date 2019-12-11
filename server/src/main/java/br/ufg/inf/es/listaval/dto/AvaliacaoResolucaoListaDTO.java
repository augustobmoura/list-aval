package br.ufg.inf.es.listaval.dto;

import br.ufg.inf.es.listaval.model.Discente;
import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResposta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AvaliacaoResolucaoListaDTO extends AvaliacaoResolucaoLista {

	private ResolucaoLista resolucaoLista;
	private Discente discente;
	private Usuario avaliador;

	@Override
	public List<AvaliacaoResposta> getAvaliacoesRespostas() {
		return super.getAvaliacoesRespostas();
	}

}
