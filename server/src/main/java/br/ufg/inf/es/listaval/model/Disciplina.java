package br.ufg.inf.es.listaval.model;

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
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	public Disciplina(@NotNull String nome) {
		this.nome = nome;
	}
}
