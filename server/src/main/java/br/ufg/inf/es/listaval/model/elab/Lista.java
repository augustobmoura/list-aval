package br.ufg.inf.es.listaval.model.elab;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Lista {

	private UUID id;

	private List<Questao> questoes;

	private LocalDateTime dataCadastro;

	private String usuarioCadastro;

	private LocalDateTime dataAlteracao;

	private String usuarioAlteracao;

	public Lista(UUID id, List<Questao> questoes) {
		this.id = id;
		this.questoes = questoes;
	}

	public Lista(List<Questao> questoes) {
		this.questoes = questoes;
	}

}
