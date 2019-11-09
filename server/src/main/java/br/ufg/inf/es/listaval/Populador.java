package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.distribuidor.DistribuidorAvaliacoesDecorator;
import br.ufg.inf.es.listaval.model.*;
import br.ufg.inf.es.listaval.model.aplic.AplicacaoLista;
import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import br.ufg.inf.es.listaval.model.aplic.Resposta;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoLista;
import br.ufg.inf.es.listaval.model.aval.CriterioAvaliacao;
import br.ufg.inf.es.listaval.model.elab.AreaConhecimento;
import br.ufg.inf.es.listaval.model.elab.Lista;
import br.ufg.inf.es.listaval.model.elab.Questao;
import br.ufg.inf.es.listaval.repository.DiscenteRepository;
import br.ufg.inf.es.listaval.repository.DisciplinaRepository;
import br.ufg.inf.es.listaval.repository.DocenteRepository;
import br.ufg.inf.es.listaval.repository.TurmaRepository;
import br.ufg.inf.es.listaval.repository.aplic.AplicacaoListaRepository;
import br.ufg.inf.es.listaval.repository.aplic.ResolucaoListaRepository;
import br.ufg.inf.es.listaval.repository.aplic.RespostaRepository;
import br.ufg.inf.es.listaval.repository.aval.AvaliacaoListaRepository;
import br.ufg.inf.es.listaval.repository.elab.AreaConhecimentoRepository;
import br.ufg.inf.es.listaval.repository.elab.ListaRepository;
import br.ufg.inf.es.listaval.repository.elab.QuestaoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class Populador {

	private final DocenteRepository docenteRepository;
	private final DiscenteRepository discenteRepository;
	private final DisciplinaRepository disciplinaRepository;
	private final TurmaRepository turmaRepository;
	private final AreaConhecimentoRepository areaConhecimentoRepository;
	private final QuestaoRepository questaoRepository;
	private final ListaRepository listaRepository;
	private final AplicacaoListaRepository aplicacaoListaRepository;
	private final ResolucaoListaRepository resolucaoListaRepository;
	private final RespostaRepository respostaRepository;
	private final AvaliacaoListaRepository avaliacaoListaRepository;
	private final DistribuidorAvaliacoesDecorator distribuidorAvaliacoesDecorator;

	public Populador(
		DocenteRepository docenteRepository,
		DiscenteRepository discenteRepository,
		DisciplinaRepository disciplinaRepository,
		TurmaRepository turmaRepository,
		AreaConhecimentoRepository areaConhecimentoRepository,
		QuestaoRepository questaoRepository,
		ListaRepository listaRepository,
		AplicacaoListaRepository aplicacaoListaRepository,
		ResolucaoListaRepository resolucaoListaRepository,
		RespostaRepository respostaRepository,
		AvaliacaoListaRepository avaliacaoListaRepository,
		DistribuidorAvaliacoesDecorator distribuidorAvaliacoesDecorator
	) {
		this.docenteRepository = docenteRepository;
		this.discenteRepository = discenteRepository;
		this.disciplinaRepository = disciplinaRepository;
		this.turmaRepository = turmaRepository;
		this.areaConhecimentoRepository = areaConhecimentoRepository;
		this.questaoRepository = questaoRepository;
		this.listaRepository = listaRepository;
		this.aplicacaoListaRepository = aplicacaoListaRepository;
		this.resolucaoListaRepository = resolucaoListaRepository;
		this.respostaRepository = respostaRepository;
		this.avaliacaoListaRepository = avaliacaoListaRepository;
		this.distribuidorAvaliacoesDecorator = distribuidorAvaliacoesDecorator;
	}

	public void cadastraEntidades() {
		if (respostaRepository.count() > 0) {
			return;
		}
		Docente docente = cadastraDocente(docenteRepository);

		Set<Discente> discentes = cadastraDiscentes(discenteRepository);

		Disciplina disciplina = cadastraDisciplina(disciplinaRepository);

		Turma turma = cadastraTurma(turmaRepository, docente, discentes, disciplina);

		AreaConhecimento areaConhecimento = cadastraAreaConhecimento(areaConhecimentoRepository);

		List<Questao> questoes = cadastraQuestoes(questaoRepository, areaConhecimento);

		Lista lista = cadastraLista(listaRepository, questoes);

		AplicacaoLista aplicacaoLista = cadastraAplicacaoDeLista(aplicacaoListaRepository, turma, lista);

		List<ResolucaoLista> resolucoes = discentes.stream().map(discente -> {
			ResolucaoLista resolucaoLista = cadastraResolucaoDeLista(resolucaoListaRepository, aplicacaoLista, discente);
			cadastraRespostas(respostaRepository, questoes, resolucaoLista);
			return resolucaoLista;
		}).collect(Collectors.toList());

		aplicacaoLista.setResolucoes(resolucoes);

		AvaliacaoLista avaliacaoLista = new AvaliacaoLista(aplicacaoLista, CriterioAvaliacao.RANDOMICO);
		List<Usuario> avaliadores = new ArrayList<>(discentes);
		avaliadores.add(docente);
		avaliacaoLista.setAvaliadores(avaliadores);
		avaliacaoListaRepository.save(avaliacaoLista);

		distribuidorAvaliacoesDecorator.distribua(avaliacaoLista);
	}

	private void cadastraRespostas(RespostaRepository respostaRepository, List<Questao> questoes, ResolucaoLista resolucaoLista) {
		questoes.stream().map(q -> new Resposta(resolucaoLista, q, "É claro que a percepção das dificuldades apresenta tendências no sentido de aprovar a manutenção do levantamento das variáveis envolvidas."))
			.forEach(respostaRepository::save);
	}

	private ResolucaoLista cadastraResolucaoDeLista(ResolucaoListaRepository resolucaoListaRepository, AplicacaoLista aplicacaoLista, Discente discente) {
		ResolucaoLista resolucaoLista = new ResolucaoLista(aplicacaoLista, discente);
		resolucaoListaRepository.save(resolucaoLista);
		return resolucaoLista;
	}

	private AplicacaoLista cadastraAplicacaoDeLista(AplicacaoListaRepository aplicacaoListaRepository, Turma turma, Lista lista) {
		AplicacaoLista aplicacaoLista = new AplicacaoLista(lista, turma);
		aplicacaoListaRepository.save(aplicacaoLista);
		return aplicacaoLista;
	}

	private Lista cadastraLista(ListaRepository listaRepository, List<Questao> questoes) {
		Lista lista = new Lista();
		lista.setQuestoes(questoes);
		listaRepository.save(lista);
		return lista;
	}

	private List<Questao> cadastraQuestoes(QuestaoRepository questaoRepository, AreaConhecimento areaConhecimento) {
		return IntStream.range(1, 16)
			.mapToObj(i -> {
				String[] palavrasChave = new Random()
					.ints(8, 1, 100)
					.mapToObj(j -> "palavra " + j)
					.toArray(String[]::new);

				Questao questao = new Questao("Enunciado da questão " + i, areaConhecimento);
				questao.setPalavrasChave(palavrasChave);
				return questao;
			})
			.map(questaoRepository::save)
			.collect(Collectors.toList());
	}

	private AreaConhecimento cadastraAreaConhecimento(AreaConhecimentoRepository areaConhecimentoRepository) {
		AreaConhecimento areaConhecimento = new AreaConhecimento("10101004", "MATEMÁTICA", "ALGEBRA");
		areaConhecimentoRepository.save(areaConhecimento);
		return areaConhecimento;
	}

	private Turma cadastraTurma(TurmaRepository turmaRepository, Docente docente, Set<Discente> discentes, Disciplina disciplina) {
		Turma turma = new Turma(disciplina, "02/2019", docente);
		turma.setDiscentes(discentes);
		turmaRepository.save(turma);
		return turma;
	}

	private Disciplina cadastraDisciplina(DisciplinaRepository disciplinaRepository) {
		Disciplina disciplina = new Disciplina("Engenharia de Software");
		disciplinaRepository.save(disciplina);
		return disciplina;
	}

	private Set<Discente> cadastraDiscentes(DiscenteRepository discenteRepository) {
		return IntStream.range(1, 11)
			.mapToObj(i -> new Discente("Aluno " + i, "aluno" + i + "@discente.ufg.br"))
			.map(discenteRepository::save)
			.collect(Collectors.toSet());
	}

	private Docente cadastraDocente(DocenteRepository docenteRepository) {
		Docente docente = new Docente("Professor Pasquale", "pasquale@docente.ufg.br");
		docenteRepository.save(docente);
		return docente;
	}
}
