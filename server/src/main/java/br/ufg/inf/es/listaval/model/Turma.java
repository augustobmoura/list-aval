package br.ufg.inf.es.listaval.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = {"disciplina", "semestre", "docente"})
@NoArgsConstructor
public class Turma {

	private Long id;

	@NotNull
	private Disciplina disciplina;

	@NotNull
	private String semestre;

	@NotNull
	private Docente docente;

	private Set<Discente> discentes;

	public Turma(@NotNull Disciplina disciplina, @NotNull String semestre, @NotNull Docente docente) {
		this.disciplina = disciplina;
		this.semestre = semestre;
		this.docente = docente;
	}
}
