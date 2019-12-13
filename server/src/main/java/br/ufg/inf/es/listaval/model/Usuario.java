package br.ufg.inf.es.listaval.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = { "nome", "email" })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "dtype")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Discente.class, name = "Discente"),
	@JsonSubTypes.Type(value = Docente.class, name = "Docente")
})
public abstract class Usuario implements UserDetails {

	private String id;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	private String senha;

	public Usuario(br.ufg.inf.es.listelab.model.UsuarioLogado elabUser) {
		this(elabUser.getId(), elabUser.getEmail(), elabUser.getEmail());
	}

	public Usuario(@NotNull String id, @NotNull String nome, @NotNull String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
