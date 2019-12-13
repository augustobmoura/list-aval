package br.ufg.inf.es.listaval.config;

import br.ufg.inf.es.listaval.auth.AuthenticationService;
import br.ufg.inf.es.listaval.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

	public JpaAuditingConfiguration() {
	}

	@Bean
	public AuditorAware<String> auditorProvider(final AuthenticationService authenticationService) {
		//noinspection SimplifyOptionalCallChains
		return () -> Optional.ofNullable(authenticationService.currentUser())
			.map(Usuario::getNome)
			.map(Optional::of)
			.orElse(Optional.of("anonymous"));
	}

}
