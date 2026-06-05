package com.example.Grupo1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreArtistico;
    private String genero;
    private String nacionalidad;
    private String correo;
    private String telefono;
    private String estado;

    private String nombreSede;
    private String direccionSede;
    private String ciudadSede;
    private Integer capacidadSede;
    private String fechaEvento;
    private String horaEvento;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreArtistico() { return nombreArtistico; }
    public void setNombreArtistico(String nombreArtistico) { this.nombreArtistico = nombreArtistico; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getNombreSede() { return nombreSede; }
    public void setNombreSede(String nombreSede) { this.nombreSede = nombreSede; }

    public String getDireccionSede() { return direccionSede; }
    public void setDireccionSede(String direccionSede) { this.direccionSede = direccionSede; }

    public String getCiudadSede() { return ciudadSede; }
    public void setCiudadSede(String ciudadSede) { this.ciudadSede = ciudadSede; }

    public Integer getCapacidadSede() { return capacidadSede; }
    public void setCapacidadSede(Integer capacidadSede) { this.capacidadSede = capacidadSede; }

    public String getFechaEvento() { return fechaEvento; }
    public void setFechaEvento(String fechaEvento) { this.fechaEvento = fechaEvento; }

    public String getHoraEvento() { return horaEvento; }

    public void setHoraEvento(String horaEvento) { this.horaEvento = horaEvento; }
}