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
@EqualsAndHashCode(callSuper = true)
public class Discente extends Usuario {

	public Discente(@NotNull UUID id, @NotNull String nome, @NotNull String email) {
		super(id, nome, email);
	}

}
