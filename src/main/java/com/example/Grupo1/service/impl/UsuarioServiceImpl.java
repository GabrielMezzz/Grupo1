package com.example.Grupo1.service.impl;

import com.example.Grupo1.model.Usuario;
import com.example.Grupo1.repository.UsuarioRepository;
import com.example.Grupo1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuario.setNombre(usuario.getNombre());
        usuario.setApellido(usuario.getApellido());
        usuario.setCorreo(usuario.getCorreo());
        usuario.setTelefono(usuario.getTelefono());
        usuario.setContrasena(usuario.getContrasena());
        validarUnicidad(usuario);
        usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void banearUsuario(Long id) {
        usuarioRepository.banearUsuario(id); // ── usa query directa, sin cargar el objeto
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> listarUsuariosActivos() {
        return usuarioRepository.findByEstado("Activo");
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    private void validarUnicidad(Usuario usuario) {
        Usuario usuarioActual = null;
        if (usuario.getId() != null) {
            usuarioActual = usuarioRepository.findById(usuario.getId()).orElse(null);
        }

        if (usuario.getDni() != null) {
            boolean mismoDni = usuarioActual != null && usuario.getDni().equals(usuarioActual.getDni());
            if (!mismoDni && usuarioRepository.existsByDni(usuario.getDni())) {
                throw new IllegalArgumentException("El DNI ya está registrado");
            }
        }

        if (usuario.getCorreo() != null) {
            boolean mismoCorreo = usuarioActual != null && usuario.getCorreo().equals(usuarioActual.getCorreo());
            if (!mismoCorreo && usuarioRepository.existsByCorreo(usuario.getCorreo())) {
                throw new IllegalArgumentException("El correo ya está registrado");
            }
        }

        if (usuario.getTelefono() != null) {
            boolean mismoTelefono = usuarioActual != null && usuario.getTelefono().equals(usuarioActual.getTelefono());
            if (!mismoTelefono && usuarioRepository.existsByTelefono(usuario.getTelefono())) {
                throw new IllegalArgumentException("El telefono ya está registrado");
            }
        }
    }
}