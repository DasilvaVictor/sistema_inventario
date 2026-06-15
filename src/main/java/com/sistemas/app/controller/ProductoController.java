package com.sistemas.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemas.app.dto.ProductoDTO;
import com.sistemas.app.service.CategoriaService;
import com.sistemas.app.service.ProductoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {

        model.addAttribute("producto", new ProductoDTO());

        model.addAttribute("categorias", categoriaService.getAllCategorias());

        return "producto";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute ProductoDTO productoDTO) {

        productoService.createProducto(productoDTO);

        return "redirect:/inicio?success";
    }


}
