package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResposta;
import br.ufg.inf.es.listaval.repository.aval.AvaliacaoRespostaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvaliacaoRespostaService {

	private final AvaliacaoRespostaRepository avaliacaoRespostaRepository;

	public AvaliacaoRespostaService(AvaliacaoRespostaRepository avaliacaoRespostaRepository) {
		this.avaliacaoRespostaRepository = avaliacaoRespostaRepository;
	}

	public Page<AvaliacaoResposta> findAll(Pageable pageable) {
		return avaliacaoRespostaRepository.findAll(pageable);
	}

	public Page<AvaliacaoResposta> findAllByAvaliacaoResolucaoListaId(Long avaliacaoResolucaoListaId, Pageable pageable) {
		return avaliacaoRespostaRepository.findAllByAvaliacaoResolucaoListaId(avaliacaoResolucaoListaId, pageable);
	}

	public Optional<AvaliacaoResposta> findById(Long id) {
		return avaliacaoRespostaRepository.findById(id);
	}

	public Optional<AvaliacaoResposta> findByAvaliacaoResolucaoListaIdAndRespostaId(Long resolucaoListaId, Long respostaId) {
		return avaliacaoRespostaRepository.findByAvaliacaoResolucaoListaIdAndRespostaId(resolucaoListaId, respostaId);
	}

	public AvaliacaoResposta save(AvaliacaoResposta avaliacaoResposta) {
		return avaliacaoRespostaRepository.save(avaliacaoResposta);
	}

	public Optional<AvaliacaoResposta> update(Long id, AvaliacaoResposta avaliacaoResposta) {
		return avaliacaoRespostaRepository.findById(id).map(record -> {
			Usuario avaliador = avaliacaoResposta.getAvaliador();
			if (avaliador != null) {
				record.setAvaliador(avaliador);
			}
			record.setPublicada(avaliacaoResposta.getPublicada());
			record.setNota(avaliacaoResposta.getNota());
			return avaliacaoRespostaRepository.save(record);
		});
	}
}
