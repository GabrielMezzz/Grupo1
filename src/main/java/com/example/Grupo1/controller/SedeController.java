package com.example.Grupo1.controller;

import com.example.Grupo1.model.Sede;
import com.example.Grupo1.service.SedeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gestionsedes")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping
    public String listar(Model model, HttpSession session) {

        System.out.println("Acceso al módulo de sedes");

        String rol = (String) session.getAttribute("rol");

        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }

        model.addAttribute("sedes", sedeService.listarSedes());

        return "GestionSedes/gestionSedes";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Sede sede) {
        sedeService.guardarSede(sede);
        return "redirect:/gestionsedes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        sedeService.eliminarSede(id);
        return "redirect:/gestionsedes";
    }
}