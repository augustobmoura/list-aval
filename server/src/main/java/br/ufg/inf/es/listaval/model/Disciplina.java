package br.ufg.inf.es.listaval.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"nome"})
public class Disciplina {

	private Long id;

	@NotNull
	private String nome;

	private LocalDateTime dataCadastro;

	private String usuarioCadastro;

	private LocalDateTime dataAlteracao;

	private String usuarioAlteracao;

	public Disciplina(@NotNull String nome) {
		this.nome = nome;
	}
}
