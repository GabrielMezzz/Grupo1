package com.example.Grupo1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/main")
    public String main(Model model) {

        List<Map<String, String>> categorias = List.of(
                Map.of("nombre", "Conciertos",
                        "descripcion", "Un concierto no es solo música sonando en altavoces; es el momento exacto donde la energía de la multitud y el talento en el escenario se vuelven uno solo. Es sentir la vibración del bajo en el pecho, perder la voz cantando tu himno favorito y compartir una mirada de complicidad con miles de desconocidos que sienten lo mismo que tú."),
                Map.of("nombre", "Teatros",
                        "descripcion", "Cruzar el umbral del teatro es entrar en un mundo donde el tiempo se detiene y las historias cobran vida a solo unos metros de ti. No es una pantalla, es el suspiro de un actor, el crujido de las tablas y la energía de una audiencia que respira al unísono."),
                Map.of("nombre", "Stand up y Monólogos",
                        "descripcion", "Dicen que la risa es la mejor medicina, pero nosotros preferimos llamarlo terapia sin filtro. Olvida los problemas del día y ven a reírte de lo que todos pensamos pero nadie se atreve a decir."),
                Map.of("nombre", "Espectáculos",
                        "descripcion", "Donde la música se apodera de tus sentidos y la noche cobra vida propia. Olvida el reloj y déjate llevar por una producción de primer nivel: luces que cortan el aire, un sonido que te recorre el cuerpo.")
        );

        model.addAttribute("categorias", categorias);
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/gestion")
    public String gestion() {
        return "gestion";
    }

    @GetMapping("/metricas")
    public String metricas() {
        return "metricas";
    }

    @GetMapping("/publicidad")
    public String publicidad(Model model) {

        List<Map<String, String>> eventos = List.of(
                Map.of("nombre", "Red Hot Chilli Peppers",
                        "fecha", "15 de Mayo, 2026", "lugar", "Estadio Nacional, Lima",
                        "artista", "Banda Rockera", "precio", "150"),
                Map.of("nombre", "Romeo y Julieta",
                        "fecha", "20 de Mayo, 2026", "lugar", "Teatro Municipal, Lima",
                        "artista", "Teatro Nacional", "precio", "80"),
                Map.of("nombre", "Franco Escamilla",
                        "fecha", "25 de Mayo, 2026", "lugar", "Centro de Convenciones",
                        "artista", "Comediante Mexicano", "precio", "200"),
                Map.of("nombre", "Circo del Sol",
                        "fecha", "30 de Mayo, 2026", "lugar", "Parque de la Exposición",
                        "artista", "Arte Vivo", "precio", "200")
        );

        model.addAttribute("eventos", eventos);
        return "publicidad";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }
}