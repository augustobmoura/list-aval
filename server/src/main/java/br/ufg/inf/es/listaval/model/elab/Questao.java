package br.ufg.inf.es.listaval.model.elab;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
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

@TypeDefs({
		@TypeDef(
				name = "string-array",
				typeClass = StringArrayType.class
		)
})
@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String enunciado;

	@NotNull
	@ManyToOne
	@JoinColumn
	private AreaConhecimento areaConhecimento;

	@Type(type = "string-array")
	@Column(columnDefinition = "text[]")
	private String[] palavrasChave;

	@CreatedDate
	private LocalDateTime dataCadastro;

	@CreatedBy
	private String usuarioCadastro;

	@LastModifiedDate
	private LocalDateTime dataAlteracao;

	@LastModifiedBy
	private String usuarioAlteracao;

	public Questao(@NotNull String enunciado, @NotNull AreaConhecimento areaConhecimento) {
		this.enunciado = enunciado;
		this.areaConhecimento = areaConhecimento;
	}
}
