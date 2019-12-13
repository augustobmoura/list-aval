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

	public JwtTokenDTO(String email, String token) {
		this.email = email;
		this.token = token;
	}
}
