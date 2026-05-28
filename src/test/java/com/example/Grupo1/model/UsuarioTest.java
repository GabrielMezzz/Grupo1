package com.example.Grupo1.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioTest {

    @Test
    void nombreDebeCapitalizarLaPrimeraLetraYDejarElRestoMinuscula() {
        Usuario usuario = new Usuario();

        usuario.setNombre("oLiVeR");

        assertEquals("Oliver", usuario.getNombre());
    }

    @Test
    void apellidoDebeCapitalizarCadaPalabra() {
        Usuario usuario = new Usuario();

        usuario.setApellido("via y rada");

        assertEquals("Via Y Rada", usuario.getApellido());
    }

    @Test
    void telefonoDebeGuardarDigitosYMostrarElFormatoConEspacios() {
        Usuario usuario = new Usuario();

        usuario.setTelefono("987 654 321");

        assertEquals("987654321", usuario.getTelefono());
        assertEquals("987 654 321", usuario.getTelefonoFormateado());
    }

    @Test
    void contrasenaDebeQuitarEspaciosDelInicioYDelFinal() {
        Usuario usuario = new Usuario();

        usuario.setContrasena("  clave123  ");

        assertEquals("clave123", usuario.getContrasena());
    }

    @Test
    void correoDebeQuitarEspaciosYPasarAMinusculas() {
        Usuario usuario = new Usuario();

        usuario.setCorreo("  Usuario@Gmail.com ");

        assertEquals("usuario@gmail.com", usuario.getCorreo());
    }
}
