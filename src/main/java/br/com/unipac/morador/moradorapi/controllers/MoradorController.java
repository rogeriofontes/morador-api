package br.com.unipac.morador.moradorapi.controllers;

import br.com.unipac.morador.moradorapi.modelo.domain.Morador;
import br.com.unipac.morador.moradorapi.modelo.repositorio.MoradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/moradores/")
public class MoradorController {

    @Autowired
    private MoradorRepositorio moradorRepositorio;

    @GetMapping("lista")
    public String lista(Model model) {
        model.addAttribute("listaDeMoradores", moradorRepositorio.findAll());
        return "index";
    }

    @GetMapping("adicionar")
    public String addMoradores(Morador morador) {
        return "add-morador";
    }

    @PostMapping("add")
    public String addMorador(Morador morador, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-morador";
        }

        moradorRepositorio.save(morador);

        return "redirect:lista";
    }
}
