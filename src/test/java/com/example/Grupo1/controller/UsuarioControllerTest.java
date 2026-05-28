package com.example.Grupo1.controller;

import com.example.Grupo1.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    void guardarConDniInvalidoDebeQuedarseEnLaMismaVista() throws Exception {
        when(usuarioService.listarUsuarios()).thenReturn(Collections.emptyList());

        mockMvc.perform(post("/gestionusuarios/guardar")
                        .param("nombre", "Juan")
                        .param("apellido", "Perez")
                        .param("dni", "1234A678")
                        .param("correo", "juan@gmail.com")
                        .param("telefono", "987 654 321")
                        .param("rol", "Cliente")
                        .param("contrasena", "clave123")
                        .param("estado", "Activo"))
                .andExpect(status().isOk())
                .andExpect(view().name("GestionUsuarios/gestionusuarios"))
                .andExpect(model().attributeExists("usuarioEditar"))
                .andExpect(model().attributeExists("errorDni"))
                .andExpect(model().attribute("usuarioEditar", hasProperty("dni", is("1234A678"))));

        verify(usuarioService, never()).guardarUsuario(any());
    }

    @Test
    void actualizarConTelefonoInvalidoDebeQuedarseEnLaMismaVista() throws Exception {
        when(usuarioService.listarUsuarios()).thenReturn(Collections.emptyList());

        mockMvc.perform(post("/gestionusuarios/actualizar")
                        .param("id", "5")
                        .param("nombre", "Juan")
                        .param("apellido", "Perez")
                        .param("dni", "12345678")
                        .param("correo", "juan@gmail.com")
                        .param("telefono", "98765432")
                        .param("rol", "Cliente")
                        .param("contrasena", "clave123")
                        .param("estado", "Activo"))
                .andExpect(status().isOk())
                .andExpect(view().name("GestionUsuarios/gestionusuarios"))
                .andExpect(model().attributeExists("usuarioEditar"))
                .andExpect(model().attributeExists("errorTelefono"))
                .andExpect(model().attribute("usuarioEditar", hasProperty("id", is(5L))));

        verify(usuarioService, never()).guardarUsuario(any());
    }

    @Test
    void guardarConDniRepetidoDebeMostrarErrorEnElCampoDni() throws Exception {
        when(usuarioService.listarUsuarios()).thenReturn(Collections.emptyList());
        doThrow(new IllegalArgumentException("El DNI ya está registrado"))
                .when(usuarioService).guardarUsuario(any());

        mockMvc.perform(post("/gestionusuarios/guardar")
                        .param("nombre", "Juan")
                        .param("apellido", "Perez")
                        .param("dni", "12345678")
                        .param("correo", "juan@gmail.com")
                        .param("telefono", "987654321")
                        .param("rol", "Cliente")
                        .param("contrasena", "clave123")
                        .param("estado", "Activo"))
                .andExpect(status().isOk())
                .andExpect(view().name("GestionUsuarios/gestionusuarios"))
                .andExpect(model().attributeExists("errorDni"))
                .andExpect(model().attribute("errorDni", "El DNI ya está registrado"));
    }
}
