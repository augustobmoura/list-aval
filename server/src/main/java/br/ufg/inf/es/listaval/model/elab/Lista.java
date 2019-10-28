package br.ufg.inf.es.listaval.model.elab;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Lista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable()
	private List<Questao> questoes;

	@CreatedDate
	private LocalDateTime dataCadastro;

	@CreatedBy
	private String usuarioCadastro;

	@LastModifiedDate
	private LocalDateTime dataAlteracao;

	@LastModifiedBy
	private String usuarioAlteracao;

}
