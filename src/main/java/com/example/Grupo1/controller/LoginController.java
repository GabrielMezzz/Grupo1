package com.example.Grupo1.controller;

import com.example.Grupo1.model.Usuario;
import com.example.Grupo1.repository.UsuarioRepository;
import com.example.Grupo1.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String procesarRegistro(@ModelAttribute("usuario") Usuario usuario, Model model) {
        Usuario usuarioDni = usuarioService.buscarPorDni(usuario.getDni());
        if (usuarioDni != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("errorDni", "El DNI ya está registrado");
            return "registro";
        }

        String correoLimpio = usuario.getCorreo();
        if (correoLimpio != null) {
            correoLimpio = correoLimpio.trim().toLowerCase();
        }

        Usuario usuarioCorreo = usuarioService.buscarPorCorreo(correoLimpio);
        if (usuarioCorreo != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("errorCorreo", "El correo ya está registrado");
            return "registro";
        }

        String telefonoLimpio = usuario.getTelefono();
        if (telefonoLimpio != null) {
            while (telefonoLimpio.contains(" ")) {
                telefonoLimpio = telefonoLimpio.replace(" ", "");
            }
        }

        Usuario usuarioTelefono = usuarioService.buscarPorTelefono(telefonoLimpio);
        if (usuarioTelefono != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("errorTelefono", "El teléfono ya está registrado");
            return "registro";
        }

        if (correoLimpio != null) {
            usuario.setCorreo(correoLimpio);
        }
        if (telefonoLimpio != null) {
            usuario.setTelefono(telefonoLimpio);
        }

        String contrasenaLimpia = usuario.getContrasena();
        if (contrasenaLimpia != null) {
            usuario.setContrasena(contrasenaLimpia.trim());
        }

        usuario.setRol("Cliente");
        usuario.setEstado("Activo");
        usuarioService.guardarUsuario(usuario);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }
}
