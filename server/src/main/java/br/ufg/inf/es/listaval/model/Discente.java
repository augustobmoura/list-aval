package br.ufg.inf.es.listaval.model;

import br.ufg.inf.es.listelab.model.UsuarioLogado;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Discente extends Usuario {

	public static final String DISCENTE_ROLE = "ROLE_DISCENTE";

	public Discente() {
		this.setAuthorities(new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(DISCENTE_ROLE))));
	}

	public Discente(UsuarioLogado elabUser) {
		super(elabUser);
		this.setAuthorities(new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(DISCENTE_ROLE))));
	}

	public Discente(@NotNull String id, @NotNull String nome, @NotNull String email) {
		super(id, nome, email);
		this.setAuthorities(new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(DISCENTE_ROLE))));
	}

}
