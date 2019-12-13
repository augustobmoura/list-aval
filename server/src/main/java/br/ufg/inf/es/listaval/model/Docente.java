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
public class Docente extends Usuario {

	public static final String DOCENTE_ROLE = "ROLE_DOCENTE";

	public Docente() {
		this.setAuthorities(new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(DOCENTE_ROLE))));
	}

	public Docente(UsuarioLogado elabUser) {
		super(elabUser);
		this.setAuthorities(new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(DOCENTE_ROLE))));
	}

	public Docente(@NotNull String id, @NotNull String nome, @NotNull String email) {
		super(id, nome, email);
		this.setAuthorities(new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(DOCENTE_ROLE))));
	}

}
