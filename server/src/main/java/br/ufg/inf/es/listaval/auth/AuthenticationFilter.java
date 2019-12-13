package br.ufg.inf.es.listaval.auth;

import br.ufg.inf.es.listaval.model.Usuario;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	private static final String AUTHORIZATION_HEADER_NAME = "Auhtorization";
	private static final Pattern BEARER_PATTERN = Pattern.compile("Bearer\\s+(.*)$");

	private final UsuarioJwtService jwtService;

	public AuthenticationFilter(final UsuarioJwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Override
	protected void doFilterInternal(
		final HttpServletRequest request,
		final HttpServletResponse response,
		final FilterChain filterChain
	) throws ServletException, IOException {
		final SecurityContext securityContext = SecurityContextHolder.getContext();

		extractAuthorizationHeader(request)
			.flatMap(this::extractBearerTokenFromAuthorization)
			.flatMap(this::extractUsuarioFromJwtToken)
			.map(usuarioToAuthentication(request))
			.ifPresent(securityContext::setAuthentication);

		filterChain.doFilter(request, response);
	}

	private Optional<String> extractAuthorizationHeader(final HttpServletRequest request) {
		return Optional.ofNullable(request.getHeader(AUTHORIZATION_HEADER_NAME));
	}

	private Optional<String> extractBearerTokenFromAuthorization(final String auth) {
		final String normalizedAuth = auth == null ? "" : auth.trim();
		final Matcher bearerMatcher = BEARER_PATTERN.matcher(normalizedAuth);

		return bearerMatcher.matches()
			? Optional.of(bearerMatcher.group(1))
			: Optional.empty();
	}

	private Optional<Usuario> extractUsuarioFromJwtToken(final String token) {
		return jwtService.tokenToUsuario(token);
	}

	private Function<Usuario, Authentication> usuarioToAuthentication(final HttpServletRequest request) {
		return (final Usuario usuario) -> {
			final UsernamePasswordAuthenticationToken auth =
				new UsernamePasswordAuthenticationToken(
					usuario,
					null,
					usuario.getAuthorities()
				);

			auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			return auth;
		};
	}
}
