package br.com.gameview.controllers;

import br.com.gameview.models.Desenvolvedora;
import br.com.gameview.services.DesenvolvedoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dev")
public class DesenvolvedoraController {

    @Autowired
    DesenvolvedoraService service;

    public List<Desenvolvedora> index() {
        return service.findAll();
    }
}
