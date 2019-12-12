package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.dto.AvaliacaoResolucaoListaDTO;
import br.ufg.inf.es.listaval.model.Docente;
import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.repository.aplic.ResolucaoListaRepository;
import br.ufg.inf.es.listaval.repository.aval.AvaliacaoResolucaoListaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AvaliacaoResolucaoListaService {

	private final AvaliacaoResolucaoListaRepository avaliacaoResolucaoListaRepository;
	private final ResolucaoListaRepository resolucaoListaRepository;

	public AvaliacaoResolucaoListaService(
			AvaliacaoResolucaoListaRepository avaliacaoResolucaoListaRepository,
			ResolucaoListaRepository resolucaoListaRepository
	) {
		this.avaliacaoResolucaoListaRepository = avaliacaoResolucaoListaRepository;
		this.resolucaoListaRepository = resolucaoListaRepository;
	}

	public Page<AvaliacaoResolucaoListaDTO> findAll(Pageable pageable) {
		Page<AvaliacaoResolucaoLista> avaliacoes = avaliacaoResolucaoListaRepository.findAll(pageable);
		return convertPageToDTO(avaliacoes);
	}

	public Page<AvaliacaoResolucaoListaDTO> findAllMinhasListas(Pageable pageable) {
		// TODO: Filtrar avaliaçoes do usuario logado
		UUID discenteId = UUID.fromString("585c69cd-c9e1-46f3-9135-cf1939cf5d48");

		Page<AvaliacaoResolucaoLista> minhasAvaliacoes = avaliacaoResolucaoListaRepository.findAllByPublicadaAndDiscenteId(true, discenteId, pageable);

		return convertPageToDTO(minhasAvaliacoes);
	}

	public Page<AvaliacaoResolucaoListaDTO> findAllListasParaAvaliar(Pageable pageable) {
		// TODO: Filtrar avaliaçoes do usuario logado
		UUID avaliadorId = UUID.fromString("585c69cd-c9e1-46f3-9135-cf1939cf5d48");

		Page<AvaliacaoResolucaoLista> paraAvaliar = avaliacaoResolucaoListaRepository.findAllByAvaliadorId(avaliadorId, pageable);
		return convertPageToDTO(paraAvaliar);
	}

	public Optional<AvaliacaoResolucaoListaDTO> findById(Long id) {
		return avaliacaoResolucaoListaRepository.findById(id)
				.map(this::convertAvaliacaoToDTO);
	}

	public AvaliacaoResolucaoListaDTO save(AvaliacaoResolucaoListaDTO dto) {
		ResolucaoLista resolucaoLista = fetchResolucaoLista(dto);
		AvaliacaoResolucaoLista avaliacao = avaliacaoResolucaoListaRepository.save(dto.toAvaliacaoResolucaoLista());

		return convertAvaliacaoToDTO(avaliacao, resolucaoLista);
	}

	private ResolucaoLista fetchResolucaoLista(AvaliacaoResolucaoListaDTO dto) {
		Optional<ResolucaoLista> maybeResolucaoLista = resolucaoListaRepository.findById(dto.getResolucaoLista().getId());
		if (!maybeResolucaoLista.isPresent()) {
			throw new IllegalStateException("Resoluçao lista nao encontrada");
		}
		ResolucaoLista resolucaoLista = maybeResolucaoLista.get();

		dto.setResolucaoLista(resolucaoLista);
		return resolucaoLista;
	}

	public Optional<AvaliacaoResolucaoListaDTO> update(Long id, AvaliacaoResolucaoListaDTO dto) {
		return avaliacaoResolucaoListaRepository.findById(id).map(record -> {
			UUID avaliador = dto.getAvaliador().getId();
			if (avaliador != null) {
				record.setAvaliadorId(avaliador);
			}
			record.setPublicada(dto.getPublicada());
			record.setNota(dto.getNota());
			return avaliacaoResolucaoListaRepository.save(record);
		}).map(this::convertAvaliacaoToDTO);
	}

	private Page<AvaliacaoResolucaoListaDTO> convertPageToDTO(Page<AvaliacaoResolucaoLista> minhasAvaliacoes) {
		return minhasAvaliacoes.map(this::convertAvaliacaoToDTO);
	}

	public AvaliacaoResolucaoListaDTO convertAvaliacaoToDTO(AvaliacaoResolucaoLista avaliacao) {
		Optional<ResolucaoLista> resolucaoLista = resolucaoListaRepository.findById(avaliacao.getResolucaoListaId());
		if (!resolucaoLista.isPresent()) {
			throw new IllegalStateException("Resoluçao lista nao encontrada");
		}

		return convertAvaliacaoToDTO(avaliacao, resolucaoLista.get());
	}

	private AvaliacaoResolucaoListaDTO convertAvaliacaoToDTO(AvaliacaoResolucaoLista avaliacao, ResolucaoLista resolucaoLista) {
		Docente docente = new Docente(avaliacao.getAvaliadorId(), "", "");

		return new AvaliacaoResolucaoListaDTO(
				resolucaoLista,
				docente,
				avaliacao
		);
	}
}
