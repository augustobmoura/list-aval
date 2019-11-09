package br.ufg.inf.es.listaval.distribuidor;

import br.ufg.inf.es.listaval.model.aval.AvaliacaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.CriterioAvaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DistribuidorAvaliacoesDecorator implements DistribuidorAvaliacoes {

	private final List<DistribuidorAvaliacoes> distribuidorAvaliacoes;

	public DistribuidorAvaliacoesDecorator(List<DistribuidorAvaliacoes> distribuidorAvaliacoes) {
		this.distribuidorAvaliacoes = distribuidorAvaliacoes;
	}

	@Override
	public List<AvaliacaoResolucaoLista> distribua(AvaliacaoLista avaliacaoLista) {
		Optional<DistribuidorAvaliacoes> distribuidorCompativel = distribuidorAvaliacoes
			.stream()
			.filter(dist -> dist.suporta(avaliacaoLista.getCriterioAvaliacao()))
			.findFirst();

		if (distribuidorCompativel.isPresent()) {
			return distribuidorCompativel.get().distribua(avaliacaoLista);
		} else {
			throw new RuntimeException("Nenhum distribuidor compativel com criterio " + avaliacaoLista.getCriterioAvaliacao());
		}
	}

	@Override
	public Boolean suporta(CriterioAvaliacao criterioAvaliacao) {
		return true;
	}

}
