package com.example.Grupo1.service.impl;

import com.example.Grupo1.model.Categoria;
import com.example.Grupo1.repository.CategoriaRepository;
import com.example.Grupo1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public List<Categoria> listarCategoriasActivas() {
        return categoriaRepository.findByEstado("Activo");
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow();
    }
}