package br.ufg.inf.es.listaval.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Inheritance
@NoArgsConstructor
@EqualsAndHashCode(of = {"nome", "email"})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "dtype")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Discente.class, name = "Discente"),
	@JsonSubTypes.Type(value = Docente.class, name = "Docente")
})
public abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	private String senha;

	public Usuario(@NotNull String nome, @NotNull String email) {
		this.nome = nome;
		this.email = email;
	}

}
