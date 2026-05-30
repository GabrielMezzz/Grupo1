package com.example.Grupo1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]+$", message = "El nombre solo puede tener letras")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]+$", message = "El apellido solo puede tener letras")
    private String apellido;

    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 numeros")
    @Pattern(regexp = "^[0-9]+$", message = "El DNI solo puede tener numeros")
    @Column(unique = true)
    private String dni;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es valido")
    @Column(unique = true)
    private String correo;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(min = 9, max = 9, message = "El telefono debe tener 9 numeros")
    @Pattern(regexp = "^[0-9]+$", message = "El telefono solo puede tener numeros")
    @Column(unique = true)
    private String telefono;

    private String rol;

    @NotBlank(message = "La contrasena es obligatoria")
    @Size(min = 8, message = "La contrasena debe tener al menos 8 caracteres")
    private String contrasena;

    private String estado;

    // Getters y setters simples
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = capitalizarPalabras(nombre); }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = capitalizarPalabras(apellido); }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) {
        this.correo = correo == null ? null : correo.trim().toLowerCase();
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) {
        this.telefono = telefono == null ? null : telefono.replace(" ", "");
    }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena == null ? null : contrasena.trim();
    }

    public String getTelefonoFormateado() {
        if (telefono == null || telefono.length() != 9) {
            return telefono;
        }
        return telefono.substring(0, 3) + " " + telefono.substring(3, 6) + " " + telefono.substring(6, 9);
    }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    private String capitalizarPalabras(String texto) {
        if (texto == null) {
            return null;
        }

        texto = texto.trim().toLowerCase();
        if (texto.isEmpty()) {
            return texto;
        }

        String[] palabras = texto.split(" ");
        String resultado = "";

        for (String palabra : palabras) {
            if (palabra.isEmpty()) {
                continue;
            }

            if (!resultado.isEmpty()) {
                resultado += " ";
            }

            resultado += palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
        }


        return resultado;
    }
}
