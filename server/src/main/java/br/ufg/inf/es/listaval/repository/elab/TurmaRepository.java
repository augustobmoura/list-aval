package br.ufg.inf.es.listaval.repository.elab;

import br.ufg.inf.es.listaplic.ClassroomControllerApi;
import br.ufg.inf.es.listaplic.invoker.ApiException;
import br.ufg.inf.es.listaplic.model.Classroom;
import br.ufg.inf.es.listaval.model.Disciplina;
import br.ufg.inf.es.listaval.model.Docente;
import br.ufg.inf.es.listaval.model.Turma;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class TurmaRepository {

	final ClassroomControllerApi classroomControllerApi;
	final DisciplinaRepository disciplinaRepository;

	public TurmaRepository(
			ClassroomControllerApi classroomControllerApi,
			DisciplinaRepository disciplinaRepository
	) {
		this.classroomControllerApi = classroomControllerApi;
		this.disciplinaRepository = disciplinaRepository;
	}

	public Optional<Turma> findById(UUID id) {
		try {
			Classroom classroom = this.classroomControllerApi.findByIdUsingGET(id);
			Optional<Disciplina> disciplina = disciplinaRepository.findByCode(classroom.getSubjectCode());
			if (!disciplina.isPresent()) {
				throw new IllegalStateException("Disciplina nao encontrada");
			}

			Docente docente = new Docente(null, "Professor Pasquale", "pasquale@ufg.br");
			Turma turma = new Turma(classroom.getId(), disciplina.get(), "2019/2", docente);
			return Optional.of(turma);
		} catch (ApiException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

}
