package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.repository.aval.AvaliacaoResolucaoListaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AvaliacaoResolucaoListaService {

	private final AvaliacaoResolucaoListaRepository avaliacaoResolucaoListaRepository;

	public AvaliacaoResolucaoListaService(AvaliacaoResolucaoListaRepository avaliacaoResolucaoListaRepository) {
		this.avaliacaoResolucaoListaRepository = avaliacaoResolucaoListaRepository;
	}

	public Page<AvaliacaoResolucaoLista> findAll(Pageable pageable) {
		return avaliacaoResolucaoListaRepository.findAll(pageable);
	}

	public Page<AvaliacaoResolucaoLista> findAllMinhasListas(Pageable pageable) {
		// TODO: Filtrar avaliaçoes do usuario logado
		UUID discenteId = UUID.fromString("585c69cd-c9e1-46f3-9135-cf1939cf5d48");

		return avaliacaoResolucaoListaRepository.findAllByPublicadaAndDiscenteId(true, discenteId, pageable);
	}

	public Page<AvaliacaoResolucaoLista> findAllListasParaAvaliar(Pageable pageable) {
		// TODO: Filtrar avaliaçoes do usuario logado
		UUID avaliadorId = UUID.fromString("585c69cd-c9e1-46f3-9135-cf1939cf5d48");

		return avaliacaoResolucaoListaRepository.findAllByAvaliadorId(avaliadorId, pageable);
	}

	public Optional<AvaliacaoResolucaoLista> findById(Long id) {
		return avaliacaoResolucaoListaRepository.findById(id);
	}

	public AvaliacaoResolucaoLista save(AvaliacaoResolucaoLista avaliacaoResolucaoLista) {
		return avaliacaoResolucaoListaRepository.save(avaliacaoResolucaoLista);
	}

	public Optional<AvaliacaoResolucaoLista> update(Long id, AvaliacaoResolucaoLista avaliacaoResolucaoLista) {
		return avaliacaoResolucaoListaRepository.findById(id).map(record -> {
			UUID avaliador = avaliacaoResolucaoLista.getAvaliadorId();
			if (avaliador != null) {
				record.setAvaliadorId(avaliador);
			}
			record.setPublicada(avaliacaoResolucaoLista.getPublicada());
			record.setNota(avaliacaoResolucaoLista.getNota());
			return avaliacaoResolucaoListaRepository.save(record);
		});
	}
}
