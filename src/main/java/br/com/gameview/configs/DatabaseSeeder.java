package br.com.gameview.configs;

import br.com.gameview.models.Comentario;
import br.com.gameview.models.Desenvolvedora;
import br.com.gameview.models.VideoGame;
import br.com.gameview.services.ComentarioService;
import br.com.gameview.services.DesenvolvedoraService;
import br.com.gameview.services.VideoGameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    ComentarioService comentService;

    @Autowired
    VideoGameService jogoService;

    @Autowired
    DesenvolvedoraService devService;

    Desenvolvedora bethesda = new Desenvolvedora("Bethesda");
    Desenvolvedora ndog = new Desenvolvedora("Naughty Dog");
    Desenvolvedora rockstar = new Desenvolvedora("Rockstar");
    Desenvolvedora fs = new Desenvolvedora("FromSoftware");
    Desenvolvedora pg = new Desenvolvedora("PlatinumGames");

    VideoGame fallout = new VideoGame("Fallout 76", LocalDate.of(2018, 11, 14), "Bethesda");
    VideoGame uncharted = new VideoGame("Uncharted", LocalDate.of(2007, 11, 19), "Naughty Dog");
    VideoGame gtav = new VideoGame("GTA V", LocalDate.of(2013, 9, 17), "Rockstar");
    VideoGame ds3 = new VideoGame("Dark Souls III", LocalDate.of(2016, 3, 24), "FromSoftware");
    VideoGame mgrr = new VideoGame("Metal Gear Rising: Revengance", LocalDate.of(2013, 2, 19), "PlatinumGames");

    Comentario coment1 = new Comentario(2, "Odeio a Bethesda 🤬🤬!!!1111!!!", "John Doe", "Fallout 76");
    Comentario coment2 = new Comentario(5, "Amo a Bethesda ❤!!!", "John Doe", "Fallout 76");
    Comentario coment3 = new Comentario(3, "Produz jogos medíocres.", "John Doe", "Fallout 76");
    Comentario coment4 = new Comentario(1, "Sou muito indeciso! Esse já é meu quarto comentário!", "DabGias", "Fallout 76");
    Comentario coment5 = new Comentario(5, "Uncharted é o jogo da minha infância!!! Gosto demais da franquia e sempre acompanho os lançamentos da desenvolvedora!!!", "Pedrinho", "Uncharted");
    Comentario coment6 = new Comentario(4, "GTA V com certeza é um dos maiores jogos da história, muito bom essa sensação de liberdade e quão orgânico o mundo aberto aparenta!", "Jonas", "GTA V");
    Comentario coment7 = new Comentario(5, "Dark Souls é uma das franquias mais polêmicas que existem, muitos dizem que é muito difícil e muitos dizem que é uma obra de arte a ser apreciada.", "Jonas", "Dark Souls III");
    Comentario coment8 = new Comentario(4, "c loko ninja de salto alto e muito rock 🐱‍🏍", "DabGias", "Metal Gear Rising: Revengance");

    @Override
    public void run(String... args) throws Exception {
        comentService.saveAll(List.of(coment1, coment2, coment3, coment4, coment5, coment6, coment7, coment8));
        jogoService.saveAll(List.of(fallout, uncharted, gtav, ds3, mgrr));
        devService.saveAll(List.of(bethesda, ndog, rockstar, fs, pg));
    }
}
