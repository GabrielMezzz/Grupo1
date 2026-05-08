package com.example.Grupo1.service;

import com.example.Grupo1.model.Evento;
import java.util.List;

public interface EventoService {

    // Métodos del servicio de eventos
    List<Evento> listarEventos();

    List<Evento> listarEventosActivos();

    void guardarEvento(Evento evento);

    void eliminarEvento(Long id);

    Evento buscarPorId(Long id);
}