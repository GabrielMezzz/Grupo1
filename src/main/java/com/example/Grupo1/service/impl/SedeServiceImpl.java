package com.example.Grupo1.service.impl;

import com.example.Grupo1.model.Sede;
import com.example.Grupo1.repository.SedeRepository;
import com.example.Grupo1.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SedeServiceImpl implements SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public List<Sede> listarSedes() {
        return sedeRepository.findAll();
    }

    @Override
    public List<Sede> listarSedesActivas() {
        return sedeRepository.findByEstado("Activo");
    }

    @Override
    public void guardarSede(Sede sede) {
        sedeRepository.save(sede);
    }

    @Override
    public void eliminarSede(Long id) {
        sedeRepository.deleteById(id);
    }
}