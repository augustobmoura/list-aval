package br.ufg.inf.es.listaval.model.aplic;

import br.ufg.inf.es.listaval.model.Turma;
import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.elab.Lista;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class AplicacaoLista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Lista lista;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Turma turma;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Usuario avaliador;

	@OneToMany(mappedBy = "aplicacaoLista", cascade = CascadeType.ALL)
	private List<ResolucaoLista> resolucoes;

	@CreatedDate
	private LocalDate dataCadastro;

	@ManyToOne
	@JoinColumn
	@CreatedBy
	private Usuario usuarioCadastro;

}
