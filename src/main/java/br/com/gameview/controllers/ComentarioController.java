package br.com.gameview.controllers;

import br.com.gameview.models.Comentario;
import br.com.gameview.services.ComentarioService;
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
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    ComentarioService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("coments", service.findAll());

        return "comentarios/index";
    }

    @PostMapping
    public String create(@Valid Comentario coment, RedirectAttributes redirect, BindingResult result) {
        if (result.hasErrors()) return "/comentarios";

        service.save(coment);

        redirect.addFlashAttribute("ok", "Comentário cadastrado com sucesso!");

        return "redirect:/comentarios";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (service.delete(id)) {
            service.delete(id);

            redirect.addFlashAttribute("ok", "Comentário deletado com sucesso!");
        } else {
            redirect.addFlashAttribute("error", "Houve um erro ao apagar o comentário!");
        }

        return "redirect:/comentarios";
    }
}
