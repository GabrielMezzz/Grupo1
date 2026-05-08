package com.example.Grupo1.repository;

import com.example.Grupo1.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    // Consulta eventos por estado
    List<Evento> findByEstado(String estado);
}