package com.example.Grupo1.service.impl;

import com.example.Grupo1.model.Categoria;
import com.example.Grupo1.repository.CategoriaRepository;
import com.example.Grupo1.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private static final String ESTADO_ACTIVO = "Activo"; //F3

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
        // if (categoria.getEstado() == null || categoria.getEstado().isBlank()) { //F1
        //     categoria.setEstado("Activo");
        // } //F1
        // categoriaRepository.save(categoria); //F2
        asegurarEstadoActivo(categoria); //F3
        categoriaRepository.save(categoria); //F3
    }

    private void asegurarEstadoActivo(Categoria categoria) { //F3
        categoria.setEstado(ESTADO_ACTIVO); //F3
    }

    @Override
    // public void eliminarCategoria(Long id) {
    //     categoriaRepository.deleteById(id);
    // } //F1
    public Categoria eliminarCategoria(Long id) { //F2
        // Categoria categoria = categoriaRepository.findById(id).orElse(null); //F2
        // if (categoria != null) { //F2
        //     categoriaRepository.deleteById(id); //F2
        // } //F2
        // return categoria; //F2
        Categoria categoria = buscarCategoria(id); //F3
        if (categoria != null) { //F3
            categoriaRepository.delete(categoria); //F3
        } //F3
        return categoria; //F3
    }

    @Override
    public Categoria actualizarCategoria(Long id, Categoria categoria) {
        // Categoria categoriaExistente = buscarCategoria(id); //F2
        // categoriaExistente.setNombre(categoria.getNombre()); //F2
        // categoriaExistente.setDescripcion(categoria.getDescripcion()); //F2
        // if (categoria.getEstado() != null) { //F2
        //     categoriaExistente.setEstado(categoria.getEstado()); //F2
        // } //F2
        // return categoriaRepository.save(categoriaExistente); //F2
        return actualizarCategoriaExistente(id, categoria); //F3
    }

    private Categoria buscarCategoria(Long id) { //F3
        return categoriaRepository.findById(id).orElse(null); //F3
    }

    private Categoria actualizarCategoriaExistente(Long id, Categoria categoria) { //F3
        Categoria categoriaExistente = buscarCategoria(id); //F3
        String estadoActual = categoriaExistente.getEstado(); //F3
        BeanUtils.copyProperties(categoria, categoriaExistente, "id"); //F3
        if (categoria.getEstado() == null) { //F3
            categoriaExistente.setEstado(estadoActual); //F3
        } //F3
        return categoriaRepository.save(categoriaExistente); //F3
    }
}
