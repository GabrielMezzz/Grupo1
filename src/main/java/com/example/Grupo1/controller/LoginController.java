package com.example.Grupo1.controller;

import com.example.Grupo1.model.Usuario;
import com.example.Grupo1.repository.UsuarioRepository;
import com.example.Grupo1.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo,
                                @RequestParam String contrasena,
                                HttpSession session,
                                Model model) {
        correo = correo.trim().toLowerCase();
        contrasena = contrasena.trim();

        // Admin
        if (correo.equals("admin@gmail.com") && contrasena.equals("123")) {
            session.setAttribute("usuario", correo);
            session.setAttribute("rol", "Administrador");
            return "redirect:/dashboard";
        }

        // Buscar cliente activo en la base de datos
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoAndContrasena(correo, contrasena);
        if (usuarioOpt.isPresent() && usuarioOpt.get().getEstado().equals("Activo")) {
            Usuario u = usuarioOpt.get();
            session.setAttribute("usuario", u.getCorreo());
            session.setAttribute("rol", u.getRol());
            session.setAttribute("usuarioObj", u);
            return "redirect:/eventos";
        }

        model.addAttribute("error", "Credenciales incorrectas o usuario inactivo");
        return "login";
    }

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            cargarErroresRegistro(usuario, bindingResult, model);
            return "registro";
        }

        usuario.setRol("Cliente");
        usuario.setEstado("Activo");

        try {
            usuarioService.guardarUsuario(usuario);
        } catch (IllegalArgumentException ex) {
            cargarErroresServicioRegistro(usuario, ex.getMessage(), model);
            return "registro";
        }

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }

    // Devuelve los errores de validacion en la misma pagina de registro
    private void cargarErroresRegistro(Usuario usuario, BindingResult bindingResult, Model model) {
        model.addAttribute("usuario", usuario);

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

    // Mensajes simples cuando el dato ya existe en la base de datos
    private void cargarErroresServicioRegistro(Usuario usuario, String mensaje, Model model) {
        model.addAttribute("usuario", usuario);

        if (mensaje.contains("DNI")) {
            model.addAttribute("errorDni", mensaje);
        } else if (mensaje.contains("correo")) {
            model.addAttribute("errorCorreo", mensaje);
        } else if (mensaje.contains("telefono")) {
            model.addAttribute("errorTelefono", mensaje);
        } else {
            model.addAttribute("error", mensaje);
        }
    }
}
