package br.com.gameview.services;

import br.com.gameview.models.VideoGame;
import br.com.gameview.repositories.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {

    @Autowired
    VideoGameRepository repo;

    public List<VideoGame> findAll() {
        return repo.findAll();
    }

    public Optional<VideoGame> findById(Long id) {
        return repo.findById(id);
    }

    public void save(VideoGame jogo) { repo.save(jogo); }

    public void saveAll(List<VideoGame> jogos) { repo.saveAll(jogos); }

    public boolean delete(Long id) {
        if (repo.findById(id).isEmpty()) {
            return false;
        } else {
            repo.deleteById(id);

            return true;
        }
    }
}
