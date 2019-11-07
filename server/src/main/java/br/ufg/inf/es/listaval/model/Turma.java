package br.ufg.inf.es.listaval.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = {"disciplina", "semestre", "docente"})
@NoArgsConstructor
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Disciplina disciplina;

	@NotNull
	private String semestre;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Docente docente;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable()
	private Set<Discente> discentes;

	public Turma(@NotNull Disciplina disciplina, @NotNull String semestre, @NotNull Docente docente) {
		this.disciplina = disciplina;
		this.semestre = semestre;
		this.docente = docente;
	}
}
