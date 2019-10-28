package br.ufg.inf.es.listaval.model.aplic;

import br.ufg.inf.es.listaval.model.Turma;
import br.ufg.inf.es.listaval.model.elab.Lista;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AplicacaoLista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Lista lista;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Turma turma;

	@OneToMany(mappedBy = "aplicacaoLista", cascade = CascadeType.ALL)
	private List<ResolucaoLista> resolucoes;

	@CreatedDate
	private LocalDateTime dataCadastro;

	@CreatedBy
	private String usuarioCadastro;

	public AplicacaoLista(@NotNull Lista lista, @NotNull Turma turma) {
		this.lista = lista;
		this.turma = turma;
	}
}
