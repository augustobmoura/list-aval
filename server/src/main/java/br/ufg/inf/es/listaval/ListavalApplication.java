package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.model.Docente;
import br.ufg.inf.es.listaval.repository.DiscenteRepository;
import br.ufg.inf.es.listaval.repository.DisciplinaRepository;
import br.ufg.inf.es.listaval.repository.DocenteRepository;
import br.ufg.inf.es.listaval.repository.TurmaRepository;
import br.ufg.inf.es.listaval.repository.aplic.AplicacaoListaRepository;
import br.ufg.inf.es.listaval.repository.aplic.ResolucaoListaRepository;
import br.ufg.inf.es.listaval.repository.aplic.RespostaRepository;
import br.ufg.inf.es.listaval.repository.elab.AreaConhecimentoRepository;
import br.ufg.inf.es.listaval.repository.elab.ListaRepository;
import br.ufg.inf.es.listaval.repository.elab.QuestaoRepository;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import com.fasterxml.jackson.databind.Module;

@SpringBootApplication
public class ListavalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListavalApplication.class, args);
	}

	@Bean
	CommandLineRunner init(
		PlatformTransactionManager platformTransactionManager,
		DocenteRepository docenteRepository,
		DiscenteRepository discenteRepository,
		DisciplinaRepository disciplinaRepository,
		TurmaRepository turmaRepository,
		AreaConhecimentoRepository areaConhecimentoRepository,
		QuestaoRepository questaoRepository,
		ListaRepository listaRepository,
		AplicacaoListaRepository aplicacaoListaRepository,
		ResolucaoListaRepository resolucaoListaRepository,
		RespostaRepository respostaRepository
	) {
		return args -> {
			TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);

			transactionTemplate.execute(status -> {
				docenteRepository.save(new Docente("Admin", "admin@ufg.br"));
				status.flush();
				return null;
			});

			transactionTemplate.execute(status -> {
				new Populador(
					docenteRepository,
					discenteRepository,
					disciplinaRepository,
					turmaRepository,
					areaConhecimentoRepository,
					questaoRepository,
					listaRepository,
					aplicacaoListaRepository,
					resolucaoListaRepository,
					respostaRepository
				).cadastraEntidades();
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
