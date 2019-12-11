package br.ufg.inf.es.listaval.auth;

import br.ufg.inf.es.listelab.UsuarioApi;
import br.ufg.inf.es.listelab.invoker.ApiException;
import br.ufg.inf.es.listelab.model.DtoResultadoUsuario;
import br.ufg.inf.es.listelab.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExternalAuthenticator implements Authenticator<Usuario> {

	private final UsuarioApi usuarioApi;

	public ExternalAuthenticator(UsuarioApi usuarioApi) {
		this.usuarioApi = usuarioApi;
	}

	@Override
	public Optional<Usuario> authenticate(String login, String password) {
		try {
			DtoResultadoUsuario resultadoUsuario = usuarioApi.login(
				new Usuario()
					.email(login)
					.password(password)
			);

			Boolean sucesso = resultadoUsuario.getSucesso();

			return sucesso != null && sucesso
				? Optional.ofNullable(resultadoUsuario.getResultado())
				: Optional.empty();
		} catch (ApiException e) {
			if (e.getCode() == 400) {
				return Optional.empty();
			}

			throw new RuntimeException("Erro ao logar", e);
		}
	}

}
