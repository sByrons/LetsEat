package com.letseat.dao;

import com.letseat.domain.Reseña;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReseñaDao extends JpaRepository<Reseña, Long> {
    
    List<Reseña> findByRestauranteIdRestaurante(Long idRestaurante);

}
