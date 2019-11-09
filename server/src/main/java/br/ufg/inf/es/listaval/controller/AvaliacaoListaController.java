package br.ufg.inf.es.listaval.controller;

import br.ufg.inf.es.listaval.AvaliacaoListaService;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoListaController {

	private final AvaliacaoListaService avaliacaoListaService;

	public AvaliacaoListaController(AvaliacaoListaService avaliacaoListaService) {
		this.avaliacaoListaService = avaliacaoListaService;
	}

	@GetMapping
	public Page<AvaliacaoLista> findAll(Pageable pageable) {
		return avaliacaoListaService.findAll(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AvaliacaoLista> findById(@PathVariable("id") Long id) {
		return avaliacaoListaService.findById(id)
			.map(record -> ResponseEntity.ok().body(record))
			.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public AvaliacaoLista create(@Valid @RequestBody AvaliacaoLista avaliacaoLista) {
		return avaliacaoListaService.save(avaliacaoLista);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AvaliacaoLista> update(@PathVariable("id") Long id, @Valid @RequestBody AvaliacaoLista avaliacaoLista) {
		return avaliacaoListaService.update(id, avaliacaoLista)
			.map(record -> ResponseEntity.ok().body(record))
			.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}/distribua")
	public List<AvaliacaoResolucaoLista> distribuaListas(@PathVariable("id") Long id) {
		return avaliacaoListaService.distribuaListas(id);
	}
}
