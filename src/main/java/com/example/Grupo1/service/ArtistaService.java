package com.example.Grupo1.service;

import com.example.Grupo1.model.Artista;
import java.util.List;

public interface ArtistaService {
    List<Artista> listarArtistas();
    List<Artista> listarArtistasActivos();
    void guardarArtista(Artista artista);
    void eliminarArtista(Long id);
    Artista obtenerPorId(Long id);
}