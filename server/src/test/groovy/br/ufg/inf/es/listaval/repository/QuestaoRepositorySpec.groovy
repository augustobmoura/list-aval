package br.ufg.inf.es.listaval.repository

import br.ufg.inf.es.listaval.model.elab.AreaConhecimento
import br.ufg.inf.es.listaval.model.elab.Questao
import br.ufg.inf.es.listaval.repository.elab.AreaConhecimentoRepository
import br.ufg.inf.es.listaval.repository.elab.QuestaoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class QuestaoRepositorySpec extends Specification {

	@Autowired(required = false)
	private QuestaoRepository questaoRepository

	@Autowired(required = false)
	private AreaConhecimentoRepository areaConhecimentoRepository

	def 'instancia de questao é salva e obtida corretamente'() {
		when: "Nova questao e criada"
		AreaConhecimento areaConhecimento = new AreaConhecimento()
		areaConhecimento.area = "area"
		areaConhecimento.nome = "nome"
		areaConhecimentoRepository.save(areaConhecimento)

		Questao questao = new Questao()
		questao.enunciado = 'Teste'
		questao.areaConhecimento = areaConhecimento

		and: "A questao e persistida"
		questaoRepository.save(questao)

		then: "A questao passa a ter um identificador atribuido"
		questao.id
	}
}
