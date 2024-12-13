package com.letseat.service;

import com.letseat.domain.Reseña;
import java.util.List;

public interface ReseñaService {

    public List<Reseña> getReseñas(Long idRestaurante);

    public void save(Reseña reseña);

}
