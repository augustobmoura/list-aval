package br.ufg.inf.es.listaval.model.elab;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = {"codigo", "area", "nome"})
@EntityListeners(AuditingEntityListener.class)
public class AreaConhecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String codigo;

	@NotNull
	private String area;

	@NotNull
	private String nome;

	@CreatedDate
	private LocalDateTime dataCadastro;

	@CreatedBy
	private String usuarioCadastro;

	@LastModifiedDate
	private LocalDateTime dataAlteracao;

	@LastModifiedBy
	private String usuarioAlteracao;

	public AreaConhecimento(@NotNull String codigo, @NotNull String area, @NotNull String nome) {
		this.codigo = codigo;
		this.area = area;
		this.nome = nome;
	}
}
