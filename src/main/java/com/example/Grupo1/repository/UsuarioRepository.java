package com.example.Grupo1.repository;

import com.example.Grupo1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);
    List<Usuario> findByEstado(String estado);
    boolean existsByDni(String dni);
    boolean existsByCorreo(String correo);
    boolean existsByTelefono(String telefono);

    @Modifying
    @Query("UPDATE Usuario u SET u.estado = 'Inactivo' WHERE u.id = :id")
    void banearUsuario(@Param("id") Long id); // ── NUEVO
}