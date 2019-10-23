package br.ufg.inf.es.listaval.model.aplic;

import br.ufg.inf.es.listaval.model.elab.Questao;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Resposta {

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
	private Questao questao;

	@NotNull
	private String conteudo;

	private Float nota;

	@CreatedDate
	private LocalDate dataCadastro;

	@LastModifiedDate
	private LocalDate dataAlteracao;

}
