package br.ufg.inf.es.listaval.dto;

import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aplic.Resposta;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResposta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;

@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AvaliacaoRespostaDTO extends AvaliacaoResposta {

	private Resposta resposta;
	private Usuario avaliador;
	private AvaliacaoResolucaoListaDTO avaliacaoResolucaoLista;

	public AvaliacaoRespostaDTO(Resposta resposta, Usuario avaliador, AvaliacaoResolucaoListaDTO avaliacaoResolucaoLista) {
		this.resposta = resposta;
		this.avaliador = avaliador;
		this.avaliacaoResolucaoLista = avaliacaoResolucaoLista;
	}

	public AvaliacaoResposta toAvaliacaoResposta() {
		AvaliacaoResposta avaliacaoResposta = new AvaliacaoResposta();
		avaliacaoResposta.setId(this.getId());
		avaliacaoResposta.setAvaliacaoResolucaoLista(this.avaliacaoResolucaoLista.toAvaliacaoResolucaoLista());
		avaliacaoResposta.setRespostaId(this.resposta.getId());
		avaliacaoResposta.setAvaliadorId(this.avaliador.getId());
		avaliacaoResposta.setComentario(this.getComentario());
		avaliacaoResposta.setNota(this.getNota());
		avaliacaoResposta.setPublicada(this.getPublicada());
		avaliacaoResposta.setDataCadastro(this.getDataCadastro());
		avaliacaoResposta.setDataAlteracao(this.getDataAlteracao());
		return avaliacaoResposta;
	}

}
