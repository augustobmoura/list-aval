package br.ufg.inf.es.listaval.model;

import br.ufg.inf.es.listaval.model.aplic.ResolucaoLista;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Discente extends Usuario {

	@OneToMany(mappedBy = "discente", cascade = CascadeType.ALL)
	List<ResolucaoLista> resolucoes;

	public Discente(@NotNull String nome, @NotNull String email) {
		super(nome, email);
	}
}
