package com.example.Grupo1.controller;

import com.example.Grupo1.model.Usuario;
import com.example.Grupo1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/gestionusuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model, HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "GestionUsuarios/gestionusuarios";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("usuarioEditar") Usuario usuario, Model model) {
        if (usuarioService.existePorDni(usuario.getDni())) {
            return volverConError(model, usuario, "errorDni", "El DNI ya está registrado");
        }
        if (usuarioService.existePorCorreo(usuario.getCorreo().trim().toLowerCase())) {
            return volverConError(model, usuario, "errorCorreo", "El correo ya está registrado");
        }
        if (usuarioService.existePorTelefono(usuario.getTelefono().trim())) {
            return volverConError(model, usuario, "errorTelefono", "El teléfono ya está registrado");
        }
        usuario.setCorreo(usuario.getCorreo().trim().toLowerCase());
        usuario.setTelefono(usuario.getTelefono().trim());
        usuarioService.guardarUsuario(usuario);
        return "redirect:/gestionusuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/gestionusuarios";
    }

    @GetMapping("/banear/{id}")
    public String banear(@PathVariable Long id) {
        usuarioService.banearUsuario(id);
        return "redirect:/gestionusuarios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model, HttpSession session) {
        String rol = (String) session.getAttribute("rol");
        if (rol == null || !rol.equals("Administrador")) {
            return "redirect:/login";
        }
        model.addAttribute("usuarioEditar", usuarioService.buscarPorId(id));
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "GestionUsuarios/gestionusuarios";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("usuarioEditar") Usuario usuario, Model model) {
        Usuario usuarioActual = usuarioService.buscarPorId(usuario.getId());

        boolean mismoCorreo = usuarioActual.getCorreo().equals(usuario.getCorreo().trim().toLowerCase());
        boolean mismoDni = usuarioActual.getDni().equals(usuario.getDni());
        boolean mismoTelefono = usuarioActual.getTelefono().equals(usuario.getTelefono().trim());

        if (!mismoDni && usuarioService.existePorDni(usuario.getDni())) {
            return volverConError(model, usuario, "errorDni", "El DNI ya está registrado");
        }
        if (!mismoCorreo && usuarioService.existePorCorreo(usuario.getCorreo().trim().toLowerCase())) {
            return volverConError(model, usuario, "errorCorreo", "El correo ya está registrado");
        }
        if (!mismoTelefono && usuarioService.existePorTelefono(usuario.getTelefono().trim())) {
            return volverConError(model, usuario, "errorTelefono", "El teléfono ya está registrado");
        }

        usuario.setCorreo(usuario.getCorreo().trim().toLowerCase());
        usuario.setTelefono(usuario.getTelefono().trim());
        usuarioService.actualizarUsuario(usuario);
        return "redirect:/gestionusuarios";
    }

    private String volverConError(Model model, Usuario usuario, String atributoError, String mensaje) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("usuarioEditar", usuario);
        model.addAttribute(atributoError, mensaje);
        return "GestionUsuarios/gestionusuarios";
    }
}