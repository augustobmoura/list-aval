package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.model.aplic.Resposta;
import br.ufg.inf.es.listaval.repository.aplic.RespostaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RespostaService {

	private final RespostaRepository respostaRepository;

	public RespostaService(RespostaRepository respostaRepository) {
		this.respostaRepository = respostaRepository;
	}

	public Page<Resposta> findAllByResolucaoListaId(Long resolucaoId, Pageable pageable) {
		return respostaRepository.findAllByResolucaoListaId(resolucaoId, pageable);
	}

	public Optional<Resposta> findById(Long id) {
		return respostaRepository.findById(id);
	}

}
