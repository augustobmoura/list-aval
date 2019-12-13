package br.ufg.inf.es.listaval.distribuidor;

import br.ufg.inf.es.listaval.AvaliacaoResolucaoListaService;
import br.ufg.inf.es.listaval.model.aplic.AplicacaoLista;
import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.CriterioAvaliacao;
import br.ufg.inf.es.listaval.repository.aval.AvaliacaoResolucaoListaRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DistribuidorAvaliacoesAleatorio implements DistribuidorAvaliacoes {

	private AvaliacaoResolucaoListaRepository avaliacaoResolucaoListaRepository;

	public DistribuidorAvaliacoesAleatorio(AvaliacaoResolucaoListaRepository avaliacaoResolucaoListaRepository) {
		this.avaliacaoResolucaoListaRepository = avaliacaoResolucaoListaRepository;
	}

	@Override
	public List<AvaliacaoResolucaoLista> distribua(AvaliacaoLista avaliacaoLista) {
		List<UUID> avaliadores = Arrays.asList(avaliacaoLista.getAvaliadores());
		Collections.shuffle(avaliadores);
		Iterator<UUID> iterator = avaliadores.iterator();
		//TODO: Obter aplicaçao de lista
//		AplicacaoLista aplicacaoLista = avaliacaoLista.getAplicacaoLista();
		AplicacaoLista aplicacaoLista = null;
		List<ResolucaoLista> resolucoes = aplicacaoLista.getResolucoes();

		List<AvaliacaoResolucaoLista> avaliacoes = new ArrayList<>();
		for (ResolucaoLista resolucaoLista : resolucoes) {
			if (!iterator.hasNext()) {
				iterator = avaliadores.iterator();
			}

			AvaliacaoResolucaoLista avaliacaoResolucaoLista = new AvaliacaoResolucaoLista(
					resolucaoLista.getId(),
					iterator.next()
			);
			avaliacaoResolucaoListaRepository.save(avaliacaoResolucaoLista);
			avaliacoes.add(avaliacaoResolucaoLista);
		}

		return avaliacoes;
	}

	@Override
	public Boolean suporta(CriterioAvaliacao criterioAvaliacao) {
		return criterioAvaliacao == CriterioAvaliacao.RANDOMICO;
	}

}
