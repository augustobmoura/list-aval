package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoLista;
import br.ufg.inf.es.listaval.repository.aval.AvaliacaoListaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoListaService {

	private final AvaliacaoListaRepository avaliacaoListaRepository;

	public AvaliacaoListaService(AvaliacaoListaRepository avaliacaoListaRepository) {
		this.avaliacaoListaRepository = avaliacaoListaRepository;
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
			List<Usuario> avaliadores = avaliacaoLista.getAvaliadores();
			if (avaliadores != null) {
				record.setAvaliadores(avaliadores);
			}
			record.setCriterioAvaliacao(avaliacaoLista.getCriterioAvaliacao());
			return avaliacaoListaRepository.save(record);
		});
	}
}
