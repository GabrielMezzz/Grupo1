package com.example.Grupo1.controller;

import com.example.Grupo1.model.Artista;
import com.example.Grupo1.model.Evento;
import com.example.Grupo1.service.ArtistaService;
import com.example.Grupo1.service.EventoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gestionartistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public String listar(Model model, HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }
        model.addAttribute("artistas", artistaService.listarArtistas());
        return "GestionArtistas/gestionArtistas";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Artista artista) {
        artistaService.guardarArtista(artista);
        return "redirect:/gestionartistas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        for (Evento evento : eventoService.listarEventos()) {
            if (evento.getArtista() != null && evento.getArtista().getId().equals(id)) {
                return "redirect:/gestionartistas";
            }
        }
        artistaService.eliminarArtista(id);
        return "redirect:/gestionartistas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model, HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }
        model.addAttribute("artistaEditar", artistaService.obtenerPorId(id));
        model.addAttribute("artistas", artistaService.listarArtistas());
        return "GestionArtistas/gestionArtistas";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Artista artista) {
        artistaService.guardarArtista(artista);
        return "redirect:/gestionartistas";
    }
}
