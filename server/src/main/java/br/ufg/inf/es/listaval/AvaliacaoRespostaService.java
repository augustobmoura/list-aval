package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.dto.AvaliacaoResolucaoListaDTO;
import br.ufg.inf.es.listaval.dto.AvaliacaoRespostaDTO;
import br.ufg.inf.es.listaval.model.aplic.Resposta;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResposta;
import br.ufg.inf.es.listaval.repository.aval.AvaliacaoRespostaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Service
public class AvaliacaoRespostaService {

	private final AvaliacaoRespostaRepository avaliacaoRespostaRepository;
	private final AvaliacaoResolucaoListaService avaliacaoResolucaoListaService;

	public AvaliacaoRespostaService(
			AvaliacaoRespostaRepository avaliacaoRespostaRepository,
			AvaliacaoResolucaoListaService avaliacaoResolucaoListaService
	) {
		this.avaliacaoRespostaRepository = avaliacaoRespostaRepository;
		this.avaliacaoResolucaoListaService = avaliacaoResolucaoListaService;
	}

	public Page<AvaliacaoRespostaDTO> findAll(Pageable pageable) {
		return avaliacaoRespostaRepository.findAll(pageable).map(this::convertToDTO);
	}

	public Page<AvaliacaoRespostaDTO> findAllByAvaliacaoResolucaoListaId(Long avaliacaoResolucaoListaId, Pageable pageable) {
		return avaliacaoRespostaRepository.findAllByAvaliacaoResolucaoListaId(avaliacaoResolucaoListaId, pageable).map(this::convertToDTO);
	}

	public Optional<AvaliacaoRespostaDTO> findById(Long id) {
		return avaliacaoRespostaRepository.findById(id).map(this::convertToDTO);
	}

	public Optional<AvaliacaoRespostaDTO> findByAvaliacaoResolucaoListaIdAndRespostaId(Long resolucaoListaId, UUID respostaId) {
		return avaliacaoRespostaRepository.findByAvaliacaoResolucaoListaIdAndRespostaId(resolucaoListaId, respostaId).map(this::convertToDTO);
	}

	public AvaliacaoRespostaDTO save(AvaliacaoRespostaDTO avaliacaoRespostaDTO) {
		Optional<AvaliacaoResolucaoListaDTO> avaliacaoResolucaoListaOptional = avaliacaoResolucaoListaService.findById(avaliacaoRespostaDTO.getAvaliacaoResolucaoLista().getId());
		avaliacaoRespostaDTO.setAvaliacaoResolucaoLista(avaliacaoResolucaoListaOptional.get());

		AvaliacaoResposta avaliacaoResposta = avaliacaoRespostaDTO.toAvaliacaoResposta();
		return convertToDTO(avaliacaoRespostaRepository.save(avaliacaoResposta));
	}

	public Optional<AvaliacaoRespostaDTO> update(Long id, AvaliacaoRespostaDTO avaliacaoResposta) {
		return avaliacaoRespostaRepository.findById(id).map(record -> {
			@NotNull String avaliador = avaliacaoResposta.getAvaliadorId();
			if (avaliador != null) {
				record.setAvaliadorId(avaliador);
			}
			record.setPublicada(avaliacaoResposta.getPublicada());
			record.setNota(avaliacaoResposta.getNota());
			return avaliacaoRespostaRepository.save(record);
		}).map(this::convertToDTO);
	}

	private AvaliacaoRespostaDTO convertToDTO(AvaliacaoResposta avaliacaoResposta) {
		AvaliacaoResolucaoListaDTO avaliacaoResolucaoLista = avaliacaoResolucaoListaService.convertAvaliacaoToDTO(avaliacaoResposta.getAvaliacaoResolucaoLista());
		Optional<Resposta> respostaOptional = avaliacaoResolucaoLista.getResolucaoLista()
				.getRespostas().stream()
				.filter(resposta -> resposta.getId().equals(avaliacaoResposta.getRespostaId()))
				.findFirst();
		AvaliacaoRespostaDTO avaliacaoRespostaDTO = new AvaliacaoRespostaDTO(respostaOptional.get(), avaliacaoResolucaoLista.getAvaliador(), avaliacaoResolucaoLista);
		avaliacaoRespostaDTO.setId(avaliacaoResposta.getId());
		avaliacaoRespostaDTO.setComentario(avaliacaoResposta.getComentario());
		avaliacaoRespostaDTO.setNota(avaliacaoResposta.getNota());
		avaliacaoRespostaDTO.setPublicada(avaliacaoResposta.getPublicada());
		return avaliacaoRespostaDTO;
	}
}
