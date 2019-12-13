package br.ufg.inf.es.listaval.repository.aplic;

import br.ufg.inf.es.listaplic.ListControllerApi;
import br.ufg.inf.es.listaplic.invoker.ApiException;
import br.ufg.inf.es.listaplic.model.Question;
import br.ufg.inf.es.listaplic.model.TestList;
import br.ufg.inf.es.listaval.model.Discente;
import br.ufg.inf.es.listaval.model.aplic.AplicacaoLista;
import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import br.ufg.inf.es.listaval.model.aplic.Resposta;
import br.ufg.inf.es.listaval.model.elab.Lista;
import br.ufg.inf.es.listaval.model.elab.Questao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class ResolucaoListaRepository {

	private static final UUID CLASSROOM_ID = UUID.fromString("2f0367ae-2f14-4dc0-8bb0-da705160f97f");
	private final Map<UUID, ResolucaoLista> resolucoesPorId = new LinkedHashMap<>();

	private final ListControllerApi listControllerApi;
	private final AplicacaoListaRepository aplicacaoListaRepository;

	public ResolucaoListaRepository(
			ListControllerApi listControllerApi,
			AplicacaoListaRepository aplicacaoListaRepository
	) {
		this.listControllerApi = listControllerApi;
		this.aplicacaoListaRepository = aplicacaoListaRepository;
	}

	public Page<ResolucaoLista> findAll(Pageable pageable) {
		if (resolucoesPorId.isEmpty()) {
			loadAllResolucoes();
		}
		List<ResolucaoLista> resolucoes = new ArrayList<>(resolucoesPorId.values());

		return new PageImpl<>(resolucoes);
	}

	private void loadAllResolucoes() {
		resolucoesPorId.clear();
		List<AplicacaoLista> aplicacoes = aplicacaoListaRepository.findAll();

		resolucoesPorId.putAll(aplicacoes.stream()
				.flatMap((aplicacaoLista -> getResolucoesLista(aplicacaoLista).stream()))
				.collect(Collectors.toMap(ResolucaoLista::getId, Function.identity())));
	}

	private List<ResolucaoLista> getResolucoesLista(AplicacaoLista aplicacaoLista) {
		Lista lista = aplicacaoLista.getLista();
		List<ResolucaoLista> resolucoes = new ArrayList<>();

		Map<UUID, Questao> questoesPorId = lista.getQuestoes().stream().collect(Collectors.toMap(Questao::getId, Function.identity()));
		Set<Discente> discentes = aplicacaoLista.getTurma().getDiscentes();

		discentes.forEach(discente -> {
			List<ResolucaoLista> resolucaoListas = getPendingListsByStudentUsingGET(aplicacaoLista.getTurma().getId(), discente.getId())
					.stream()
					.filter(testList -> Objects.equals(testList.getListApplicationId(), aplicacaoLista.getId()))
					.map(testList -> {
						ResolucaoLista resolucaoLista = new ResolucaoLista(UUID.randomUUID(), aplicacaoLista, discente);

						List<Resposta> respostas = testList.getQuestions().stream()
								.filter(question -> question.getType() == Question.TypeEnum.DISCURSIVE)
								.map(question -> {
									Questao questao = questoesPorId.get(question.getId());
									return new Resposta(questao.getId(), new ResolucaoLista(resolucaoLista.getId()), questao, question.getAnswer());
								}).collect(Collectors.toList());

						resolucaoLista.setRespostas(respostas);
						return resolucaoLista;
					}).collect(Collectors.toList());

			resolucoes.addAll(resolucaoListas);
		});

		return resolucoes;
	}

	private List<TestList> getPendingListsByStudentUsingGET(UUID classroomId, UUID studentId) {
		try {
			return listControllerApi.getPendingListsByStudentUsingGET(classroomId, studentId);
		} catch (ApiException e) {
			return new ArrayList<>();
		}
	}

	public Optional<ResolucaoLista> findById(UUID id) {
		if (resolucoesPorId.isEmpty()) {
			loadAllResolucoes();
		}
		return Optional.ofNullable(resolucoesPorId.get(id));
	}
}
