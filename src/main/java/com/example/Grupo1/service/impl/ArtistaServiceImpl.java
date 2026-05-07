package com.example.Grupo1.service.impl;

import com.example.Grupo1.model.Artista;
import com.example.Grupo1.repository.ArtistaRepository;
import com.example.Grupo1.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        artistaRepository.save(artista);
    }

    @Override
    public void eliminarArtista(Long id) {
        artistaRepository.deleteById(id);
    }
}