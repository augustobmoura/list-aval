package br.ufg.inf.es.listaval.repository.aplic;

import br.ufg.inf.es.listaplic.ClassroomControllerApi;
import br.ufg.inf.es.listaplic.ListControllerApi;
import br.ufg.inf.es.listaplic.invoker.ApiException;
import br.ufg.inf.es.listaplic.model.*;
import br.ufg.inf.es.listaval.model.Discente;
import br.ufg.inf.es.listaval.model.Disciplina;
import br.ufg.inf.es.listaval.model.Docente;
import br.ufg.inf.es.listaval.model.Turma;
import br.ufg.inf.es.listaval.model.aplic.AplicacaoLista;
import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import br.ufg.inf.es.listaval.model.aplic.Resposta;
import br.ufg.inf.es.listaval.model.elab.AreaConhecimento;
import br.ufg.inf.es.listaval.model.elab.Lista;
import br.ufg.inf.es.listaval.model.elab.Questao;
import br.ufg.inf.es.listaval.repository.elab.ListaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ResolucaoListaRepository {

	private static final UUID CLASSROOM_ID = UUID.fromString("2f0367ae-2f14-4dc0-8bb0-da705160f97f");

	final ListControllerApi listControllerApi;
	final ClassroomControllerApi classroomControllerApi;
	final ListaRepository listaRepository;

	public ResolucaoListaRepository(
			ListControllerApi listControllerApi,
			ClassroomControllerApi classroomControllerApi,
			ListaRepository listaRepository
	) {
		this.listControllerApi = listControllerApi;
		this.classroomControllerApi = classroomControllerApi;
		this.listaRepository = listaRepository;
	}

	public Page<ResolucaoLista> findAll(Pageable pageable) {
		try {
			UUID classroomId = CLASSROOM_ID;
			Classroom classroom = this.classroomControllerApi.findByIdUsingGET(classroomId);
			Docente docente = new Docente(classroomId, "Professor Pasquale", "pasquale@ufg.br");
			Disciplina disciplina = new Disciplina(classroom.getName());
			Turma turma = new Turma(disciplina, "2019/2", docente);

			List<Application> applications = listControllerApi.getApplicationsByClassroomUsingGET(classroomId, null);

			List<ResolucaoLista> resolucoes = new ArrayList<>();
			applications.forEach((application -> {
				List<ResolucaoLista> resolucaoListas = getResolucoesLista(classroomId, turma, application);

				resolucoes.addAll(resolucaoListas);
			}));

			return new PageImpl<>(resolucoes);
		} catch (ApiException e) {
			e.printStackTrace();
			return null;
		}
	}

	private List<ResolucaoLista> getResolucoesLista(UUID classroomId, Turma turma, Application application) {
		Optional<Lista> lista = listaRepository.findById(application.getListId());
		List<ResolucaoLista> resolucoes = new ArrayList<>();

		if (lista.isPresent()) {
			AplicacaoLista aplicacaoLista = new AplicacaoLista(application.getId(), lista.get(), turma);

			Map<UUID, List<Questao>> questoesPorId = lista.get().getQuestoes().stream().collect(Collectors.groupingBy(Questao::getId, Collectors.toList()));
			List<Student> studentList = application.getStudentList();

			studentList.forEach(student -> {
				Discente discente = new Discente(student.getId(), student.getName(), student.getEmail());

				List<ResolucaoLista> resolucaoListas = getPendingListsByStudentUsingGET(classroomId, student).stream().filter(testList -> Objects.equals(testList.getListApplicationId(), application.getId()))
						.map(testList -> {
							List<Resposta> respostas = testList.getQuestions().stream()
									.filter(question -> question.getType() == Question.TypeEnum.DISCURSIVE)
									.map(question -> {
										Questao questao = questoesPorId.get(question.getId()).get(0);
										return new Resposta(null, questao, question.getAnswer());
									})
									.collect(Collectors.toList());
							// TODO: Nao e possivel consultar uma resolucao especifica. Aqui to fazendo mais uma gambiarra: Salvei o id da aplicaçao como o da resoluçao
							// ResolucaoLista resolucaoLista = new ResolucaoLista(testList.getId(), aplicacaoLista, discente);
							ResolucaoLista resolucaoLista = new ResolucaoLista(application.getId(), aplicacaoLista, discente);
							resolucaoLista.setRespostas(respostas);
							return resolucaoLista;
						}).collect(Collectors.toList());

				resolucoes.addAll(resolucaoListas);
			});
		}

		return resolucoes;
	}

	private List<TestList> getPendingListsByStudentUsingGET(UUID classroomId, Student student) {
		try {
			return listControllerApi.getPendingListsByStudentUsingGET(classroomId, student.getId());
		} catch (ApiException e) {
			return new ArrayList<>();
		}
	}

	public Optional<ResolucaoLista> findById(UUID id) {
		try {
			UUID classroomId = CLASSROOM_ID;
			Classroom classroom = this.classroomControllerApi.findByIdUsingGET(classroomId);
			Docente docente = new Docente(classroomId, "Professor Pasquale", "pasquale@ufg.br");
			Disciplina disciplina = new Disciplina(classroom.getName());
			Turma turma = new Turma(disciplina, "2019/2", docente);

			Application application = listControllerApi.getApplicationDetailByIdUsingGET(id);

			return Optional.ofNullable(getResolucoesLista(classroomId, turma, application).get(0));
		} catch (ApiException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
}
