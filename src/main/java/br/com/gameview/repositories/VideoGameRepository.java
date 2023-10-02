package br.com.gameview.repositories;

import br.com.gameview.models.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {}
