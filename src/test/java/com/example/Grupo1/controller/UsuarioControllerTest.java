package com.example.Grupo1.controller;

import com.example.Grupo1.model.Usuario;
import com.example.Grupo1.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

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
    void guardarDebeMostrarErrorDniSiYaExiste() throws Exception {
        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setDni("12345678");

        when(usuarioService.listarUsuarios()).thenReturn(Collections.emptyList());
        when(usuarioService.buscarPorDni("12345678")).thenReturn(usuarioExistente);
        when(usuarioService.buscarPorCorreo("juan@gmail.com")).thenReturn(null);
        when(usuarioService.buscarPorTelefono("987654321")).thenReturn(null);

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
                .andExpect(model().attributeExists("usuarioEditar"))
                .andExpect(model().attribute("errorDni", "El DNI ya está registrado"));

        verify(usuarioService, never()).guardarUsuario(org.mockito.ArgumentMatchers.any(Usuario.class));
    }

    @Test
    void actualizarDebeMostrarErrorCorreoSiYaExiste() throws Exception {
        Usuario existenteDni = new Usuario();
        existenteDni.setDni("12345678");

        Usuario existenteCorreo = new Usuario();
        existenteCorreo.setCorreo("juan@gmail.com");

        when(usuarioService.listarUsuarios()).thenReturn(Collections.emptyList());
        when(usuarioService.buscarPorDni("12345678")).thenReturn(null);
        when(usuarioService.buscarPorCorreo("juan@gmail.com")).thenReturn(existenteCorreo);
        when(usuarioService.buscarPorTelefono("987654321")).thenReturn(null);

        mockMvc.perform(post("/gestionusuarios/actualizar")
                        .param("id", "5")
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
                .andExpect(model().attributeExists("usuarioEditar"))
                .andExpect(model().attribute("errorCorreo", "El correo ya está registrado"));

        verify(usuarioService, never()).guardarUsuario(org.mockito.ArgumentMatchers.any(Usuario.class));
    }
}
