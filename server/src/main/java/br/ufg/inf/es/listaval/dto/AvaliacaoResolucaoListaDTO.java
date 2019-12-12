package br.ufg.inf.es.listaval.dto;

import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResposta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class AvaliacaoResolucaoListaDTO extends AvaliacaoResolucaoLista {

	private ResolucaoLista resolucaoLista;
	private Usuario avaliador;
	private List<AvaliacaoRespostaDTO> avaliacoesRespostas;

	public AvaliacaoResolucaoListaDTO(
			@NotNull ResolucaoLista resolucaoLista,
			@NotNull Usuario avaliador,
			@NotNull AvaliacaoResolucaoLista parent
	) {
		super(resolucaoLista.getId(), avaliador.getId());
		this.resolucaoLista = resolucaoLista;
		this.avaliador = avaliador;

		super.setId(parent.getId());
		super.setDiscenteId(parent.getDiscenteId());
		super.setPublicada(parent.getPublicada());
		super.setNota(parent.getNota());
		if (this.avaliacoesRespostas != null) {
			List<AvaliacaoResposta> avaliacaoRespostas = buidAvaliacoesRespostasSaved(this.avaliacoesRespostas);
			super.setAvaliacoesRespostasSaved(avaliacaoRespostas);
		}
		super.setDataCadastro(parent.getDataCadastro());
		super.setUsuarioCadastro(parent.getUsuarioCadastro());
		super.setDataAlteracao(parent.getDataAlteracao());
		super.setUsuarioAlteracao(parent.getUsuarioAlteracao());
	}

	public AvaliacaoResolucaoLista toAvaliacaoResolucaoLista() {
		AvaliacaoResolucaoLista avaliacaoResolucaoLista = new AvaliacaoResolucaoLista(this.resolucaoLista.getId(), this.avaliador.getId());
		avaliacaoResolucaoLista.setId(this.getId());
		avaliacaoResolucaoLista.setDiscenteId(this.resolucaoLista.getDiscente().getId());
		avaliacaoResolucaoLista.setPublicada(this.getPublicada());
		avaliacaoResolucaoLista.setNota(this.getNota());

		if (this.avaliacoesRespostas != null) {
			List<AvaliacaoResposta> avaliacoesRespostas = buidAvaliacoesRespostasSaved(this.avaliacoesRespostas);
			avaliacaoResolucaoLista.setAvaliacoesRespostasSaved(avaliacoesRespostas);
		}
		avaliacaoResolucaoLista.setDataCadastro(this.getDataCadastro());
		avaliacaoResolucaoLista.setUsuarioCadastro(this.getUsuarioCadastro());
		avaliacaoResolucaoLista.setDataAlteracao(this.getDataAlteracao());
		avaliacaoResolucaoLista.setUsuarioAlteracao(this.getUsuarioAlteracao());

		return avaliacaoResolucaoLista;
	}

	private List<AvaliacaoResposta> buidAvaliacoesRespostasSaved(List<AvaliacaoRespostaDTO> avaliacoesRespostas) {
		return avaliacoesRespostas
				.stream()
				.map(AvaliacaoRespostaDTO::toAvaliacaoResposta)
				.collect(Collectors.toList());
	}
}
