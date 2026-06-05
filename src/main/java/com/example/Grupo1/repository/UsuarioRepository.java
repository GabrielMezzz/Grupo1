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
    Optional<Usuario> findByDni(String dni);
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByTelefono(String telefono);
    boolean existsByDni(String dni);
    boolean existsByCorreo(String correo);
    boolean existsByTelefono(String telefono);

    @Modifying
    @Query("UPDATE Usuario u SET u.estado = 'Inactivo' WHERE u.id = :id")
    void banearUsuario(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Usuario u SET u.nombre = :nombre, u.apellido = :apellido, u.dni = :dni, u.correo = :correo, u.telefono = :telefono, u.rol = :rol, u.estado = :estado WHERE u.id = :id")
    void actualizarUsuario(@Param("id") Long id, @Param("nombre") String nombre,
                           @Param("apellido") String apellido, @Param("dni") String dni,
                           @Param("correo") String correo, @Param("telefono") String telefono,
                           @Param("rol") String rol, @Param("estado") String estado);
}