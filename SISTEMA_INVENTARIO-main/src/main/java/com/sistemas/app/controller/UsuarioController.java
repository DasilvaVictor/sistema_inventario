package com.sistemas.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping("/usuarios")
    public String mostrarUsuarios() {
        return "usuarios"; 
    }
}