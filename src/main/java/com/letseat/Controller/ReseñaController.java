package com.letseat.Controller;

import com.letseat.domain.Reseña;
import com.letseat.domain.Restaurante;
import com.letseat.domain.Usuario;
import com.letseat.service.ReseñaService;
import com.letseat.service.RestauranteService;
import com.letseat.service.UsuarioService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reseña")
public class ReseñaController {

    @Autowired
    private ReseñaService reseñaService;
    private RestauranteService restauranteService;
    private UsuarioService usuarioService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var reseña = reseñaService.getReseñas(false);
        model.addAttribute("reseña", reseña);
        model.addAttribute("totalReseñas", reseña.size());
        return "/reseña/listado";
    }

    @GetMapping("/nuevo")
    public String reseñaNuevo(Reseña reseña) {
        return "/reseña/modifica";
    }

    @PostMapping("/guardar")
    public String reseñaGuardar(Reseña reseña) {
        reseñaService.save(reseña);
        return "redirect:/restaurante/info";
    }

    @GetMapping("/eliminar/{idReseña}")
    public String reseñaEliminar(Reseña reseña) {
        reseñaService.delete(reseña);
        return "redirect:/reseña/listado";
    }

    @GetMapping("/modificar/{idReseña}")
    public String reseñaModificar(Reseña reseña, Model model) {
        reseña = reseñaService.getReseña(reseña);
        model.addAttribute("reseña", reseña);
        return "/reseña/modifica";

    }

    @PostMapping("/reseñas/agregar")
    public String agregarReseña(
            @RequestParam("idRestaurante") Long idRestaurante,
            @RequestParam("comentario") String comentario,
            @RequestParam("calificacion") int valoracion,
            Principal principal // Asegúrate de inyectar Principal para obtener el nombre del usuario autenticado
    ) {
        // Obtener el restaurante
        Restaurante restaurante = restauranteService.obtenerRestaurantePorId(idRestaurante);

//        // Obtener el usuario autenticado
//        Usuario usuario = usuarioService.obtenerUsuarioPorEmail(principal.getName());

        // Crear y guardar la nueva reseña
        Reseña reseña = new Reseña();
        reseña.setRestaurante(restaurante);
//        reseña.setUsuario(usuario);
        reseña.setComentario(comentario);
        reseña.setValoracion(valoracion);
        reseñaService.save(reseña);

        // Redirigir al detalle del restaurante
        return "redirect:/info/" + idRestaurante;
    }
}
