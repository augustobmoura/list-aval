package br.ufg.inf.es.listaval.auth;

import br.ufg.inf.es.listelab.UsuarioApi;
import br.ufg.inf.es.listelab.invoker.ApiException;
import br.ufg.inf.es.listelab.model.DtoResultadoUsuario;
import br.ufg.inf.es.listelab.model.Login;
import br.ufg.inf.es.listelab.model.UsuarioLogado;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExternalAuthenticator implements Authenticator<UsuarioLogado> {

	private final UsuarioApi usuarioApi;

	public ExternalAuthenticator(final UsuarioApi usuarioApi) {
		this.usuarioApi = usuarioApi;
	}

	@Override
	public Optional<UsuarioLogado> authenticate(String login, String password) {
		try {
			final DtoResultadoUsuario resultadoUsuario = usuarioApi.cadastre(
				new Login()
					.email(login)
					.password(password)
			);

			final Boolean sucesso = resultadoUsuario.getSucesso();

			return sucesso != null && sucesso
				? Optional.ofNullable(resultadoUsuario.getResultado())
				: Optional.empty();
		} catch (final ApiException e) {
			if (e.getCode() == 400) {
				return Optional.empty();
			}

			throw new RuntimeException("Erro ao logar", e);
		}
	}

}
