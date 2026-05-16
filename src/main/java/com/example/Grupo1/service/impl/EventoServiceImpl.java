package com.example.Grupo1.service.impl;

import com.example.Grupo1.model.Evento;
import com.example.Grupo1.repository.EventoRepository;
import com.example.Grupo1.service.EventoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

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
//    public void eliminarEvento(Long id) { //F1
//        eventoRepository.deleteById(id); //F1
//    } //F1

    public Evento eliminarEvento(Long id) {
        // Evento evento = buscarPorId(id); //F2
        // eventoRepository.deleteById(id); //F2
        // return evento; //F2
        return borrarEvento(id); //F3
    }

    @Override
    public Evento actualizarEvento(Long id, Evento evento) {
        // Evento eventoExistente = buscarPorId(id); //F1
        // eventoExistente.setNombre(evento.getNombre()); //F1
        // eventoExistente.setCategoria(evento.getCategoria()); //F1
        // eventoExistente.setFecha(evento.getFecha()); //F1
        // eventoExistente.setSede(evento.getSede()); //F1
        // eventoExistente.setPrecio(evento.getPrecio()); //F1
        // eventoExistente.setCapacidad(evento.getCapacidad()); //F1
        // eventoExistente.setArtista(evento.getArtista()); //F1
        // eventoExistente.setEstado(evento.getEstado()); //F1
        // return eventoRepository.save(eventoExistente); //F1
        // return guardarEventoActualizado(id, evento); //F2
        return actualizarEventoActualizado(id, evento); //F3
    }

    @Override
    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    private Evento borrarEvento(Long id) { //F3
        Evento evento = buscarPorId(id); //F3
        eventoRepository.deleteById(id); //F3
        return evento; //F3
    }

    private Evento guardarEventoActualizado(Long id, Evento evento) { //F2
        Evento eventoExistente = buscarPorId(id); //F2
        eventoExistente.setNombre(evento.getNombre()); //F2
        eventoExistente.setCategoria(evento.getCategoria()); //F2
        eventoExistente.setFecha(evento.getFecha()); //F2
        eventoExistente.setSede(evento.getSede()); //F2
        eventoExistente.setPrecio(evento.getPrecio()); //F2
        eventoExistente.setCapacidad(evento.getCapacidad()); //F2
        eventoExistente.setArtista(evento.getArtista()); //F2
        eventoExistente.setEstado(evento.getEstado()); //F2
        return eventoRepository.save(eventoExistente); //F2
    }

    private Evento actualizarEventoActualizado(Long id, Evento evento) { //F3
        Evento eventoExistente = buscarPorId(id); //F3
        BeanUtils.copyProperties(evento, eventoExistente, "id"); //F3
        return eventoRepository.save(eventoExistente); //F3
    }
}
