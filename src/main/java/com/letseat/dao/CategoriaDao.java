
package com.letseat.dao;

import com.letseat.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDao extends JpaRepository<Categoria, Long>{
   
    
}
