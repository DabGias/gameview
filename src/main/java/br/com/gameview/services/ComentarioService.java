package br.com.gameview.services;

import br.com.gameview.models.Comentario;
import br.com.gameview.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository repo;

    public List<Comentario> findAll() {
        return repo.findAll();
    }

    public void save(Comentario comentario) { repo.save(comentario); }
}
