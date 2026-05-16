package com.example.Grupo1.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
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
class GestionEventosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @Test
    @DisplayName("RED: crear evento por JSON debe responder con el evento creado")
    void deberiaCrearEventoConJsonYResponderOk() throws Exception {
        String eventoJson = """
                {
                  "nombre": "Festival Primavera",
                  "categoria": "Conciertos",
                  "fecha": "2026-07-10",
                  "sede": "Arena Lima",
                  "precio": 120.50,
                  "capacidad": 5000,
                  "artista": "Banda Norte"
                }
                """;

        mockMvc.perform(post("/gestioneventos/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(eventoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Festival Primavera")); //F1
    }

    @Test
    @DisplayName("RED: listar eventos debe responder con JSON")
    void deberiaListarEventosEnJson() throws Exception {
        String eventoJson = """
                {
                  "nombre": "Festival Primavera",
                  "categoria": "Conciertos",
                  "fecha": "2026-07-10",
                  "sede": "Arena Lima",
                  "precio": 120.50,
                  "capacidad": 5000,
                  "artista": "Banda Norte"
                }
                """;

        mockMvc.perform(post("/gestioneventos/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(eventoJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/gestioneventos/listar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].nombre").value(hasItem("Festival Primavera"))); //F1
    }

    @Test
    @DisplayName("RED: eliminar evento debe responder con JSON")
    void deberiaEliminarEventoYResponderConJson() throws Exception {
        String eventoJson = """
                {
                  "nombre": "Temporal Evento",
                  "categoria": "Conciertos",
                  "fecha": "2026-07-10",
                  "sede": "Arena Lima",
                  "precio": 120.50,
                  "capacidad": 5000,
                  "artista": "Banda Norte"
                }
                """;

        var crearRespuesta = mockMvc.perform(post("/gestioneventos/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(eventoJson))
                .andExpect(status().isOk())
                .andReturn();

        JsonNode eventoCreado = objectMapper.readTree(crearRespuesta.getResponse().getContentAsString());
        long idCreado = eventoCreado.get("id").asLong();

        mockMvc.perform(delete("/gestioneventos/eliminar/{id}", idCreado)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idCreado))
                .andExpect(jsonPath("$.nombre").value("Temporal Evento")); //F1
    }

    @Test
    @DisplayName("RED: actualizar evento debe responder con JSON")
    void deberiaActualizarEventoYResponderConJson() throws Exception {
        String eventoJson = """
                {
                  "nombre": "Evento Base",
                  "categoria": "Conciertos",
                  "fecha": "2026-07-10",
                  "sede": "Arena Lima",
                  "precio": 120.50,
                  "capacidad": 5000,
                  "artista": "Banda Norte"
                }
                """;

        var crearRespuesta = mockMvc.perform(post("/gestioneventos/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(eventoJson))
                .andExpect(status().isOk())
                .andReturn();

        JsonNode eventoCreado = objectMapper.readTree(crearRespuesta.getResponse().getContentAsString());
        long idCreado = eventoCreado.get("id").asLong();

        String eventoActualizadoJson = """
                {
                  "nombre": "Evento Actualizado",
                  "categoria": "Conciertos",
                  "fecha": "2026-07-10",
                  "sede": "Arena Lima",
                  "precio": 200.00,
                  "capacidad": 7000,
                  "artista": "Banda Norte"
                }
                """;

        mockMvc.perform(put("/gestioneventos/actualizar/{id}", idCreado)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(eventoActualizadoJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idCreado))
                .andExpect(jsonPath("$.nombre").value("Evento Actualizado")); //F1
    }
}
