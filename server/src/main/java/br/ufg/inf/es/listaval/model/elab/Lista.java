package br.ufg.inf.es.listaval.model.elab;

import br.ufg.inf.es.listaval.model.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable()
	private List<Questao> questoes;

	@CreatedDate
	private LocalDate dataCadastro;

	@ManyToOne
	@JoinColumn
	@CreatedBy
	private Usuario usuarioCadastro;

	@LastModifiedDate
	private LocalDate dataAlteracao;

	@ManyToOne
	@JoinColumn
	@LastModifiedBy
	private Usuario usuarioAlteracao;

}
