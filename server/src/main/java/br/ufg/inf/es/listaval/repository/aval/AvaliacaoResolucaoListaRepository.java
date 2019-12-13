package br.ufg.inf.es.listaval.repository.aval;

import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AvaliacaoResolucaoListaRepository extends PagingAndSortingRepository<AvaliacaoResolucaoLista, Long> {

	Page<AvaliacaoResolucaoLista> findAllByPublicadaAndDiscenteId(Boolean publicada, String discenteId, Pageable pageable);

	Page<AvaliacaoResolucaoLista> findAllByAvaliadorId(String avaliadorId, Pageable pageable);

}
