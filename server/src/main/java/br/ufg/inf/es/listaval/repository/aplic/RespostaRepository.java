package br.ufg.inf.es.listaval.repository.aplic;

import br.ufg.inf.es.listaval.model.aplic.Resposta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RespostaRepository {

	public Page<Resposta> findAllByResolucaoListaId(Long resolucaoId, Pageable pageable) {
		return null;
	}

	public Optional<Resposta> findById(Long id) {
		return null;
	}
}
