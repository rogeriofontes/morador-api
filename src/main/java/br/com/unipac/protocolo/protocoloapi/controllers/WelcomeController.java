package br.com.unipac.protocolo.protocoloapi.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @Value("${msg.title}")
    private String title;

    @GetMapping(value = {"/", "/welcome"})
    public String index(Model model) {
        model.addAttribute("title", title);
        return "welcome";
    }

   // @GetMapping({"/", "/welcome"})
    //public String welcome(Model model) {
    //    return "welcome";
  //  }
}