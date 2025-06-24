package com.example.SignInPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String defaultPage(Model model){
        model.addAttribute("username","신호근");
        return "defaultPage";
    }
}
