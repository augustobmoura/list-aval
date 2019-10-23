package br.ufg.inf.es.listaval.model.elab;

import br.ufg.inf.es.listaval.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class AreaConhecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String codigo;

	@NotNull
	private String area;

	@NotNull
	private String nome;

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

	public AreaConhecimento(@NotNull String codigo, @NotNull String area, @NotNull String nome) {
		this.area = area;
		this.nome = nome;
	}
}
