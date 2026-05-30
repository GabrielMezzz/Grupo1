package com.example.Grupo1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(unique = true)
    private String dni;

    @Column(unique = true)
    private String correo;

    @Column(unique = true)
    private String telefono;

    private String rol;

    private String contrasena;

    private String estado;

    // Getters y setters simples
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // Devuelve el telefono con formato visual: 987 654 321
    public String getTelefonoFormateado() {
        if (telefono == null || telefono.length() != 9) {
            return telefono;
        }

        return telefono.substring(0, 3) + " " + telefono.substring(3, 6) + " " + telefono.substring(6, 9);
    }
}
