package com.example.Grupo1.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioTest {

    @Test
    void nombreDebeGuardarseTalComoSeRecibe() {
        Usuario usuario = new Usuario();

        usuario.setNombre("oLiVeR");

        assertEquals("oLiVeR", usuario.getNombre());
    }

    @Test
    void apellidoDebeGuardarseTalComoSeRecibe() {
        Usuario usuario = new Usuario();

        usuario.setApellido("via y rada");

        assertEquals("via y rada", usuario.getApellido());
    }

    @Test
    void correoDebeGuardarseTalComoSeRecibe() {
        Usuario usuario = new Usuario();

        usuario.setCorreo("  Usuario@Gmail.com ");

        assertEquals("  Usuario@Gmail.com ", usuario.getCorreo());
    }

    @Test
    void telefonoDebeGuardarseTalComoSeRecibeYElFormatoDebeSerVisual() {
        Usuario usuario = new Usuario();

        usuario.setTelefono("987654321");

        assertEquals("987654321", usuario.getTelefono());
        assertEquals("987 654 321", usuario.getTelefonoFormateado());
    }

    @Test
    void contrasenaDebeGuardarseTalComoSeRecibe() {
        Usuario usuario = new Usuario();

        usuario.setContrasena("  clave123  ");

        assertEquals("  clave123  ", usuario.getContrasena());
    }
}
