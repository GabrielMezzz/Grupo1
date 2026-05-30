package com.example.Grupo1.service.impl;

import com.example.Grupo1.model.Artista;
import com.example.Grupo1.repository.ArtistaRepository;
import com.example.Grupo1.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public List<Artista> listarArtistas() {
        return artistaRepository.findAll();
    }

    @Override
    public List<Artista> listarArtistasActivos() {
        return artistaRepository.findByEstado("Activo");
    }

    @Override
    public void guardarArtista(Artista artista) {
        validarUnicidad(artista);
        artistaRepository.save(artista);
    }

    @Override
    public void descontarCapacidad(String nombreArtistico, int cantidad) {
        Optional<Artista> artistaOpt = artistaRepository.findByNombreArtistico(nombreArtistico);
        if (artistaOpt.isPresent()) {
            Artista artista = artistaOpt.get();
            int nuevaCapacidad = artista.getCapacidadSede() - cantidad;
            if (nuevaCapacidad < 0) nuevaCapacidad = 0;
            artista.setCapacidadSede(nuevaCapacidad);
            artistaRepository.save(artista);
        }
    }

    @Override
    public void eliminarArtista(Long id) {
        artistaRepository.deleteById(id);
    }

    @Override
    public Artista obtenerPorId(Long id) {
        return artistaRepository.findById(id).orElseThrow();
    }

    private void validarUnicidad(Artista artista) {
        Artista artistaActual = null;
        if (artista.getId() != null) {
            artistaActual = artistaRepository.findById(artista.getId()).orElse(null);
        }

        if (artista.getNombreArtistico() != null) {
            boolean mismoNombre = artistaActual != null && artista.getNombreArtistico().equals(artistaActual.getNombreArtistico());
            if (!mismoNombre && artistaRepository.existsByNombreArtistico(artista.getNombreArtistico())) {
                throw new IllegalArgumentException("El nombre artístico ya está registrado");
            }
        }

        if (artista.getCorreo() != null) {
            boolean mismoCorreo = artistaActual != null && artista.getCorreo().equals(artistaActual.getCorreo());
            if (!mismoCorreo && artistaRepository.existsByCorreo(artista.getCorreo())) {
                throw new IllegalArgumentException("El correo ya está registrado");
            }
        }

        if (artista.getTelefono() != null) {
            boolean mismoTelefono = artistaActual != null && artista.getTelefono().equals(artistaActual.getTelefono());
            if (!mismoTelefono && artistaRepository.existsByTelefono(artista.getTelefono())) {
                throw new IllegalArgumentException("El teléfono ya está registrado");
            }
        }

        if (artista.getFechaEvento() != null) {
            boolean mismaFecha = artistaActual != null && artista.getFechaEvento().equals(artistaActual.getFechaEvento());
            if (!mismaFecha && artistaRepository.existsByFechaEvento(artista.getFechaEvento())) {
                throw new IllegalArgumentException("Ya existe un artista registrado para esa fecha");
            }
        }
    }
}