package br.ufg.inf.es.listaval.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtTokenDTO {
	private String email;
	private String token;
	private String role;

	public JwtTokenDTO(String email, String token, String role) {
		this.email = email;
		this.token = token;
		this.role = role;
	}
}
