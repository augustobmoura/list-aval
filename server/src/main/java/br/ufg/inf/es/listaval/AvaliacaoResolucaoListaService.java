package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.repository.aval.AvaliacaoResolucaoListaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvaliacaoResolucaoListaService {

	private final AvaliacaoResolucaoListaRepository avaliacaoResolucaoListaRepository;

	public AvaliacaoResolucaoListaService(AvaliacaoResolucaoListaRepository avaliacaoResolucaoListaRepository) {
		this.avaliacaoResolucaoListaRepository = avaliacaoResolucaoListaRepository;
	}

	public Page<AvaliacaoResolucaoLista> findAll(Pageable pageable) {
		// TODO: Filtrar avaliaçoes do usuario logado
		return avaliacaoResolucaoListaRepository.findAll(pageable);
	}

	public Optional<AvaliacaoResolucaoLista> findById(Long id) {
		return avaliacaoResolucaoListaRepository.findById(id);
	}

	public AvaliacaoResolucaoLista save(AvaliacaoResolucaoLista avaliacaoResolucaoLista) {
		return avaliacaoResolucaoListaRepository.save(avaliacaoResolucaoLista);
	}

	public Optional<AvaliacaoResolucaoLista> update(Long id, AvaliacaoResolucaoLista avaliacaoResolucaoLista) {
		return avaliacaoResolucaoListaRepository.findById(id).map(record -> {
			record.setAvaliador(avaliacaoResolucaoLista.getAvaliador());
			record.setPublicada(avaliacaoResolucaoLista.getPublicada());
			record.setNota(avaliacaoResolucaoLista.getNota());
			return avaliacaoResolucaoListaRepository.save(record);
		});
	}
}
