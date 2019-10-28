package br.ufg.inf.es.listaval.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@Entity
@Inheritance
@NoArgsConstructor
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(email, usuario.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
}
