package com.example.Grupo1.controller;

import com.example.Grupo1.model.Entrada;
import com.example.Grupo1.model.Evento;
import com.example.Grupo1.model.Usuario;
import com.example.Grupo1.service.EntradaService;
import java.util.Map;
import java.util.LinkedHashMap;
import com.example.Grupo1.service.EventoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private EventoService eventoService;

    @GetMapping("/comprar/{eventoId}")
    public String comprar(@PathVariable Long eventoId,
                          @RequestParam(defaultValue = "1") int cantidad,
                          HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        Evento evento = eventoService.buscarPorId(eventoId);
        Usuario u = (Usuario) session.getAttribute("usuarioObj");

        for (int i = 0; i < cantidad; i++) {
            Entrada entrada = new Entrada();
            entrada.setNombre(u != null ? u.getNombre() : "Invitado");
            entrada.setDni(u != null ? u.getDni() : "-");
            entrada.setEvento(evento.getNombre());
            entrada.setPrecio(evento.getPrecio());
            entrada.setFechaCompra(LocalDate.now());
            entrada.setEstado("Vendida");
            entradaService.guardarEntrada(entrada);
        }

        return "redirect:/eventos?compra=exitosa";
    }

    @GetMapping("/EntradasCompradas")
    public String misEntradas(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }
        Usuario u = (Usuario) session.getAttribute("usuarioObj");
        if (u == null) {
            return "redirect:/login";
        }

        List<Entrada> entradas = entradaService.listarEntradasPorDni(u.getDni());

        // Agrupar por evento
        Map<String, Map<String, Object>> agrupadas = new LinkedHashMap<>();
        for (Entrada e : entradas) {
            String key = e.getEvento();
            if (!agrupadas.containsKey(key)) {
                Map<String, Object> datos = new LinkedHashMap<>();
                datos.put("evento", e.getEvento());
                datos.put("fechaCompra", e.getFechaCompra());
                datos.put("precio", e.getPrecio());
                datos.put("cantidad", 1);
                datos.put("total", e.getPrecio());
                agrupadas.put(key, datos);
            } else {
                Map<String, Object> datos = agrupadas.get(key);
                int cantidad = (int) datos.get("cantidad") + 1;
                double total = (double) datos.get("total") + e.getPrecio();
                datos.put("cantidad", cantidad);
                datos.put("total", total);
            }
        }

        model.addAttribute("agrupadas", agrupadas.values());
        model.addAttribute("usuario", u);
        return "EntradaUsuario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        entradaService.eliminarEntrada(id);
        return "EntradaUsuario";
    }

    @GetMapping("/metricas")
    public String mostrarMetricas(Model model) {
        var listaEntradas = entradaService.listarEntradas();
        long totalVendidas = listaEntradas.size();
        double ingresosTotales = listaEntradas.stream()
                .mapToDouble(e -> e.getPrecio()).sum();
        model.addAttribute("totalEntradasVendidas", totalVendidas);
        model.addAttribute("totalIngresos", ingresosTotales);
        model.addAttribute("clientesActivos", 1);
        return "metricas";
    }
}