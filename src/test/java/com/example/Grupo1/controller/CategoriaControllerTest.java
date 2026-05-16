package com.example.Grupo1.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class GestionCategoriasControllerTest {

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

        mockMvc.perform(post("/gestioncategorias/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoriaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Tecnologia"));
    }

    @Test
    @DisplayName("RED: crear categoria debe devolver estado Activo")
    void deberiaForzarEstadoActivoAlCrearCategoriaAunqueElJsonTraigaInactivo() throws Exception {
        String categoriaJson = """
                {
                  "nombre": "Tecnologia",
                  "descripcion": "Prueba RED",
                  "estado": "Inactivo"
                }
                """;

        mockMvc.perform(post("/gestioncategorias/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoriaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado").value("Activo")); //F1
    }

    @Test
    @DisplayName("GREEN: listar categorias debe responder con JSON")
    void deberiaListarCategoriasEnJson() throws Exception {
        String categoriaJson = """
                {
                  "nombre": "Tecnologia",
                  "descripcion": "Prueba GREEN"
                }
                """;

        mockMvc.perform(post("/gestioncategorias/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoriaJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/gestioncategorias/listar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].nombre").value(hasItem("Tecnologia"))); //F1
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

        var crearRespuesta = mockMvc.perform(post("/gestioncategorias/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoriaJson))
                .andExpect(status().isOk())
                .andReturn();

        JsonNode categoriaCreada = objectMapper.readTree(crearRespuesta.getResponse().getContentAsString());
        long idCreado = categoriaCreada.get("id").asLong();

        mockMvc.perform(delete("/gestioncategorias/eliminar/{id}", idCreado)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idCreado))
                .andExpect(jsonPath("$.nombre").value("Temporal")); //F1
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

        var crearRespuesta = mockMvc.perform(post("/gestioncategorias/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoriaJson))
                .andExpect(status().isOk())
                .andReturn();

        JsonNode categoriaCreada = objectMapper.readTree(crearRespuesta.getResponse().getContentAsString());
        long idCreado = categoriaCreada.get("id").asLong();

        String categoriaActualizadaJson = """
                {
                  "nombre": "Base Actualizada",
                  "descripcion": "Prueba GREEN"
                }
                """;

        mockMvc.perform(put("/gestioncategorias/actualizar/{id}", idCreado)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoriaActualizadaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idCreado))
                .andExpect(jsonPath("$.nombre").value("Base Actualizada")); //F1
    }
}
