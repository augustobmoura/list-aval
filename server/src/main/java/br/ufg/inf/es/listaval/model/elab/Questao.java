package br.ufg.inf.es.listaval.model.elab;

import br.ufg.inf.es.listaval.model.Usuario;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@TypeDefs({
		@TypeDef(
				name = "string-array",
				typeClass = StringArrayType.class
		)
})
@Data
@Entity
@NoArgsConstructor
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
	@Column(
			name = "palavras_chave",
			columnDefinition = "text[]"
	)
	private String[] palavrasChave;

	@CreatedDate
	private LocalDate dataCadastro;

	@ManyToOne
	@JoinColumn
	@CreatedBy
	private Usuario usuarioCadastro;

	@LastModifiedDate
	private LocalDate dataAlteracao;

	@ManyToOne
	@JoinColumn
	@LastModifiedBy
	private Usuario usuarioAlteracao;

	public Questao(@NotNull String enunciado, @NotNull AreaConhecimento areaConhecimento) {
		this.enunciado = enunciado;
		this.areaConhecimento = areaConhecimento;
	}
}
