package br.com.gameview.controllers;

import br.com.gameview.models.Comentario;
import br.com.gameview.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    ComentarioService service;

    public List<Comentario> index() {
        return service.findAll();
    }
}
