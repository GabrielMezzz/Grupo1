package com.example.Grupo1.service.impl;

import com.example.Grupo1.model.Evento;
import com.example.Grupo1.repository.EventoRepository;
import com.example.Grupo1.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Evento buscarPorNombre(String nombre) { return eventoRepository.findByNombre(nombre).orElse(null); }

    @Override
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public List<Evento> listarEventosActivos() {
        return eventoRepository.findByEstado("Activo");
    }

    @Override
    public void guardarEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    @Override
    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Evento> listarEventosActivosPorCategoria(String categoria) {
        return eventoRepository.findByEstadoAndCategoria("Activo", categoria);
    }
}