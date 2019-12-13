package br.ufg.inf.es.listaval.auth;

import br.ufg.inf.es.listaval.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.jackson2.CoreJackson2Module;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Optional;

@Component
public class UsuarioJwtService {

	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

	static {
		JSON_MAPPER.registerModule(new CoreJackson2Module());
	}

	public static final String JSON_SERIALIZED_USER_CLAIM = "userDetails";

	private final Algorithm algorithm;

	@Autowired
	public UsuarioJwtService(final SecretProvider secretProvider) {
		algorithm = Algorithm.HMAC256(secretProvider.getSecret());
	}

	public UsuarioJwtService(final Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	public Optional<Usuario> tokenToUsuario(final String token) {
		try {
			final DecodedJWT jwt = JWT.decode(token);
			final Claim usuarioClaim = jwt.getClaim(JSON_SERIALIZED_USER_CLAIM);
			final Usuario usuario = JSON_MAPPER.readValue(usuarioClaim.asString(), Usuario.class);

			return Optional.of(usuario);
		} catch (final JWTVerificationException | IOException e) {
			return Optional.empty();
		}
	}

	public String usuarioToToken(@NotNull final Usuario usuario) {
		try {
			final String userInJson = JSON_MAPPER.writeValueAsString(usuario);
			return JWT.create()
					.withClaim(JSON_SERIALIZED_USER_CLAIM, userInJson)
					.sign(algorithm);
		} catch (JsonProcessingException e) {
			throw new IllegalStateException("Erro ao serializar usuário", e);
		}
	}
}
