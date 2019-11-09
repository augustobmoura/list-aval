package br.ufg.inf.es.listaval.distribuidor;

import br.ufg.inf.es.listaval.AvaliacaoResolucaoListaService;
import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aplic.AplicacaoLista;
import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.CriterioAvaliacao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Component
public class DistribuidorAvaliacoesAleatorio implements DistribuidorAvaliacoes {

	private AvaliacaoResolucaoListaService avaliacaoResolucaoListaService;

	public DistribuidorAvaliacoesAleatorio(AvaliacaoResolucaoListaService avaliacaoResolucaoListaService) {
		this.avaliacaoResolucaoListaService = avaliacaoResolucaoListaService;
	}

	@Override
	public List<AvaliacaoResolucaoLista> distribua(AvaliacaoLista avaliacaoLista) {
		List<Usuario> avaliadores = avaliacaoLista.getAvaliadores();
		Collections.shuffle(avaliadores);
		Iterator<Usuario> iterator = avaliadores.iterator();
		AplicacaoLista aplicacaoLista = avaliacaoLista.getAplicacaoLista();
		List<ResolucaoLista> resolucoes = aplicacaoLista.getResolucoes();

		List<AvaliacaoResolucaoLista> avaliacoes = new ArrayList<>();
		for (ResolucaoLista resolucaoLista : resolucoes) {
			if (!iterator.hasNext()) {
				iterator = avaliadores.iterator();
			}

			AvaliacaoResolucaoLista avaliacaoResolucaoLista = new AvaliacaoResolucaoLista(
				resolucaoLista,
				iterator.next()
			);
			avaliacaoResolucaoListaService.save(avaliacaoResolucaoLista);
			avaliacoes.add(avaliacaoResolucaoLista);
		}

		return avaliacoes;
	}

	@Override
	public Boolean suporta(CriterioAvaliacao criterioAvaliacao) {
		return criterioAvaliacao == CriterioAvaliacao.RANDOMICO;
	}

}
