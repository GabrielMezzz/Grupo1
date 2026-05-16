package com.example.Grupo1.service;

import com.example.Grupo1.model.Evento;
import java.util.List;

public interface EventoService {
    List<Evento> listarEventos();
    List<Evento> listarEventosActivos();
    void guardarEvento(Evento evento);
//    void eliminarEvento(Long id); //F1
    Evento eliminarEvento(Long id); //F2
    Evento actualizarEvento(Long id, Evento evento);
    Evento buscarPorId(Long id);
}
