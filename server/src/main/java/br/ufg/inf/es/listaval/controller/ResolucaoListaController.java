package br.ufg.inf.es.listaval.controller;

import br.ufg.inf.es.listaval.ResolucaoListaService;
import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/resolucoes")
public class ResolucaoListaController {

	private final ResolucaoListaService resolucaoListaService;

	public ResolucaoListaController(ResolucaoListaService resolucaoListaService) {
		this.resolucaoListaService = resolucaoListaService;
	}

	@GetMapping
	public Page<ResolucaoLista> findAll(Pageable pageable) {
		return resolucaoListaService.findAll(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResolucaoLista> findById(@PathVariable("id") String id) {
		return resolucaoListaService.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

}
