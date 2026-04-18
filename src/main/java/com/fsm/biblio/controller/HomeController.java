package com.fsm.biblio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        // You can change 'VOTRE_NOM' to your actual name
        model.addAttribute("userName", "ghada");
        return "index";
    }
}
