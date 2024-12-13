
package com.letseat.service;

import com.letseat.domain.Categoria;
import com.letseat.domain.Restaurante;
import java.util.List;


public interface RestauranteService {
    
    // Se obtiene un listado de restaurantes en un List
    public List<Restaurante> getRestaurantes(boolean activos);
    
    //Obtener una lista de restaurantes por su id categoria
    
    public List<Restaurante> getRestaurantes(Long idCategoria);
    
    
   // Se obtiene un Restaurante, a partir del id de un restaurante
    public Restaurante getRestaurante(Restaurante restaurante);
    
    // Se inserta un nuevo restaurante si el id del restaurante esta vacío
    // Se actualiza un restaurante si el id del restaurante NO esta vacío
    public void save(Restaurante restaurante);
    
    // Se elimina el restaurante que tiene el id pasado por parámetro
    public void delete(Restaurante restaurante);
    
    //Busqueda por descripcion
    public List<Restaurante> buscarRestaurante(String item, String item2);
    
    Restaurante obtenerRestaurantePorId(long idRestaurante);
    
    
    
    
}
