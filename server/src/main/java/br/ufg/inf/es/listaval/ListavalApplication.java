package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaplic.ClassroomControllerApi;
import br.ufg.inf.es.listaplic.ListControllerApi;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ListavalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListavalApplication.class, args);
	}

	@Bean
	CommandLineRunner init(
	) {
		return args -> {

		};
	}

	@Bean
	protected Module module() {
		return new Hibernate5Module();
	}

	@Bean
	ListControllerApi listControllerApi() {
		return new ListControllerApi();
	}

	@Bean
	ClassroomControllerApi classroomControllerApi() {
		return new ClassroomControllerApi();
	}

}
