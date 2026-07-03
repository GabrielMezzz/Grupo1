package com.example.Grupo1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sedes")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreSede;
    private String direccionSede;
    private String ciudadSede;
    private Integer capacidadSede;
    private String nombreArtista;
    private String genero;
    private String correo;
    private String telefono;
    private String estado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreSede() { return nombreSede; }
    public void setNombreSede(String nombreSede) { this.nombreSede = nombreSede; }

    public String getDireccionSede() { return direccionSede; }
    public void setDireccionSede(String direccionSede) { this.direccionSede = direccionSede; }

    public String getCiudadSede() { return ciudadSede; }
    public void setCiudadSede(String ciudadSede) { this.ciudadSede = ciudadSede; }

    public Integer getCapacidadSede() { return capacidadSede; }
    public void setCapacidadSede(Integer capacidadSede) { this.capacidadSede = capacidadSede; }

    public String getNombreArtista() { return nombreArtista; }
    public void setNombreArtista(String nombreArtista) { this.nombreArtista = nombreArtista; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}