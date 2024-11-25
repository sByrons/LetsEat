
package com.letseat.Controller;

import com.letseat.domain.Restaurante;
import com.letseat.service.RestauranteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/busqueda")
public class BusquedaController {
    
     @Autowired
    private RestauranteService restauranteService;
    
    @PostMapping("consulta")
    public String buscar(@RequestParam(value = "item") String item, Model model) {
     List<Restaurante> restaurante = restauranteService.buscarRestaurante(item, item);
     model.addAttribute("restaurantes", restaurante);
     model.addAttribute("item", item);
        return "/restaurante/lista";
    }
    
}
