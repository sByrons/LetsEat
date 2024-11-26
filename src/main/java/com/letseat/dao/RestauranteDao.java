
package com.letseat.dao;

import com.letseat.domain.Restaurante;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestauranteDao extends JpaRepository<Restaurante, Long> {
    
    public List<Restaurante> findByCategoriaIdCategoria(Long idCategoria);
    List<Restaurante> findByDescripcionContainingOrNombreContaining(String descripcion, String nombre);
    
}
