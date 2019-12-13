package br.ufg.inf.es.listaval.controller;

import br.ufg.inf.es.listaval.AvaliacaoResolucaoListaService;
import br.ufg.inf.es.listaval.dto.AvaliacaoResolucaoListaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/avaliacoesResolucao")
public class AvaliacaoResolucaoListaController {

	private final AvaliacaoResolucaoListaService avaliacaoResolucaoListaService;

	public AvaliacaoResolucaoListaController(AvaliacaoResolucaoListaService avaliacaoResolucaoListaService) {
		this.avaliacaoResolucaoListaService = avaliacaoResolucaoListaService;
	}

	@GetMapping
	public Page<AvaliacaoResolucaoListaDTO> findAll(Pageable pageable) {
		return avaliacaoResolucaoListaService.findAll(pageable);
	}

	@GetMapping("/minhas")
	public Page<AvaliacaoResolucaoListaDTO> listMinhasListas(Pageable pageable) {
		return avaliacaoResolucaoListaService.findAllMinhasListas(pageable);
	}

	@GetMapping("/paraAvaliar")
	public Page<AvaliacaoResolucaoListaDTO> listListasParaAvaliar(Pageable pageable) {
		return avaliacaoResolucaoListaService.findAllListasParaAvaliar(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AvaliacaoResolucaoListaDTO> findById(@PathVariable("id") Long id) {
		return avaliacaoResolucaoListaService.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public AvaliacaoResolucaoListaDTO create(@Valid @RequestBody AvaliacaoResolucaoListaDTO avaliacaoResolucaoLista) {
		return avaliacaoResolucaoListaService.save(avaliacaoResolucaoLista);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AvaliacaoResolucaoListaDTO> update(@PathVariable("id") Long id, @Valid @RequestBody AvaliacaoResolucaoListaDTO avaliacaoResolucaoLista) {
		return avaliacaoResolucaoListaService.update(id, avaliacaoResolucaoLista)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
}
