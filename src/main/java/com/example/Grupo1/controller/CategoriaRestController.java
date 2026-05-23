package com.example.Grupo1.controller;

import com.example.Grupo1.model.Categoria;
import com.example.Grupo1.service.CategoriaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gestioncategorias")
public class CategoriaRestController {

    private final CategoriaService categoriaService; //F3

    public CategoriaRestController(CategoriaService categoriaService) { //F3
        this.categoriaService = categoriaService; //F3
    }

    @PostMapping(value = "/guardar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Categoria guardar(@RequestBody Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return categoria;
    }

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Categoria> listar() {
        // return categoriaService.listarCategorias(); //F2
        return obtenerCategorias(); //F3
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Categoria eliminar(@PathVariable Long id) {
        // return null; //F1
        return categoriaService.eliminarCategoria(id); //F2
    }

    @PutMapping(value = "/actualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Categoria actualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        // return null; //F1
        return categoriaService.actualizarCategoria(id, categoria); //F2
    }

    private List<Categoria> obtenerCategorias() { //F3
        return categoriaService.listarCategorias(); //F3
    }
}
