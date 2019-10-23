package br.ufg.inf.es.listaval.model.aplic;

import br.ufg.inf.es.listaval.model.Discente;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class ResolucaoLista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private AplicacaoLista aplicacaoLista;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Discente discente;

	@OneToMany(mappedBy = "resolucaoLista", cascade = CascadeType.ALL)
	private List<Resposta> respostas;

	@CreatedDate
	private LocalDate dataCadastro;

	@LastModifiedDate
	private LocalDate dataAlteracao;

}
