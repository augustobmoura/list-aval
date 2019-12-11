package br.ufg.inf.es.listaval.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"nome", "email"})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "dtype")
@JsonSubTypes({
		@JsonSubTypes.Type(value = Discente.class, name = "Discente"),
		@JsonSubTypes.Type(value = Docente.class, name = "Docente")
})
public abstract class Usuario {

	private UUID id;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	private String senha;

	public Usuario(@NotNull UUID id, @NotNull String nome, @NotNull String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

}
