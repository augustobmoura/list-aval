package br.ufg.inf.es.listaval.model.aplic;

import br.ufg.inf.es.listaval.model.elab.Questao;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = {"resolucaoLista", "questao", "conteudo"})
@EntityListeners(AuditingEntityListener.class)
public class Resposta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private ResolucaoLista resolucaoLista;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Questao questao;

	@NotNull
	private String conteudo;

	@CreatedDate
	private LocalDateTime dataCadastro;

	@LastModifiedDate
	private LocalDateTime dataAlteracao;

	public Resposta(@NotNull ResolucaoLista resolucaoLista, @NotNull Questao questao, @NotNull String conteudo) {
		this.resolucaoLista = resolucaoLista;
		this.questao = questao;
		this.conteudo = conteudo;
	}
}
