package br.ufg.inf.es.listaval.model.aplic;

import br.ufg.inf.es.listaval.model.elab.Questao;
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
@EqualsAndHashCode(of = {"resolucaoLista", "questao", "conteudo"})
public class Resposta {

	private UUID id;

	private ResolucaoLista resolucaoLista;

	private Questao questao;

	private String conteudo;

	private LocalDateTime dataCadastro;

	private LocalDateTime dataAlteracao;

	public Resposta(@NotNull UUID id, @NotNull ResolucaoLista resolucaoLista, @NotNull Questao questao, @NotNull String conteudo) {
		this.id = id;
		this.resolucaoLista = resolucaoLista;
		this.questao = questao;
		this.conteudo = conteudo;
	}
}
