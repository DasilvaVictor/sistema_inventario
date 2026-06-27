package com.sistemas.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/listar")
    public String mostrarLista(Authentication authentication,Model model) {

        model.addAttribute("usuario",authentication.getName());

        model.addAttribute("productos", productoService.getAllProductos());

        model.addAttribute("categorias", categoriaService.getAllCategorias());

        return "producto-listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {

        model.addAttribute("producto", new ProductoDTO());

        model.addAttribute("categorias", categoriaService.getAllCategorias());

        return "producto-agregar";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute ProductoDTO productoDTO) {

        productoService.createProducto(productoDTO);

        return "redirect:listar?success";
    }

    @GetMapping("/editar/{codigoProducto}")
    public String editarProducto(
            @PathVariable String codigoProducto,
            Model model) {

        ProductoDTO producto = productoService.getProductoByCodigo(codigoProducto);

        model.addAttribute("producto", producto);

        model.addAttribute("categorias", categoriaService.getAllCategorias());

        return "producto-editar";
    }

    @PostMapping("/editar")
    public String actualizarProducto(
            @ModelAttribute ProductoDTO productoDTO) {

        productoService.updateProducto(productoDTO);

        return "redirect:listar?success";
    }

    @GetMapping("/eliminar/{codigoProducto}")
    public String eliminarProducto(
            @PathVariable String codigoProducto,
            RedirectAttributes redirectAttributes) {

        productoService.deleteProducto(codigoProducto);

        redirectAttributes.addFlashAttribute("success", "Producto eliminado correctamente");
        return "redirect:/producto/listar";
    }

    @GetMapping("/buscar")
    public String buscarProducto(@RequestParam(required = false) String texto, Model model) {

        model.addAttribute("productos", productoService.buscarProductos(texto));

        return "producto-listar :: tabla-productos";
    }

}
