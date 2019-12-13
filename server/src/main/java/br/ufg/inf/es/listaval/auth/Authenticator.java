package br.ufg.inf.es.listaval.auth;

import java.util.Optional;

public interface Authenticator<T> {
	Optional<T> authenticate(final String login, final String password);
}
