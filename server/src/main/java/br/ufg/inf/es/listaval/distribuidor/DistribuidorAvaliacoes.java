package br.ufg.inf.es.listaval.distribuidor;

import br.ufg.inf.es.listaval.model.aval.AvaliacaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.CriterioAvaliacao;

import java.util.List;

public interface DistribuidorAvaliacoes {

	List<AvaliacaoResolucaoLista> distribua(AvaliacaoLista avaliacaoLista);

	Boolean suporta(CriterioAvaliacao criterioAvaliacao);

}
