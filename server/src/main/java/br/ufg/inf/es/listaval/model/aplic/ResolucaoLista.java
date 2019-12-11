package br.ufg.inf.es.listaval.model.aplic;

import br.ufg.inf.es.listaval.model.Discente;
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
@EqualsAndHashCode(of = {"aplicacaoLista", "discente"})
public class ResolucaoLista {

	private UUID id;

	private AplicacaoLista aplicacaoLista;

	private Discente discente;

	private List<Resposta> respostas;

	private LocalDateTime dataCadastro;

	private LocalDateTime dataAlteracao;

	public ResolucaoLista(UUID id, AplicacaoLista aplicacaoLista, Discente discente) {
		this.id = id;
		this.aplicacaoLista = aplicacaoLista;
		this.discente = discente;
	}
}
