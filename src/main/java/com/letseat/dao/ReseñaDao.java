
package com.letseat.dao;

import com.letseat.domain.Reseña;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ReseñaDao extends JpaRepository<Reseña, Long>{
    @Query("SELECT r FROM Reseña r JOIN FETCH r.usuario WHERE r.restaurante.id = :idRestaurante")
    List<Reseña> findByRestauranteId(@Param("idRestaurante") Long idRestaurante);
   
    
}
