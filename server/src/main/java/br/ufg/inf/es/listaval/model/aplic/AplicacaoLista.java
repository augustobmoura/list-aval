package br.ufg.inf.es.listaval.model.aplic;

import br.ufg.inf.es.listaval.model.Turma;
import br.ufg.inf.es.listaval.model.elab.Lista;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"lista", "turma"})
public class AplicacaoLista {

	private UUID id;

	@NotNull
	private Lista lista;

	@NotNull
	private Turma turma;

	private List<ResolucaoLista> resolucoes;

	private LocalDateTime dataCadastro;

	private String usuarioCadastro;

	public AplicacaoLista(@NotNull UUID id, @NotNull Lista lista, @NotNull Turma turma) {
		this.id = id;
		this.lista = lista;
		this.turma = turma;
	}
}
