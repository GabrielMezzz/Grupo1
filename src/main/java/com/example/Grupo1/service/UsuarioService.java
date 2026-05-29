package com.example.Grupo1.service;

import com.example.Grupo1.model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listarUsuarios();
    List<Usuario> listarUsuariosActivos();
    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
    Usuario buscarPorId(Long id);
    void banearUsuario(Long id); // ── NUEVO
}