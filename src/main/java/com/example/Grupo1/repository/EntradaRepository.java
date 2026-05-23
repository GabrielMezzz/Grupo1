package com.example.Grupo1.repository;

import com.example.Grupo1.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    List<Entrada> findByDni(String dni);
}