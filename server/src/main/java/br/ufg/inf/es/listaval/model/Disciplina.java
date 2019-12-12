package br.ufg.inf.es.listaval.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"nome"})
public class Disciplina {

	@NotNull
	private UUID id;

	@NotNull
	private String codigo;

	@NotNull
	private String nome;

	public Disciplina(@NotNull UUID id, @NotNull String codigo, @NotNull String nome) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
	}
}
