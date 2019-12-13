package br.ufg.inf.es.listaval.controller;

import br.ufg.inf.es.listaval.RespostaService;
import br.ufg.inf.es.listaval.model.aplic.Resposta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RespostaController {

	private final RespostaService respostaService;

	public RespostaController(RespostaService respostaService) {
		this.respostaService = respostaService;
	}

	@GetMapping("/resolucoes/{resolucaoId}/respostas")
	public Page<Resposta> findAllByResolucaoLista(@PathVariable("resolucaoId") Long resolucaoId, Pageable pageable) {
		return respostaService.findAllByResolucaoListaId(resolucaoId, pageable);
	}

	@GetMapping("/respostas/{id}")
	public ResponseEntity<Resposta> findById(@PathVariable("id") Long id) {
		return respostaService.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

}
