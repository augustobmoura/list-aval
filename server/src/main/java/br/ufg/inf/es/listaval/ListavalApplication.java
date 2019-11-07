package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.model.Docente;
import br.ufg.inf.es.listaval.repository.DocenteRepository;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
public class ListavalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListavalApplication.class, args);
	}

	@Bean
	CommandLineRunner init(
		DocenteRepository docenteRepository,
		PlatformTransactionManager platformTransactionManager,
		Populador populador
	) {
		return args -> {
			TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);

			transactionTemplate.execute(status -> {
				docenteRepository.save(new Docente("Admin", "admin@ufg.br"));
				status.flush();
				return null;
			});

			transactionTemplate.execute(status -> {
				populador.cadastraEntidades();
				status.flush();
				return null;
			});
		};
	}

	@Bean
	protected Module module() {
		return new Hibernate5Module();
	}
}
