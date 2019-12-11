package br.ufg.inf.es.listaval.auth;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

	private final SecretProvider secretProvider;

	public AuthenticationService(final SecretProvider secretProvider) {
		this.secretProvider = secretProvider;
	}

}
