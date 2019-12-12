package br.ufg.inf.es.listaval.controller;

import br.ufg.inf.es.listaval.AvaliacaoRespostaService;
import br.ufg.inf.es.listaval.dto.AvaliacaoRespostaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AvaliacaoRespostaController {

	private final AvaliacaoRespostaService avaliacaoRespostaService;

	public AvaliacaoRespostaController(AvaliacaoRespostaService avaliacaoRespostaService) {
		this.avaliacaoRespostaService = avaliacaoRespostaService;
	}

	@GetMapping("/avaliacoesResposta")
	public Page<AvaliacaoRespostaDTO> findAll(Pageable pageable) {
		return avaliacaoRespostaService.findAll(pageable);
	}

	@GetMapping("/avaliacoesResposta/{id}")
	public ResponseEntity<AvaliacaoRespostaDTO> findById(@PathVariable("id") Long id) {
		return avaliacaoRespostaService.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/avaliacoesResposta")
	public AvaliacaoRespostaDTO create(@Valid @RequestBody AvaliacaoRespostaDTO avaliacaoResposta) {
		return avaliacaoRespostaService.save(avaliacaoResposta);
	}

	@PutMapping("/avaliacoesResposta/{id}")
	public ResponseEntity<AvaliacaoRespostaDTO> update(@PathVariable("id") Long id, @Valid @RequestBody AvaliacaoRespostaDTO avaliacaoResposta) {
		return avaliacaoRespostaService.update(id, avaliacaoResposta)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/avaliacoesResolucao/{avaliacaoResolucaoListaId}/respostas")
	public Page<AvaliacaoRespostaDTO> findAllByAvaliacaoResolucaoLista(@PathVariable("avaliacaoResolucaoListaId") Long avaliacaoResolucaoListaId, Pageable pageable) {
		return avaliacaoRespostaService.findAllByAvaliacaoResolucaoListaId(avaliacaoResolucaoListaId, pageable);
	}

	@GetMapping("/avaliacoesResolucao/{avaliacaoResolucaoListaId}/{respostaId}")
	public ResponseEntity<AvaliacaoRespostaDTO> findByAvaliacaoResolucaoListaAndResposta(
			@PathVariable("avaliacaoResolucaoListaId") Long avaliacaoResolucaoListaId,
			@PathVariable("respostaId") UUID respostaId
	) {
		return avaliacaoRespostaService.findByAvaliacaoResolucaoListaIdAndRespostaId(avaliacaoResolucaoListaId, respostaId)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
}
