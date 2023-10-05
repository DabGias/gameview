package br.com.gameview.configs;

import br.com.gameview.models.Comentario;
import br.com.gameview.models.Desenvolvedora;
import br.com.gameview.models.Usuario;
import br.com.gameview.models.VideoGame;
import br.com.gameview.services.ComentarioService;
import br.com.gameview.services.DesenvolvedoraService;
import br.com.gameview.services.UsuarioService;
import br.com.gameview.services.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ComentarioService comentService;

    @Override
    public void run(String... args) throws Exception {
        Desenvolvedora dev = new Desenvolvedora("Bethesda");
        VideoGame jogo = new VideoGame("Fallout", LocalDate.now(), dev);
        Usuario user = new Usuario("Zé Lelé", "12345678");
        Comentario coment = new Comentario(2, "Odeio a Bethesda 🤬🤬!!!1111!!!", user, jogo);

        comentService.save(coment);
    }
}
