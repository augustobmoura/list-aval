package br.ufg.inf.es.listaval.repository;

import br.ufg.inf.es.listaval.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioBaseRepository<T extends Usuario> extends CrudRepository<T, Long> {

	T findByEmail(String email);

}
