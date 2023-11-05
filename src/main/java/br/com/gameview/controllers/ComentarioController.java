package br.com.gameview.controllers;

import br.com.gameview.models.Comentario;
import br.com.gameview.services.ComentarioService;
import br.com.gameview.services.VideoGameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
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

    @Autowired
    VideoGameService jogoService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("coments", service.findAll());

        return "comentarios/index";
    }

    @GetMapping("/new")
    public String form(Comentario coment, Model model) {
        model.addAttribute("jogos", jogoService.findAll());

        return "comentarios/form";
    }

    @PostMapping
    public String create(@Valid Comentario coment, @AuthenticationPrincipal OAuth2User user, RedirectAttributes redirect, BindingResult result) {
        if (result.hasErrors()) return "/comentarios";

        coment.setUsuario(user.getAttribute("name"));

        System.out.println(coment);

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
