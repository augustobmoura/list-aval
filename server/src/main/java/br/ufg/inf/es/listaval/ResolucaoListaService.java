package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import br.ufg.inf.es.listaval.repository.aplic.ResolucaoListaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ResolucaoListaService {

	private final ResolucaoListaRepository resolucaoListaRepository;

	public ResolucaoListaService(ResolucaoListaRepository resolucaoListaRepository) {
		this.resolucaoListaRepository = resolucaoListaRepository;
	}

	public Page<ResolucaoLista> findAll(Pageable pageable) {
		return resolucaoListaRepository.findAll(pageable);
	}

	public Optional<ResolucaoLista> findById(String id) {
		return resolucaoListaRepository.findById(UUID.fromString(id));
	}

}
