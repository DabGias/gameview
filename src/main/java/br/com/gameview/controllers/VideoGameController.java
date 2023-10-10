package br.com.gameview.controllers;

import br.com.gameview.models.VideoGame;
import br.com.gameview.services.VideoGameService;
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
@RequestMapping("/jogos")
public class VideoGameController {

    @Autowired
    VideoGameService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("jogos", service.findAll());

        return "jogos/index";
    }

    @PostMapping
    public String create(@Valid VideoGame jogo, RedirectAttributes redirect, BindingResult result) {
        if (result.hasErrors()) return "/jogos";

        service.save(jogo);

        redirect.addFlashAttribute("ok", "Jogo cadastrado com sucesso!");

        return "redirect:/jogos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (service.delete(id)) {
            service.delete(id);

            redirect.addFlashAttribute("ok", "Jogo deletado com sucesso!");
        } else {
            redirect.addFlashAttribute("error", "Houve um erro ao deletar o jogo!");
        }

        return "redirect:/jogos";
    }
}
