package com.example.Grupo1.service.impl;

import com.example.Grupo1.model.Entrada;
import com.example.Grupo1.repository.EntradaRepository;
import com.example.Grupo1.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntradaServiceImpl implements EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Override
    public List<Entrada> listarEntradas() {
        return entradaRepository.findAll();
    }

    @Override
    public List<Entrada> listarEntradasPorDni(String dni) {
        return entradaRepository.findByDni(dni);
    }

    @Override
    public void guardarEntrada(Entrada entrada) {
        entradaRepository.save(entrada);
    }

    @Override
    public void eliminarEntrada(Long id) {
        entradaRepository.deleteById(id);
    }

    @Override
    public Double calcularIngresos() {
        return entradaRepository.findAll().stream()
                .mapToDouble(e -> e.getPrecio() != null ? e.getPrecio() : 0)
                .sum();
    }

    @Override
    public double calcularVentasHoy() {
        LocalDate hoy = LocalDate.now();
        return entradaRepository.findAll().stream()
                .filter(e -> e.getFechaCompra() != null && e.getFechaCompra().equals(hoy))
                .mapToDouble(e -> e.getPrecio() != null ? e.getPrecio() : 0)
                .sum();
    }

    @Override
    public double calcularVentasSemana() {
        LocalDate inicioSemana = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
        return entradaRepository.findAll().stream()
                .filter(e -> e.getFechaCompra() != null && !e.getFechaCompra().isBefore(inicioSemana))
                .mapToDouble(e -> e.getPrecio() != null ? e.getPrecio() : 0)
                .sum();
    }

    @Override
    public long calcularEntradasHoy() {
        LocalDate hoy = LocalDate.now();
        return entradaRepository.findAll().stream()
                .filter(e -> e.getFechaCompra() != null && e.getFechaCompra().equals(hoy))
                .count();
    }

    @Override
    public long calcularEntradasSemana() {
        LocalDate inicioSemana = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
        return entradaRepository.findAll().stream()
                .filter(e -> e.getFechaCompra() != null && !e.getFechaCompra().isBefore(inicioSemana))
                .count();
    }

    @Override
    public double calcularIngresosMes() {
        LocalDate hoy = LocalDate.now();
        return entradaRepository.findAll().stream()
                .filter(e -> e.getFechaCompra() != null
                        && e.getFechaCompra().getMonth() == hoy.getMonth()
                        && e.getFechaCompra().getYear() == hoy.getYear())
                .mapToDouble(e -> e.getPrecio() != null ? e.getPrecio() : 0)
                .sum();
    }

    @Override
    public Map<String, Double> calcularVentasPorDia() {
        LocalDate inicioSemana = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
        List<Entrada> entradas = entradaRepository.findAll();
        String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
        Map<String, Double> resultado = new LinkedHashMap<>();
        for (int i = 0; i < 7; i++) {
            LocalDate dia = inicioSemana.plusDays(i);
            double total = entradas.stream()
                    .filter(e -> e.getFechaCompra() != null && e.getFechaCompra().equals(dia))
                    .mapToDouble(e -> e.getPrecio() != null ? e.getPrecio() : 0)
                    .sum();
            resultado.put(dias[i], total);
        }
        return resultado;
    }

    @Override
    public Map<String, Long> calcularEntradasPorDia() {
        LocalDate inicioSemana = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
        List<Entrada> entradas = entradaRepository.findAll();
        String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
        Map<String, Long> resultado = new LinkedHashMap<>();
        for (int i = 0; i < 7; i++) {
            LocalDate dia = inicioSemana.plusDays(i);
            long cantidad = entradas.stream()
                    .filter(e -> e.getFechaCompra() != null && e.getFechaCompra().equals(dia))
                    .count();
            resultado.put(dias[i], cantidad);
        }
        return resultado;
    }

    @Override
    public Map<String, Double> calcularIngresosPorDiaMes() {
        LocalDate hoy = LocalDate.now();
        List<Entrada> entradas = entradaRepository.findAll();
        Map<String, Double> resultado = new LinkedHashMap<>();
        int diasEnMes = hoy.lengthOfMonth();
        for (int i = 1; i <= diasEnMes; i++) {
            LocalDate dia = LocalDate.of(hoy.getYear(), hoy.getMonth(), i);
            double total = entradas.stream()
                    .filter(e -> e.getFechaCompra() != null && e.getFechaCompra().equals(dia))
                    .mapToDouble(e -> e.getPrecio() != null ? e.getPrecio() : 0)
                    .sum();
            resultado.put(String.valueOf(i), total);
        }
        return resultado;
    }
}