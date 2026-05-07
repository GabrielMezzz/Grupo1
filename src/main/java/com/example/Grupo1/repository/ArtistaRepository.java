package com.example.Grupo1.repository;

import com.example.Grupo1.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    List<Artista> findByEstado(String estado);
}