package com.example.Grupo1.controller;

import com.example.Grupo1.model.Entrada;
import com.example.Grupo1.model.Evento;
import com.example.Grupo1.model.Usuario;
import com.example.Grupo1.service.EntradaService;
import com.example.Grupo1.service.EventoService;
import com.example.Grupo1.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private UsuarioService usuarioService;

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
        if (evento.getCapacidad() < cantidad) {
            return "redirect:/eventos?error=capacidad";
        }
        for (int i = 0; i < cantidad; i++) {
            Entrada entrada = new Entrada();
            entrada.setNombre(u.getNombre());
            entrada.setDni(u.getDni());
            entrada.setEvento(evento.getNombre());
            entrada.setPrecio(evento.getPrecio());
            entrada.setFechaCompra(LocalDate.now());
            entrada.setEstado("Vendida");
            entradaService.guardarEntrada(entrada);
        }
        evento.setCapacidad(evento.getCapacidad() - cantidad);
        eventoService.guardarEvento(evento);
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
        Map<String, Map<String, Object>> agrupadas = new LinkedHashMap<>();
        for (Entrada e : entradas) {
            String key = e.getEvento();
            if (!agrupadas.containsKey(key)) {
                Evento evento = eventoService.buscarPorNombre(e.getEvento());
                Map<String, Object> datos = new LinkedHashMap<>();
                datos.put("evento", e.getEvento());
                datos.put("fechaCompra", e.getFechaCompra());
                datos.put("precio", e.getPrecio());
                datos.put("cantidad", 1);
                datos.put("total", e.getPrecio());
                datos.put("fecha", evento != null ? evento.getFecha() : "-");
                datos.put("hora", evento != null ? evento.getHora() : "-");
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
        return "redirect:/entradas/EntradasCompradas";
    }

    @GetMapping("/metricas")
    public String metricas(Model model, HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }

        long clientes = usuarioService.listarUsuarios().stream()
                .filter(u -> u.getRol() != null && u.getRol().equals("Cliente"))
                .count();

        model.addAttribute("clientesActivos", clientes);
        model.addAttribute("totalEntradasVendidas", entradaService.listarEntradas().size());
        model.addAttribute("totalEventos", eventoService.listarEventosActivos().size());
        model.addAttribute("totalIngresos", entradaService.calcularIngresos());
        model.addAttribute("ventasHoy", entradaService.calcularVentasHoy());
        model.addAttribute("ventasSemana", entradaService.calcularVentasSemana());
        model.addAttribute("entradasHoy", entradaService.calcularEntradasHoy());
        model.addAttribute("entradasSemana", entradaService.calcularEntradasSemana());
        model.addAttribute("ingresosMes", entradaService.calcularIngresosMes());
        model.addAttribute("ventasPorDia", entradaService.calcularVentasPorDia());
        model.addAttribute("entradasPorDia", entradaService.calcularEntradasPorDia());
        model.addAttribute("ingresosPorDiaMes", entradaService.calcularIngresosPorDiaMes());

        return "metricas";
    }
}