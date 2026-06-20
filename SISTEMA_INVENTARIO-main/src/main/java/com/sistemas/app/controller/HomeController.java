package com.sistemas.app.controller;

import com.sistemas.app.service.CategoriaService;
import com.sistemas.app.service.ProductoService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/inicio")
    public String inicio(Authentication authentication, Model model) {

        model.addAttribute("usuario",authentication.getName());

        return "inicio";
    }
}