package br.com.gameview.controllers;

import br.com.gameview.models.VideoGame;
import br.com.gameview.services.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/jogo")
public class VideoGameController {

    @Autowired
    VideoGameService service;

    public List<VideoGame> index() {
        return service.findAll();
    }
}
