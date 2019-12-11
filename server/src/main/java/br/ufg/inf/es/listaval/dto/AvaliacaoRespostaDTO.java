package br.ufg.inf.es.listaval.dto;

import br.ufg.inf.es.listaval.model.aplic.Resposta;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResposta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;

@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AvaliacaoRespostaDTO extends AvaliacaoResposta {

	private Resposta resposta;

}
