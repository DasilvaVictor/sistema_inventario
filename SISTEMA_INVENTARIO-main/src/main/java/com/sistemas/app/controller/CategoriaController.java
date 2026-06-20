package com.sistemas.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemas.app.model.Categoria;
import com.sistemas.app.service.CategoriaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {

        model.addAttribute("categoria", new Categoria());

        return "categoria";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {

        categoriaService.createCategoria(categoria);

        return "redirect:/producto/listar?success";
    }
}

