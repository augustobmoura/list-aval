package br.ufg.inf.es.listaval.model.aval;

import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AvaliacaoResolucaoLista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private ResolucaoLista resolucaoLista;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Usuario avaliador;

	private Boolean publicada;

	private Float nota;

	@OneToMany(mappedBy = "avaliacaoResolucaoLista", cascade = CascadeType.ALL)
	private List<AvaliacaoResposta> avaliacoesRespostas;

	@CreatedDate
	private LocalDateTime dataCadastro;

	@CreatedBy
	private String usuarioCadastro;

	@LastModifiedDate
	private LocalDateTime dataAlteracao;

	@LastModifiedBy
	private String usuarioAlteracao;

	public AvaliacaoResolucaoLista(@NotNull ResolucaoLista resolucaoLista, @NotNull Usuario avaliador) {
		this.resolucaoLista = resolucaoLista;
		this.avaliador = avaliador;
	}
}
