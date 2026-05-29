package com.example.Grupo1.controller;

import com.example.Grupo1.model.Categoria;
import com.example.Grupo1.service.CategoriaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gestioncategorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listar(Model model, HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "GestionCategorias/gestioncategorias";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Categoria categoria, Model model) {
        String error = categoriaService.validarCategoria(categoria);
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("categorias", categoriaService.listarCategorias());
            return "GestionCategorias/gestioncategorias";
        }
        categoriaService.guardarCategoria(categoria);
        return "redirect:/gestioncategorias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/gestioncategorias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model, HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }
        model.addAttribute("categoriaEditar", categoriaService.obtenerPorId(id));
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "GestionCategorias/gestioncategorias";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Categoria categoria, Model model) {
        String error = categoriaService.validarCategoria(categoria);
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("categoriaEditar", categoria);
            model.addAttribute("categorias", categoriaService.listarCategorias());
            return "GestionCategorias/gestioncategorias";
        }
        categoriaService.guardarCategoria(categoria);
        return "redirect:/gestioncategorias";
    }
}