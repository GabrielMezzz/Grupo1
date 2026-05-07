package com.example.Grupo1;

import com.example.Grupo1.service.CategoriaService;
import com.example.Grupo1.service.EntradaService;
import com.example.Grupo1.service.EventoService;
import com.example.Grupo1.service.SedeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private SedeService sedeService;

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategoriasActivas());
        return "main";
    }

    @GetMapping("/gestion")
    public String gestion(Model model, HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }
        model.addAttribute("entradas", entradaService.listarEntradas());
        return "GestionEntradas/gestion";
    }

    @GetMapping("/metricas")
    public String metricas() {
        return "metricas";
    }

    @GetMapping("/eventos")
    public String eventos(Model model, @RequestParam(required = false) String compra) {
        model.addAttribute("eventos", eventoService.listarEventosActivos());
        model.addAttribute("categorias", categoriaService.listarCategoriasActivas());
        model.addAttribute("sedes", sedeService.listarSedesActivas());
        if ("exitosa".equals(compra)) {
            model.addAttribute("compraExitosa", true);
        }
        return "eventos";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }
        return "dashboard";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }
}