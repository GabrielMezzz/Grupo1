package com.example.Grupo1.service;

import com.example.Grupo1.model.Entrada;
import java.util.List;

public interface EntradaService {
    List<Entrada> listarEntradas();
    void guardarEntrada(Entrada entrada);
    void eliminarEntrada(Long id);
}