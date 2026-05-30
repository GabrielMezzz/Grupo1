package com.example.Grupo1.repository;

import com.example.Grupo1.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    List<Artista> findByEstado(String estado);
    boolean existsByNombreArtistico(String nombreArtistico);
    boolean existsByCorreo(String correo);
    boolean existsByTelefono(String telefono);
    boolean existsByFechaEvento(String fechaEvento);
    Optional<Artista> findByNombreArtistico(String nombreArtistico);
}