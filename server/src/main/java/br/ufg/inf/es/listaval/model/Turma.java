package br.ufg.inf.es.listaval.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Docente docente;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable()
	private Set<Discente> discentes;

}
