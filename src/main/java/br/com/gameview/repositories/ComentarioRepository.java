package br.com.gameview.repositories;

import br.com.gameview.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {}
