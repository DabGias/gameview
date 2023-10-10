package br.com.gameview.services;

import br.com.gameview.models.Comentario;
import br.com.gameview.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository repo;

    public List<Comentario> findAll() {
        return repo.findAll();
    }

    public Optional<Comentario> findById(Long id) {
        return repo.findById(id);
    }

    public void save(Comentario comentario) { repo.save(comentario); }

    public boolean delete(Long id) {
        if (repo.findById(id).isEmpty()) {
            return false;
        } else {
            repo.deleteById(id);

            return true;
        }
    }
}
