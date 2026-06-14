package com.sistemas.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistemas.app.dto.UsuarioRequestDTO;
import com.sistemas.app.service.ILoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistroController {

    private final ILoginService loginService;

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {

        model.addAttribute("usuario", new UsuarioRequestDTO());

        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(UsuarioRequestDTO usuario, Model model) {

        loginService.createUser(usuario);

        return "redirect:/login";
    }
}