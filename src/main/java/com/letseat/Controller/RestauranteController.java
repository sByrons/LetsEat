package com.letseat.Controller;

import com.letseat.domain.Categoria;
import com.letseat.domain.Restaurante;
import com.letseat.service.CategoriaService;
import com.letseat.service.FirebaseStorageService;
import com.letseat.service.RestauranteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/lista")
    public String mostrarRestaurante(Model model) {
        List<Restaurante> restaurantes = restauranteService.getRestaurantes(false);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("restaurantes", restaurantes);
        model.addAttribute("categorias", categorias);
        return "/restaurante/lista";
    }

    @GetMapping("/lista/{idCategoria}")
    public String filtrarCategoria(@PathVariable Long idCategoria, Model model) {

        List<Restaurante> restaurantes = restauranteService.getRestaurantes(idCategoria);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("restaurantes", restaurantes);
        model.addAttribute("categorias", categorias);
        return "/restaurante/lista";
    }

    @GetMapping("/info/{idRestaurante}")
    public String mostrarRestaurante(Restaurante restaurante, Model model) {

        restaurante = restauranteService.getRestaurante(restaurante);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("restaurante", restaurante);
        model.addAttribute("categorias", categorias);
        return "/restaurante/info";
        
    }

    @PostMapping("/guardar")
    public String restauranteGuardar(Restaurante restaurante,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            restauranteService.save(restaurante);
            restaurante.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "restaurante",
                            restaurante.getIdRestaurante()));
        }
        restauranteService.save(restaurante);
        return "redirect:/restaurantes/lista";
    }

    @GetMapping("/eliminar/{idRestaurante}")
    public String restauranteEliminar(Restaurante restaurante) {
        restauranteService.delete(restaurante);
        return "redirect:/restaurantes/lista";
    }

    @GetMapping("/modificar/{idRestaurante}")
    public String restauranteModificar(Restaurante restaurante, Model model) {
        restaurante = restauranteService.getRestaurante(restaurante);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("restaurante", restaurante);
        model.addAttribute("categorias", categorias);
        return "/restaurante/modifica";
    }

}
