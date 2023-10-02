package br.com.gameview.services;

import br.com.gameview.models.Usuario;
import br.com.gameview.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    public List<Usuario> findAll() {
        return repo.findAll();
    }
}
