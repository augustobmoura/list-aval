package br.ufg.inf.es.listaval.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Docente extends Usuario {

	public Docente(@NotNull String nome, @NotNull String email) {
		super(nome, email);
	}

}
