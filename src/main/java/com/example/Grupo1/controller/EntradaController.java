package com.example.Grupo1.controller;

import com.example.Grupo1.model.Entrada;
import com.example.Grupo1.model.Evento;
import com.example.Grupo1.model.Usuario;
import com.example.Grupo1.service.EntradaService;
import com.example.Grupo1.service.EventoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private EventoService eventoService;

    @GetMapping("/comprar/{eventoId}")
    public String comprar(@PathVariable Long eventoId, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        Evento evento = eventoService.buscarPorId(eventoId);
        Usuario u = (Usuario) session.getAttribute("usuarioObj");

        Entrada entrada = new Entrada();
        entrada.setNombre(u != null ? u.getNombre() : "Invitado");
        entrada.setDni(u != null ? u.getDni() : "-");
        entrada.setEvento(evento.getNombre());
        entrada.setPrecio(evento.getPrecio());
        entrada.setFechaCompra(LocalDate.now());
        entrada.setEstado("Vendida");

        entradaService.guardarEntrada(entrada);
        return "redirect:/eventos?compra=exitosa";
    }

    @GetMapping("/misEntradas")
    public String misEntradas(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }
        model.addAttribute("entradas", entradaService.listarEntradas());
        return "misentradas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        entradaService.eliminarEntrada(id);
        return "redirect:/entradas/misEntradas";
    }

    @GetMapping("/metricas")
    public String mostrarMetricas(Model model) {
        // 1. Jalamos la lista de entradas del service
        var listaEntradas = entradaService.listarEntradas();

        // 2. Calculamos los datos
        long totalVendidas = listaEntradas.size();
        double ingresosTotales = listaEntradas.stream()
                .mapToDouble(e -> e.getPrecio())
                .sum();

        // 3. ENVIAMOS LOS DATOS AL JSP (Fíjate que los nombres coincidan con tu JSP)
        model.addAttribute("totalEntradasVendidas", totalVendidas);
        model.addAttribute("totalIngresos", ingresosTotales);
        model.addAttribute("clientesActivos", 1); // Valor estático por ahora

        return "metricas";
    }
}