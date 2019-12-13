package br.ufg.inf.es.listaval.controller;

import br.ufg.inf.es.listaval.auth.AuthenticationService;
import br.ufg.inf.es.listaval.dto.Credencial;
import br.ufg.inf.es.listaval.dto.JwtTokenDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@RestController
@PermitAll
@RequestMapping("/api/login")
public class LoginController {

	private final AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping
	public JwtTokenDTO login(@Valid @RequestBody Credencial credencial) {
		return authenticationService.doLogin(credencial.getEmail(), credencial.getSenha());
	}
}
