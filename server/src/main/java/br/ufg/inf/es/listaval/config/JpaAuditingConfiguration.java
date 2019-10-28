package br.ufg.inf.es.listaval.config;

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
	public AuditorAware<String> auditorProvider() {
        /*
          TODO: Mudar para SecurityContextHolder.getContext().getAuthentication().getName()
         */
		return () -> Optional.of("admin@ufg.br");
	}
}
