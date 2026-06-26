package com.example.Grupo1.repository;

import com.example.Grupo1.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {
    List<Sede> findByEstado(String estado);
    boolean existsByNombreSede(String nombreSede);
    boolean existsByDireccionSede(String direccionSede);
    boolean existsByNombreArtista(String nombreArtista);
    boolean existsByTelefono(String telefono);
}