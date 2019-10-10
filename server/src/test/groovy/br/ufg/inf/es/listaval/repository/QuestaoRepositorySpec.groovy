package br.ufg.inf.es.listaval.repository

import br.ufg.inf.es.listaval.model.Questao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class QuestaoRepositorySpec extends Specification {

	@Autowired(required = false)
	private QuestaoRepository questaoRepository

	def 'instancia de questao é salva e obtida corretamente'() {
		when: "Nova questao e criada"
		Questao questao = new Questao()
		questao.enunciado = 'Teste'

		and: "A questao e persistida"
		questaoRepository.save(questao)

		then: "A questao passa a ter um identificador atribuido"
		questao.id
	}
}
