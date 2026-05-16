package com.example.Grupo1.controller;

import com.example.Grupo1.model.Evento;
import com.example.Grupo1.service.ArtistaService;
import com.example.Grupo1.service.CategoriaService;
import com.example.Grupo1.service.EventoService;
import com.example.Grupo1.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/gestioneventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private SedeService sedeService;

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
        model.addAttribute("sedes", sedeService.listarSedesActivas());
        model.addAttribute("categorias", categoriaService.listarCategoriasActivas());
        model.addAttribute("artistas", artistaService.listarArtistasActivos());
        return "GestionEventos/gestioneventos";
    }

//    @PostMapping("/guardar") //F1
//    public String guardar(@ModelAttribute Evento evento) { //F1
//        eventoService.guardarEvento(evento); //F1
//        return "redirect:/gestioneventos"; //F1
//    } //F1

//    @GetMapping("/eliminar/{id}") //F1
//    public String eliminar(@PathVariable Long id) { //F1
//        eventoService.eliminarEvento(id); //F1
//        return "redirect:/gestioneventos"; //F1
//    } //F1
}
