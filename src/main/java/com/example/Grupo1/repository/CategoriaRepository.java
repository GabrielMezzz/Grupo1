package com.example.Grupo1.repository;

import com.example.Grupo1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Consulta categorías según estado
    List<Categoria> findByEstado(String estado);
}