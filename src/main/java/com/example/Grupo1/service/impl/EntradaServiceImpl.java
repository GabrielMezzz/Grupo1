package com.example.Grupo1.service.impl;

import com.example.Grupo1.model.Entrada;
import com.example.Grupo1.repository.EntradaRepository;
import com.example.Grupo1.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntradaServiceImpl implements EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Override
    public List<Entrada> listarEntradas() {
        return entradaRepository.findAll();
    }

    @Override
    public void guardarEntrada(Entrada entrada) {
        entradaRepository.save(entrada);
    }

    @Override
    public void eliminarEntrada(Long id) {
        entradaRepository.deleteById(id);
    }

    @Override
    public Double calcularIngresos() {
        return entradaRepository.findAll()
                .stream()
                .mapToDouble(e -> e.getPrecio() != null ? e.getPrecio() : 0)
                .sum();
    }
}