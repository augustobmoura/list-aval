package br.ufg.inf.es.listaval.repository;

import br.ufg.inf.es.listaval.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioBaseRepository<T extends Usuario> extends CrudRepository<T, Long> {

	Optional<T> findByEmail(String email);

}
