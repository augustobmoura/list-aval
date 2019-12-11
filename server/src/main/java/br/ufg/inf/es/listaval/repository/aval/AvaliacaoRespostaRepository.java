package br.ufg.inf.es.listaval.repository.aval;

import br.ufg.inf.es.listaval.model.aval.AvaliacaoResposta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface AvaliacaoRespostaRepository extends PagingAndSortingRepository<AvaliacaoResposta, Long> {

	Page<AvaliacaoResposta> findAllByAvaliacaoResolucaoListaId(Long avaliacaoResolucaoListaId, Pageable pageable);

	Optional<AvaliacaoResposta> findByAvaliacaoResolucaoListaIdAndRespostaId(Long avaliacaoResolucaoListaId, UUID respostaId);

}
