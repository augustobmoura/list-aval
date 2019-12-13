package br.ufg.inf.es.listaval.auth;

import br.ufg.inf.es.listaval.dto.JwtTokenDTO;
import br.ufg.inf.es.listaval.model.Discente;
import br.ufg.inf.es.listaval.model.Docente;
import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listelab.model.UsuarioLogado;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Component
public class AuthenticationService {

	private final UsuarioJwtService usuarioJwtService;
	private final ExternalAuthenticator externalAuthenticator;

	public AuthenticationService(
			UsuarioJwtService usuarioJwtService,
			ExternalAuthenticator externalAuthenticator) {
		this.usuarioJwtService = usuarioJwtService;
		this.externalAuthenticator = externalAuthenticator;
	}

	@SuppressWarnings({"ConstantConditions"})
	private Usuario externalAuthenticate(String email, String senha) {
		Optional<UsuarioLogado> authenticate = externalAuthenticator.authenticate(email, senha);
		if (authenticate.isPresent()) {
			UsuarioLogado usuarioLogado = authenticate.get();

			switch (usuarioLogado.getRole().intValue()) {
				case 1:
					return new Docente(usuarioLogado);
				case 2:
					return new Discente(usuarioLogado);
				default:
					throw new IllegalStateException("Tipo de usuario desconhecido: " + usuarioLogado.getRole());
			}
		} else {
			throw new BadCredentialsException("Usuario ou senha invalidos");
		}
	}

	public JwtTokenDTO doLogin(@NotNull String email, @NotNull String senha) {
		Usuario usuario = externalAuthenticate(email, senha);
		String token = usuarioJwtService.usuarioToToken(usuario);

		return new JwtTokenDTO(usuario.getEmail(), token);
	}

	public Usuario currentUser() {
		final Object principal = SecurityContextHolder.getContext().getAuthentication();

		if (principal instanceof Usuario) {
			return (Usuario) principal;
		}

		if (principal != null) {
			throw new IllegalStateException("Objeto autenticado não implementa a classe Usuário");
		}

		return null;
	}

}
