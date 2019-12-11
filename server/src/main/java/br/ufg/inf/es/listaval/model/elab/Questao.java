package br.ufg.inf.es.listaval.model.elab;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"enunciado", "areaConhecimento"})
public class Questao {

	private UUID id;

	private String enunciado;

	private AreaConhecimento areaConhecimento;

	private String[] palavrasChave;

	private LocalDateTime dataCadastro;

	private String usuarioCadastro;

	private LocalDateTime dataAlteracao;

	private String usuarioAlteracao;

	public Questao(UUID id, @NotNull String enunciado, @NotNull AreaConhecimento areaConhecimento) {
		this.id = id;
		this.enunciado = enunciado;
		this.areaConhecimento = areaConhecimento;
	}

}
