package br.com.gameview.configs;

import br.com.gameview.models.Comentario;
import br.com.gameview.models.Desenvolvedora;
import br.com.gameview.models.Usuario;
import br.com.gameview.models.VideoGame;
import br.com.gameview.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ComentarioService comentService;

    Desenvolvedora bethesda = new Desenvolvedora("Bethesda");
    Desenvolvedora ndog = new Desenvolvedora("Naughty Dog");
    Desenvolvedora rockstar = new Desenvolvedora("Rockstar");
    Desenvolvedora fs = new Desenvolvedora("FromSoftware");
    Desenvolvedora pg = new Desenvolvedora("PlatinumGames");

    VideoGame fallout = new VideoGame("Fallout 76", LocalDate.of(2018, 11, 14), bethesda);
    VideoGame uncharted = new VideoGame("Uncharted", LocalDate.of(2007, 11, 19), ndog);
    VideoGame gtav = new VideoGame("GTA V", LocalDate.of(2013, 9, 17), rockstar);
    VideoGame ds3 = new VideoGame("Dark Souls III", LocalDate.of(2016, 3, 24), fs);
    VideoGame mgrr = new VideoGame("Metal Gear Rising: Revengance", LocalDate.of(2013, 2, 19), pg);

    Usuario zelele = new Usuario("Zé Lelé", "12345678");
    Usuario pedrinho = new Usuario("xXPedrinXx", "senhaPedro123");
    Usuario jonas = new Usuario("JonasCapaFácilXDDD", "123capudo");
    Usuario vapo = new Usuario("-- Vapador --", "123vapo123");

    @Override
    public void run(String... args) throws Exception {
        Comentario coment1 = new Comentario(2, "Odeio a Bethesda 🤬🤬!!!1111!!!", zelele, fallout);
        Comentario coment2 = new Comentario(5, "Amo a Bethesda ❤!!!", zelele, fallout);
        Comentario coment3 = new Comentario(3, "Produz jogos medíocres.", zelele, fallout);
        Comentario coment4 = new Comentario(1, "Sou muito indeciso! Esse já é meu quarto comentário!", zelele, fallout);
        Comentario coment5 = new Comentario(5, "Uncharted é o jogo da minha infância!!! Gosto demais da franquia e sempre acompanho os lançamentos da desenvolvedora!!!", pedrinho, uncharted);
        Comentario coment6 = new Comentario(4, "GTA V com certeza é um dos maiores jogos da história, muito bom essa sensação de liberdade e quão orgânico o mundo aberto aparenta!", jonas, gtav);
        Comentario coment7 = new Comentario(5, "Dark Souls é uma das franquias mais polêmicas que existem, muitos dizem que é muito difícil e muitos dizem que é uma obra de arte a ser apreciada.", jonas, ds3);
        Comentario coment8 = new Comentario(4, "c loko ninja de salto alto e muito rock 🐱‍🏍", vapo, mgrr);

        comentService.saveAll(List.of(coment1, coment2, coment3, coment4, coment5, coment6, coment7, coment8));
    }
}
