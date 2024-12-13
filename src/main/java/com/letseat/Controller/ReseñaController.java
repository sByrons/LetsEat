package com.letseat.Controller;

import com.letseat.domain.Reseña;
import com.letseat.domain.Restaurante;
import com.letseat.domain.Usuario;
import com.letseat.service.ReseñaService;
import com.letseat.service.RestauranteService;
import com.letseat.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reseña")
public class ReseñaController {

    @Autowired
    private ReseñaService reseñaService;

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/guardar")
    public String reseñaGuardar(@RequestParam("comentario") String comentario,
                                 @RequestParam("valoracion") int valoracion,
                                 @RequestParam("idRestaurante") long idRestaurante,
                                 @RequestParam("idUsuario") long idUsuario) {

        // Obtener las instancias de Restaurante y Usuario
        Restaurante restaurante = restauranteService.obtenerRestaurantePorId(idRestaurante);
        Usuario usuario = usuarioService.obtenerUsuarioPorId(idUsuario);

        // Crear la reseña con los datos recibidos
        Reseña reseña = new Reseña(comentario, valoracion, restaurante, usuario);

        // Guardar la reseña
        reseñaService.save(reseña);

        // Redirigir a la página de inicio o al restaurante
        return "redirect:/restaurantes/info/"+ idRestaurante; // O puedes redirigir al detalle del restaurante
    }
}
