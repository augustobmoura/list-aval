package br.ufg.inf.es.listaval.repository.aplic;

import br.ufg.inf.es.listaplic.ListControllerApi;
import br.ufg.inf.es.listaplic.invoker.ApiException;
import br.ufg.inf.es.listaplic.model.Application;
import br.ufg.inf.es.listaval.model.Discente;
import br.ufg.inf.es.listaval.model.Turma;
import br.ufg.inf.es.listaval.model.aplic.AplicacaoLista;
import br.ufg.inf.es.listaval.model.elab.Lista;
import br.ufg.inf.es.listaval.repository.elab.ListaRepository;
import br.ufg.inf.es.listaval.repository.elab.TurmaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AplicacaoListaRepository {

	private static final UUID CLASSROOM_ID = UUID.fromString("2f0367ae-2f14-4dc0-8bb0-da705160f97f");

	final ListaRepository listaRepository;
	final ListControllerApi listControllerApi;
	final TurmaRepository turmaRepository;

	public AplicacaoListaRepository(
			ListaRepository listaRepository,
			ListControllerApi listControllerApi,
			TurmaRepository turmaRepository
	) {
		this.listaRepository = listaRepository;
		this.listControllerApi = listControllerApi;
		this.turmaRepository = turmaRepository;
	}

	List<AplicacaoLista> findAll() {
		try {
			Optional<Turma> turmaOptional = turmaRepository.findById(CLASSROOM_ID);
			if (!turmaOptional.isPresent()) {
				throw new IllegalStateException("Turma nao encontrada");
			}
			List<Application> applications = listControllerApi.getApplicationsByClassroomUsingGET(CLASSROOM_ID, Application.StatusEnum.ENCERRADA.name());

			return applications.stream()
					.map(application -> buildAplicacaoLista(turmaOptional.get(), application))
					.collect(Collectors.toList());

		} catch (ApiException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	private AplicacaoLista buildAplicacaoLista(Turma turma, Application application) {
		Optional<Lista> lista = listaRepository.findById(application.getListId());
		if (!lista.isPresent()) {
			throw new IllegalStateException("Lista nao encontrada");
		}
		Set<Discente> discentes = application.getStudentList().stream()
			.map(student -> new Discente(student.getId().toString(), student.getName(), student.getEmail()))
				.collect(Collectors.toSet());

		turma.setDiscentes(discentes);

		return new AplicacaoLista(application.getId(), lista.get(), turma);
	}

	Optional<AplicacaoLista> findById(UUID id) {
		try {
			Optional<Turma> turmaOptional = turmaRepository.findById(CLASSROOM_ID);
			if (!turmaOptional.isPresent()) {
				throw new IllegalStateException("Turma nao encontrada");
			}
			Application application = listControllerApi.getApplicationDetailByIdUsingGET(id);

			AplicacaoLista aplicacaoLista = buildAplicacaoLista(turmaOptional.get(), application);

			return Optional.of(aplicacaoLista);
		} catch (ApiException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

}
