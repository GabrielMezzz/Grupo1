package com.example.Grupo1.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasItem;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.DirtiesContext;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @Test
    @DisplayName("GREEN: crear categoria por JSON debe responder con la categoria creada")
    void deberiaCrearCategoriaConJsonYResponderOk() throws Exception {

        String categoriaJson = """
                {
                  "nombre": "Tecnologia",
                  "descripcion": "Prueba GREEN"
                }
                """;

        mockMvc.perform(
                        post("/gestioncategorias/guardar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(categoriaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Tecnologia"));
    }

    @Test
    @DisplayName("RED: crear categoria debe devolver estado Activo")
    void deberiaForzarEstadoActivoAlCrearCategoria() throws Exception {

        String categoriaJson = """
                {
                  "nombre": "Tecnologia",
                  "descripcion": "Prueba RED",
                  "estado": "Inactivo"
                }
                """;

        mockMvc.perform(
                        post("/gestioncategorias/guardar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(categoriaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado").value("Activo"));
    }

    @Test
    @DisplayName("RED: listar categorias debe responder con JSON")
    void deberiaListarCategoriasEnJson() throws Exception {

        String categoriaJson = """
                {
                  "nombre": "ConciertoROCK",
                  "descripcion": "Prueba GREEN"
                }
                """;

        mockMvc.perform(
                        post("/gestioncategorias/guardar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(categoriaJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/gestioncategorias/listar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].nombre").value(hasItem("ConciertoROCK")));
    }

    @Test
    @DisplayName("RED: eliminar categoria debe responder con JSON")
    void deberiaEliminarCategoriaYResponderConJson() throws Exception {

        String categoriaJson = """
                {
                  "nombre": "Temporal",
                  "descripcion": "Prueba RED"
                }
                """;

        var crearRespuesta = mockMvc.perform(
                        post("/gestioncategorias/guardar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(categoriaJson))
                .andExpect(status().isOk())
                .andReturn();

        JsonNode categoriaCreada = objectMapper.readTree(
                crearRespuesta.getResponse().getContentAsString());
        long idCreado = categoriaCreada.get("id").asLong();

        mockMvc.perform(
                        delete("/gestioncategorias/eliminar/{id}", idCreado)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idCreado))
                .andExpect(jsonPath("$.nombre").value("Temporal"));
    }

    @Test
    @DisplayName("GREEN: actualizar categoria debe responder con JSON")
    void deberiaActualizarCategoriaYResponderConJson() throws Exception {

        String categoriaJson = """
                {
                  "nombre": "Base",
                  "descripcion": "Prueba RED"
                }
                """;

        var crearRespuesta = mockMvc.perform(
                        post("/gestioncategorias/guardar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(categoriaJson))
                .andExpect(status().isOk())
                .andReturn();

        JsonNode categoriaCreada = objectMapper.readTree(
                crearRespuesta.getResponse().getContentAsString());
        long idCreado = categoriaCreada.get("id").asLong();

        String categoriaActualizadaJson = """
                {
                  "nombre": "Base Actualizada",
                  "descripcion": "Prueba GREEN"
                }
                """;

        mockMvc.perform(
                        put("/gestioncategorias/actualizar/{id}", idCreado)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(categoriaActualizadaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idCreado))
                .andExpect(jsonPath("$.nombre").value("Base Actualizada"));
    }
}