package com.example.Grupo1.service;

import com.example.Grupo1.model.Sede;
import java.util.List;

public interface SedeService {

    // Métodos principales del servicio de sedes
    List<Sede> listarSedes();

    List<Sede> listarSedesActivas();

    void guardarSede(Sede sede);

    void eliminarSede(Long id);
}