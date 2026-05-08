package com.example.Grupo1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "entradas")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;
    private String nombre;
    private String evento;
    private Double precio;
    private LocalDate fechaCompra;
    private String estado;

    // Datos de la entrada comprada
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEvento() { return evento; }
    public void setEvento(String evento) { this.evento = evento; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public LocalDate getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDate fechaCompra) { this.fechaCompra = fechaCompra; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}