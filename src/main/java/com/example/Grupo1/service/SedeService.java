package com.example.Grupo1.service;

import com.example.Grupo1.model.Sede;
import java.util.List;

public interface SedeService {
    List<Sede> listarSedes();
    List<Sede> listarSedesActivas();
    void guardarSede(Sede sede);
    void eliminarSede(Long id);
    Sede obtenerPorId(Long id);  // ── NUEVO
}