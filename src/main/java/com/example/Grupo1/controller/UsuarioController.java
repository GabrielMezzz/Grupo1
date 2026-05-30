package com.example.Grupo1.controller;

import com.example.Grupo1.model.Usuario;
import com.example.Grupo1.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        String correoLimpio = usuario.getCorreo();
        if (correoLimpio != null) {
            correoLimpio = correoLimpio.trim().toLowerCase();
        }

        String telefonoLimpio = usuario.getTelefono();
        if (telefonoLimpio != null) {
            while (telefonoLimpio.contains(" ")) {
                telefonoLimpio = telefonoLimpio.replace(" ", "");
            }
        }

        Usuario usuarioDni = usuarioService.buscarPorDni(usuario.getDni());
        if (usuarioDni != null) {
            return volverConError(model, usuario, "errorDni", "El DNI ya está registrado");
        }

        Usuario usuarioCorreo = usuarioService.buscarPorCorreo(correoLimpio);
        if (usuarioCorreo != null) {
            return volverConError(model, usuario, "errorCorreo", "El correo ya está registrado");
        }

        Usuario usuarioTelefono = usuarioService.buscarPorTelefono(telefonoLimpio);
        if (usuarioTelefono != null) {
            return volverConError(model, usuario, "errorTelefono", "El teléfono ya está registrado");
        }

        if (correoLimpio != null) {
            usuario.setCorreo(correoLimpio);
        }
        if (telefonoLimpio != null) {
            usuario.setTelefono(telefonoLimpio);
        }

        usuarioService.guardarUsuario(usuario);
        return "redirect:/gestionusuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
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
        String correoLimpio = usuario.getCorreo();
        if (correoLimpio != null) {
            correoLimpio = correoLimpio.trim().toLowerCase();
        }

        String telefonoLimpio = usuario.getTelefono();
        if (telefonoLimpio != null) {
            while (telefonoLimpio.contains(" ")) {
                telefonoLimpio = telefonoLimpio.replace(" ", "");
            }
        }

        Usuario usuarioDni = usuarioService.buscarPorDni(usuario.getDni());
        if (usuarioDni != null && usuarioDni.getId() != null && !usuarioDni.getId().equals(usuario.getId())) {
            return volverConError(model, usuario, "errorDni", "El DNI ya está registrado");
        }

        Usuario usuarioCorreo = usuarioService.buscarPorCorreo(correoLimpio);
        if (usuarioCorreo != null && usuarioCorreo.getId() != null && !usuarioCorreo.getId().equals(usuario.getId())) {
            return volverConError(model, usuario, "errorCorreo", "El correo ya está registrado");
        }

        Usuario usuarioTelefono = usuarioService.buscarPorTelefono(telefonoLimpio);
        if (usuarioTelefono != null && usuarioTelefono.getId() != null && !usuarioTelefono.getId().equals(usuario.getId())) {
            return volverConError(model, usuario, "errorTelefono", "El teléfono ya está registrado");
        }

        if (correoLimpio != null) {
            usuario.setCorreo(correoLimpio);
        }
        if (telefonoLimpio != null) {
            usuario.setTelefono(telefonoLimpio);
        }

        usuarioService.guardarUsuario(usuario);
        return "redirect:/gestionusuarios";
    }

    // Vuelve a cargar la tabla y el formulario si aparece un duplicado
    private String volverConError(Model model, Usuario usuario, String atributoError, String mensaje) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("usuarioEditar", usuario);
        model.addAttribute(atributoError, mensaje);
        return "GestionUsuarios/gestionusuarios";
    }
}
