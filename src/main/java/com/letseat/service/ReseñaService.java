
package com.letseat.service;

import com.letseat.domain.Reseña;
import java.util.List;

public interface ReseñaService {
       public List<Reseña> getReseñas(boolean activos);
       
       public List<Reseña> obtenerReseñasPorRestaurante(long idRestaurante);
       

    
   
    public Reseña getReseña(Reseña reseña);
    
    
    public void save(Reseña reseña);
    
   
    public void delete(Reseña reseña);
 
}
