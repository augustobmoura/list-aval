package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.distribuidor.DistribuidorAvaliacoesDecorator;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.repository.aval.AvaliacaoListaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AvaliacaoListaService {

	private final AvaliacaoListaRepository avaliacaoListaRepository;
	private final DistribuidorAvaliacoesDecorator distribuidorAvaliacoesDecorator;

	public AvaliacaoListaService(
			AvaliacaoListaRepository avaliacaoListaRepository,
			DistribuidorAvaliacoesDecorator distribuidorAvaliacoesDecorator
	) {
		this.avaliacaoListaRepository = avaliacaoListaRepository;
		this.distribuidorAvaliacoesDecorator = distribuidorAvaliacoesDecorator;
	}

	public Page<AvaliacaoLista> findAll(Pageable pageable) {
		// TODO: Filtrar avaliaçoes do usuario logado
		return avaliacaoListaRepository.findAll(pageable);
	}

	public Optional<AvaliacaoLista> findById(Long id) {
		return avaliacaoListaRepository.findById(id);
	}

	public AvaliacaoLista save(AvaliacaoLista avaliacaoLista) {
		return avaliacaoListaRepository.save(avaliacaoLista);
	}

	public Optional<AvaliacaoLista> update(Long id, AvaliacaoLista avaliacaoLista) {
		return avaliacaoListaRepository.findById(id).map(record -> {
			UUID[] avaliadores = avaliacaoLista.getAvaliadores();
			if (avaliadores != null) {
				record.setAvaliadores(avaliadores);
			}
			record.setCriterioAvaliacao(avaliacaoLista.getCriterioAvaliacao());
			return avaliacaoListaRepository.save(record);
		});
	}

	public List<AvaliacaoResolucaoLista> distribuaListas(Long id) {
		Optional<AvaliacaoLista> maybeAvaliacao = avaliacaoListaRepository.findById(id);

		if (maybeAvaliacao.isPresent()) {
			AvaliacaoLista avaliacaoLista = maybeAvaliacao.get();
			return distribuidorAvaliacoesDecorator.distribua(avaliacaoLista);
		}

		return null;
	}
}
