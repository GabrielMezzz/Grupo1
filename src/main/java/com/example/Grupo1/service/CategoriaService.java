package com.example.Grupo1.service;

import com.example.Grupo1.model.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listarCategorias();
    List<Categoria> listarCategoriasActivas();
    void guardarCategoria(Categoria categoria);
    Categoria eliminarCategoria(Long id);
    Categoria actualizarCategoria(Long id, Categoria categoria);
}
