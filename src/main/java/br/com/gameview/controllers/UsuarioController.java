package br.com.gameview.controllers;

import br.com.gameview.models.Usuario;
import br.com.gameview.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("usuarios",  service.findAll());

        return "usuarios/index";
    }

    @PostMapping
    public String create(@Valid Usuario usuario, RedirectAttributes redirect, BindingResult result) {
        if (result.hasErrors()) return "/usuarios";

        service.save(usuario);

        redirect.addFlashAttribute("ok", "Usuário cadastrado com sucesso!");

        return "redirect:/usuarios";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (service.delete(id)) {
            service.delete(id);

            redirect.addFlashAttribute("ok", "Usuário deletado com sucesso!");
        } else {
            redirect.addFlashAttribute("error", "Houve um erro ao deletar o usuário!");
        }

        return "redirect:/usuarios";
    }
}
