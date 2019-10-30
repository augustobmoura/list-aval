package br.ufg.inf.es.listaval.repository.aplic;

import br.ufg.inf.es.listaval.model.aplic.Resposta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RespostaRepository extends PagingAndSortingRepository<Resposta, Long> {

	Page<Resposta> findAllByResolucaoListaId(Long resolucaoId, Pageable pageable);

}
