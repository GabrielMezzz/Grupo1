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
        validarUnicidad(sede);
        sedeRepository.save(sede);
    }

    @Override
    public void eliminarSede(Long id) {
        sedeRepository.deleteById(id);
    }

    @Override
    public Sede obtenerPorId(Long id) {
        return sedeRepository.findById(id).orElseThrow();
    }

    private void validarUnicidad(Sede sede) {
        Sede sedeActual = null;
        if (sede.getId() != null) {
            sedeActual = sedeRepository.findById(sede.getId()).orElse(null);
        }

        if (sede.getNombreSede() != null) {
            boolean mismoNombre = sedeActual != null && sede.getNombreSede().equals(sedeActual.getNombreSede());
            if (!mismoNombre && sedeRepository.existsByNombreSede(sede.getNombreSede())) {
                throw new IllegalArgumentException("El nombre de la sede ya está registrado");
            }
        }

        if (sede.getDireccionSede() != null) {
            boolean mismaDireccion = sedeActual != null && sede.getDireccionSede().equals(sedeActual.getDireccionSede());
            if (!mismaDireccion && sedeRepository.existsByDireccionSede(sede.getDireccionSede())) {
                throw new IllegalArgumentException("La dirección ya está registrada");
            }
        }

        if (sede.getNombreArtista() != null) {
            boolean mismoArtista = sedeActual != null && sede.getNombreArtista().equals(sedeActual.getNombreArtista());
            if (!mismoArtista && sedeRepository.existsByNombreArtista(sede.getNombreArtista())) {
                throw new IllegalArgumentException("El nombre del artista ya está registrado");
            }
        }

        if (sede.getTelefono() != null) {
            boolean mismoTelefono = sedeActual != null && sede.getTelefono().equals(sedeActual.getTelefono());
            if (!mismoTelefono && sedeRepository.existsByTelefono(sede.getTelefono())) {
                throw new IllegalArgumentException("El teléfono ya está registrado");
            }
        }
    }
}