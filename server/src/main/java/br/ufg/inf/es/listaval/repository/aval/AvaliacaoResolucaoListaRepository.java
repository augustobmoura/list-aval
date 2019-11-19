package br.ufg.inf.es.listaval.repository.aval;

import br.ufg.inf.es.listaval.model.Discente;
import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AvaliacaoResolucaoListaRepository extends PagingAndSortingRepository<AvaliacaoResolucaoLista, Long> {

	Page<AvaliacaoResolucaoLista> findAllByPublicadaAndResolucaoListaDiscente(Boolean publicada, Discente discente, Pageable pageable);

	Page<AvaliacaoResolucaoLista> findAllByAvaliador(Usuario usuario, Pageable pageable);

}
