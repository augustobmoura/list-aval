package br.ufg.inf.es.listaval.dto;

import br.ufg.inf.es.listaval.model.aplic.AplicacaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoLista;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AvaliacaoListaDTO extends AvaliacaoLista {

	private AplicacaoLista aplicacaoLista;

}
