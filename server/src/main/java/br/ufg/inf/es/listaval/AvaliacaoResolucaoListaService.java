package br.ufg.inf.es.listaval;

import br.ufg.inf.es.listaval.model.Discente;
import br.ufg.inf.es.listaval.model.Usuario;
import br.ufg.inf.es.listaval.model.aval.AvaliacaoResolucaoLista;
import br.ufg.inf.es.listaval.repository.DiscenteRepository;
import br.ufg.inf.es.listaval.repository.UsuarioRepository;
import br.ufg.inf.es.listaval.repository.aval.AvaliacaoResolucaoListaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvaliacaoResolucaoListaService {

	private final AvaliacaoResolucaoListaRepository avaliacaoResolucaoListaRepository;
	private final UsuarioRepository usuarioRepository;
	private final DiscenteRepository discenteRepository;

	public AvaliacaoResolucaoListaService(
		AvaliacaoResolucaoListaRepository avaliacaoResolucaoListaRepository,
		UsuarioRepository usuarioRepository,
		DiscenteRepository discenteRepository
	) {
		this.avaliacaoResolucaoListaRepository = avaliacaoResolucaoListaRepository;
		this.usuarioRepository = usuarioRepository;
		this.discenteRepository = discenteRepository;
	}

	public Page<AvaliacaoResolucaoLista> findAll(Pageable pageable) {
		return avaliacaoResolucaoListaRepository.findAll(pageable);
	}

	public Page<AvaliacaoResolucaoLista> findAllMinhasListas(Pageable pageable) {
		// TODO: Filtrar avaliaçoes do usuario logado
		Optional<Discente> byEmail = discenteRepository.findByEmail("aluno1@discente.ufg.br");
		Discente discente = byEmail.orElse(null);

		return avaliacaoResolucaoListaRepository.findAllByPublicadaAndResolucaoListaDiscente(true, discente, pageable);
	}

	public Page<AvaliacaoResolucaoLista> findAllListasParaAvaliar(Pageable pageable) {
		// TODO: Filtrar avaliaçoes do usuario logado
		Optional<Usuario> byEmail = usuarioRepository.findByEmail("aluno1@discente.ufg.br");
		Usuario usuario = byEmail.orElse(null);

		return avaliacaoResolucaoListaRepository.findAllByAvaliador(usuario, pageable);
	}

	public Optional<AvaliacaoResolucaoLista> findById(Long id) {
		return avaliacaoResolucaoListaRepository.findById(id);
	}

	public AvaliacaoResolucaoLista save(AvaliacaoResolucaoLista avaliacaoResolucaoLista) {
		return avaliacaoResolucaoListaRepository.save(avaliacaoResolucaoLista);
	}

	public Optional<AvaliacaoResolucaoLista> update(Long id, AvaliacaoResolucaoLista avaliacaoResolucaoLista) {
		return avaliacaoResolucaoListaRepository.findById(id).map(record -> {
			Usuario avaliador = avaliacaoResolucaoLista.getAvaliador();
			if (avaliador != null) {
				record.setAvaliador(avaliador);
			}
			record.setPublicada(avaliacaoResolucaoLista.getPublicada());
			record.setNota(avaliacaoResolucaoLista.getNota());
			return avaliacaoResolucaoListaRepository.save(record);
		});
	}
}
