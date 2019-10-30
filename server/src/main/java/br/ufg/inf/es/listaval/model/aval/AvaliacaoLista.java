package br.ufg.inf.es.listaval.model.aval;

import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aplic.AplicacaoLista;
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
public class AvaliacaoLista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private AplicacaoLista aplicacaoLista;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable()
	private List<Usuario> avaliadores;

	@NotNull
	@Enumerated(EnumType.STRING)
	private CriterioAvaliacao criterioAvaliacao;

	@CreatedDate
	private LocalDateTime dataCadastro;

	@CreatedBy
	private String usuarioCadastro;

	@LastModifiedDate
	private LocalDateTime dataAlteracao;

	@LastModifiedBy
	private String usuarioAlteracao;

}
