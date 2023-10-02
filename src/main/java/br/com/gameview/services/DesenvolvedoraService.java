package br.com.gameview.services;

import br.com.gameview.models.Desenvolvedora;
import br.com.gameview.repositories.DesenvolvedoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesenvolvedoraService {

    @Autowired
    DesenvolvedoraRepository repo;

    public List<Desenvolvedora> findAll() {
        return repo.findAll();
    }
}
