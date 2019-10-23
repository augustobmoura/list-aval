package br.ufg.inf.es.listaval.model.aval;

import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aplic.Resposta;
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
public class AvaliacaoResposta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Resposta resposta;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Usuario avaliador;

	private String observacao;

	private Float nota;

	@NotNull
	private Boolean publicada;

	@CreatedDate
	private LocalDate dataCadastro;

	@LastModifiedDate
	private LocalDate dataAlteracao;

}
