package br.com.gameview.controllers;

import br.com.gameview.models.Usuario;
import br.com.gameview.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public List<Usuario> index() {
        return service.findAll();
    }
}
