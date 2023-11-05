package br.com.gameview.controllers;

import br.com.gameview.models.Desenvolvedora;
import br.com.gameview.services.DesenvolvedoraService;
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
@RequestMapping("/devs")
public class DesenvolvedoraController {

    @Autowired
    DesenvolvedoraService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("devs", service.findAll());

        return "devs/index";
    }

    @GetMapping("/new")
    public String form(Desenvolvedora dev) {
        return "devs/form";
    }

    @PostMapping
    public String create(@Valid Desenvolvedora dev, RedirectAttributes redirect, BindingResult result) {
        if (result.hasErrors()) return "/devs";

        service.save(dev);

        redirect.addFlashAttribute("ok", "Desenvolvedora cadastrada com sucesso!");

        return "redirect:/devs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (service.delete(id)) {
            service.delete(id);

            redirect.addFlashAttribute("ok", "Desenvolvedora deletada com sucesso!");
        } else {
            redirect.addFlashAttribute("error", "Houve um erro ao deletar a desenvolvedora!");
        }

        return "redirect:/devs";
    }
}
