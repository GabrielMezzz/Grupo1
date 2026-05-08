package com.example.Grupo1.repository;

import com.example.Grupo1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Búsqueda para inicio de sesión
    Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);

    // Consulta usuarios por estado
    List<Usuario> findByEstado(String estado);
}