package com.example.Grupo1.service;

import com.example.Grupo1.model.Entrada;
import java.util.List;

public interface EntradaService {
    List<Entrada> listarEntradas();
    List<Entrada> listarEntradasPorDni(String dni); // ── NUEVO
    void guardarEntrada(Entrada entrada);
    void eliminarEntrada(Long id);
    Double calcularIngresos();
}