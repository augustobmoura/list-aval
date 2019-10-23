package br.ufg.inf.es.listaval.config;

import br.ufg.inf.es.listaval.model.Docente;
import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.repository.DocenteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

	private DocenteRepository docenteRepository;

	public JpaAuditingConfiguration(DocenteRepository docenteRepository) {
		this.docenteRepository = docenteRepository;
	}

	@Bean
	public AuditorAware<Usuario> auditorProvider() {
        /*
          TODO: Mudar para SecurityContextHolder.getContext().getAuthentication().getName()
         */
		return () -> docenteRepository.findByEmail("admin@ufg.br");
	}
}
