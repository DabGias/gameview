package br.com.gameview.services;

import br.com.gameview.models.VideoGame;
import br.com.gameview.repositories.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoGameService {

    @Autowired
    VideoGameRepository repo;

    public List<VideoGame> findAll() {
        return repo.findAll();
    }

    public void save(VideoGame jogo) { repo.save(jogo); }
}
