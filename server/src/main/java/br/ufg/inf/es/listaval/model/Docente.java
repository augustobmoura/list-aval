package br.ufg.inf.es.listaval.model;

import br.ufg.inf.es.listelab.model.UsuarioLogado;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Docente extends Usuario {

	public static final String DOCENTE_ROLE = "ROLE_DOCENTE";

	public Docente(UsuarioLogado elabUser) {
		super(elabUser);
	}

	public Docente(@NotNull String id, @NotNull String nome, @NotNull String email) {
		super(id, nome, email);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(DOCENTE_ROLE));
	}

}
