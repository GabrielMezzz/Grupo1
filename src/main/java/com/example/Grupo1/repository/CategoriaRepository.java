package com.example.Grupo1.repository;

import com.example.Grupo1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByEstado(String estado);
    Optional<Categoria> findByNombre(String nombre); // ── NUEVO
}