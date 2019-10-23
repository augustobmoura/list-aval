package br.ufg.inf.es.listaval.repository;

import br.ufg.inf.es.listaval.model.Disciplina;
import org.springframework.data.repository.CrudRepository;

public interface TurmaRepository extends CrudRepository<Disciplina, Long> {

}
