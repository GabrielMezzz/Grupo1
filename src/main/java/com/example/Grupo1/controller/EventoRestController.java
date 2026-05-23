package com.example.Grupo1.controller;

import com.example.Grupo1.model.Evento;
import com.example.Grupo1.service.EventoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gestioneventos")
public class EventoRestController {

    private final EventoService eventoService; //F2

    public EventoRestController(EventoService eventoService) { //F2
        this.eventoService = eventoService; //F2
    }

    @PostMapping(value = "/guardar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Evento guardar(@RequestBody Evento evento) {
        // return null; //F1
        // eventoService.guardarEvento(evento); //F2
        // return evento; //F2
        return registrarEvento(evento); //F3
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Evento> listar() {
        // return null; //F1
        // return eventoService.listarEventos(); //F2
        return obtenerEventos(); //F3
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Evento eliminar(@PathVariable Long id) {
        // return null; //F1
        return eventoService.eliminarEvento(id); //F2
    }

    @PutMapping(value = "/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Evento actualizar(@PathVariable Long id, @RequestBody Evento evento) {
        // return null; //F1
        return eventoService.actualizarEvento(id, evento); //F2
    }

    private Evento registrarEvento(Evento evento) { //F3
        return eventoService.guardarEvento(evento); //F3  ← antes descartaba el return
    }

    private List<Evento> obtenerEventos() { //F3
        return eventoService.listarEventos(); //F3
    }
}