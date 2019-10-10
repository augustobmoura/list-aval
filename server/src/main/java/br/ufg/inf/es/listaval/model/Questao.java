package br.ufg.inf.es.listaval.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String enunciado;

}
