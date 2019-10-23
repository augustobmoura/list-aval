package br.ufg.inf.es.listaval.model.aplic;

import br.ufg.inf.es.listaval.model.Discente;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ResolucaoLista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private AplicacaoLista aplicacaoLista;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Discente discente;

	@OneToMany(mappedBy = "resolucaoLista", cascade = CascadeType.ALL)
	private List<Resposta> respostas;

	@CreatedDate
	private LocalDateTime dataCadastro;

	@LastModifiedDate
	private LocalDateTime dataAlteracao;

	public ResolucaoLista(@NotNull AplicacaoLista aplicacaoLista, @NotNull Discente discente) {
		this.aplicacaoLista = aplicacaoLista;
		this.discente = discente;
	}
}
