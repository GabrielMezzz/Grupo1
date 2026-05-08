package com.example.Grupo1.service;

import com.example.Grupo1.model.Categoria;
import java.util.List;

public interface CategoriaService {

    // Métodos del servicio de categorías
    List<Categoria> listarCategorias();

    List<Categoria> listarCategoriasActivas();

    void guardarCategoria(Categoria categoria);

    void eliminarCategoria(Long id);
}