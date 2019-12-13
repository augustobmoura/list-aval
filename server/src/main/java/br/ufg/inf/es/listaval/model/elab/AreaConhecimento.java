package br.ufg.inf.es.listaval.model.elab;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"codigo", "nome"})
public class AreaConhecimento {

	private Long id;

	private String codigo;

	private String nome;

	public AreaConhecimento(@NotNull String codigo, @NotNull String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
}
