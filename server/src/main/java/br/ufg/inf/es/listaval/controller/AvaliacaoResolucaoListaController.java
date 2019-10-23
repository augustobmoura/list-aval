package br.ufg.inf.es.listaval.controller;

import br.ufg.inf.es.listaval.AvaliacaoResolucaoListaService;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoResolucaoListaController {

	private final AvaliacaoResolucaoListaService avaliacaoResolucaoListaService;

	public AvaliacaoResolucaoListaController(AvaliacaoResolucaoListaService avaliacaoResolucaoListaService) {
		this.avaliacaoResolucaoListaService = avaliacaoResolucaoListaService;
	}

	@GetMapping
	public Page<AvaliacaoResolucaoLista> findAll(Pageable pageable) {
		return avaliacaoResolucaoListaService.findAll(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AvaliacaoResolucaoLista> findById(@PathVariable("id") Long id) {
		return avaliacaoResolucaoListaService.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public AvaliacaoResolucaoLista create(@Valid @RequestBody AvaliacaoResolucaoLista avaliacaoResolucaoLista) {
		return avaliacaoResolucaoListaService.save(avaliacaoResolucaoLista);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AvaliacaoResolucaoLista> update(@PathVariable("id") Long id, @Valid @RequestBody AvaliacaoResolucaoLista avaliacaoResolucaoLista) {
		return avaliacaoResolucaoListaService.update(id, avaliacaoResolucaoLista)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
}
