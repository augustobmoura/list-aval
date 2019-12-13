package br.ufg.inf.es.listaval.auth;

import br.ufg.inf.es.listaval.model.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

	public Usuario currentUser() {
		final Object principal = SecurityContextHolder.getContext().getAuthentication();

		if (principal instanceof Usuario) { return (Usuario) principal; }

		if (principal != null) {
			throw new IllegalStateException("Objeto autenticado não implementa a classe Usuário");
		}

		return null;
	}

}
