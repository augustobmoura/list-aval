package br.ufg.inf.es.listaval.model.aval;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = {"avaliacaoResolucaoLista", "avaliadorId"})
@EntityListeners(AuditingEntityListener.class)
public class AvaliacaoResposta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private AvaliacaoResolucaoLista avaliacaoResolucaoLista;

	@NotNull
	private UUID respostaId;

	@NotNull
	private UUID avaliadorId;

	private String comentario;

	private Float nota;

	@NotNull
	private Boolean publicada;

	@CreatedDate
	private LocalDateTime dataCadastro;

	@LastModifiedDate
	private LocalDateTime dataAlteracao;

}
