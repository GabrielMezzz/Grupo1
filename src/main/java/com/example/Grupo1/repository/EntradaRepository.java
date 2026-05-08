package com.example.Grupo1.repository;

import com.example.Grupo1.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {

    // Repositorio principal de entradas
}