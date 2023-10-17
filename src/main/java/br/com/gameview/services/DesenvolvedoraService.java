package br.com.gameview.services;

import br.com.gameview.models.Desenvolvedora;
import br.com.gameview.repositories.DesenvolvedoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesenvolvedoraService {

    @Autowired
    DesenvolvedoraRepository repo;

    public List<Desenvolvedora> findAll() {
        return repo.findAll();
    }

    public Optional<Desenvolvedora> findById(Long id) {
        return repo.findById(id);
    }

    public void save(Desenvolvedora dev) { repo.save(dev); }

    public void saveAll(List<Desenvolvedora> desenvolvedoras) { repo.saveAll(desenvolvedoras); }

    public boolean delete(Long id) {
        if (repo.findById(id).isEmpty()) {
            return false;
        } else {
            repo.deleteById(id);

            return true;
        }
    }
}
