package com.example.Grupo1.controller;

import com.example.Grupo1.model.Artista;
import com.example.Grupo1.model.Evento;
import com.example.Grupo1.service.ArtistaService;
import com.example.Grupo1.service.CategoriaService;
import com.example.Grupo1.service.EventoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gestioneventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public String listar(Model model, HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }
        model.addAttribute("eventos", eventoService.listarEventos());
        model.addAttribute("evento", new Evento());
        model.addAttribute("categorias", categoriaService.listarCategoriasActivas());
        model.addAttribute("artistas", artistaService.listarArtistas());
        return "GestionEventos/gestioneventos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Evento evento, @RequestParam Long artistaId) {
        Artista artista = artistaService.obtenerPorId(artistaId);
        evento.setArtista(artista);
        eventoService.guardarEvento(evento);
        return "redirect:/gestioneventos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
        return "redirect:/gestioneventos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model, HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }
        model.addAttribute("eventoEditar", eventoService.buscarPorId(id));
        model.addAttribute("eventos", eventoService.listarEventos());
        model.addAttribute("categorias", categoriaService.listarCategoriasActivas());
        model.addAttribute("artistas", artistaService.listarArtistas());
        return "GestionEventos/gestioneventos";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Evento evento, @RequestParam Long artistaId) {
        Artista artista = artistaService.obtenerPorId(artistaId);
        evento.setArtista(artista);
        eventoService.guardarEvento(evento);
        return "redirect:/gestioneventos";
    }
}
