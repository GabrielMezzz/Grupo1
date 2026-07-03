package com.example.Grupo1.service;

import com.example.Grupo1.model.Entrada;
import java.util.List;
import java.util.Map;

public interface EntradaService {
    List<Entrada> listarEntradas();
    List<Entrada> listarEntradasPorDni(String dni);
    void guardarEntrada(Entrada entrada);
    void eliminarEntrada(Long id);
    Double calcularIngresos();
    double calcularVentasHoy();
    double calcularVentasSemana();
    long calcularEntradasHoy();
    long calcularEntradasSemana();
    double calcularIngresosMes();
    Map<String, Double> calcularVentasPorDia();
    Map<String, Long> calcularEntradasPorDia();
    Map<String, Double> calcularIngresosPorDiaMes();
}