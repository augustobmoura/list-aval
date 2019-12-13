package br.ufg.inf.es.listaval.model.aval;

import com.vladmihalcea.hibernate.type.array.UUIDArrayType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@TypeDefs({
		@TypeDef(
				name = "uuid-array",
				typeClass = UUIDArrayType.class
		)
})
@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AvaliacaoLista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private UUID aplicacaoListaId;

	@Type(type = "uuid-array")
	@Column(columnDefinition = "text[]")
	private UUID[] avaliadores;

	@NotNull
	@Enumerated(EnumType.STRING)
	private CriterioAvaliacao criterioAvaliacao;

	@NotNull
	private Boolean distribuida = false;

	@CreatedDate
	private LocalDateTime dataCadastro;

	@CreatedBy
	private String usuarioCadastro;

	@LastModifiedDate
	private LocalDateTime dataAlteracao;

	@LastModifiedBy
	private String usuarioAlteracao;

	public AvaliacaoLista(@NotNull UUID aplicacaoListaId, @NotNull CriterioAvaliacao criterioAvaliacao) {
		this.aplicacaoListaId = aplicacaoListaId;
		this.criterioAvaliacao = criterioAvaliacao;
	}
}
