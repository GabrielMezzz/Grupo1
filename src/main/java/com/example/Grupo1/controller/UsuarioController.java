package com.example.Grupo1.controller;

import com.example.Grupo1.model.Usuario;
import com.example.Grupo1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
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
    public String guardar(@Valid @ModelAttribute("usuarioEditar") Usuario usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            cargarFormularioConErrores(usuario, bindingResult, model);
            return "GestionUsuarios/gestionusuarios";
        }

        try {
            usuarioService.guardarUsuario(usuario);
        } catch (IllegalArgumentException ex) {
            cargarFormularioConErrorServicio(usuario, ex.getMessage(), model);
            return "GestionUsuarios/gestionusuarios";
        }

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
    public String actualizar(@Valid @ModelAttribute("usuarioEditar") Usuario usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            cargarFormularioConErrores(usuario, bindingResult, model);
            return "GestionUsuarios/gestionusuarios";
        }

        try {
            usuarioService.guardarUsuario(usuario);
        } catch (IllegalArgumentException ex) {
            cargarFormularioConErrorServicio(usuario, ex.getMessage(), model);
            return "GestionUsuarios/gestionusuarios";
        }

        return "redirect:/gestionusuarios";
    }

    // Vuelve a cargar la tabla y los mensajes para quedarse en la misma vista
    private void cargarFormularioConErrores(Usuario usuario, BindingResult bindingResult, Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("usuarioEditar", usuario);

        if (bindingResult.hasFieldErrors("nombre")) {
            model.addAttribute("errorNombre", bindingResult.getFieldError("nombre").getDefaultMessage());
        }
        if (bindingResult.hasFieldErrors("apellido")) {
            model.addAttribute("errorApellido", bindingResult.getFieldError("apellido").getDefaultMessage());
        }
        if (bindingResult.hasFieldErrors("dni")) {
            model.addAttribute("errorDni", bindingResult.getFieldError("dni").getDefaultMessage());
        }
        if (bindingResult.hasFieldErrors("correo")) {
            model.addAttribute("errorCorreo", bindingResult.getFieldError("correo").getDefaultMessage());
        }
        if (bindingResult.hasFieldErrors("telefono")) {
            model.addAttribute("errorTelefono", bindingResult.getFieldError("telefono").getDefaultMessage());
        }
        if (bindingResult.hasFieldErrors("contrasena")) {
            model.addAttribute("errorContrasena", bindingResult.getFieldError("contrasena").getDefaultMessage());
        }
    }

    // Muestra mensajes simples cuando el service detecta un dato duplicado
    private void cargarFormularioConErrorServicio(Usuario usuario, String mensaje, Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("usuarioEditar", usuario);

        if (mensaje.contains("DNI")) {
            model.addAttribute("errorDni", mensaje);
        } else if (mensaje.contains("correo")) {
            model.addAttribute("errorCorreo", mensaje);
        } else if (mensaje.contains("telefono")) {
            model.addAttribute("errorTelefono", mensaje);
        } else {
            model.addAttribute("mensajeError", mensaje);
        }
    }
}
