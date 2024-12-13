package com.letseat.service.impl;

import com.letseat.dao.ReseñaDao;
import com.letseat.domain.Reseña;
import com.letseat.service.ReseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseñaServiceImpl implements ReseñaService {

    // Inyección de dependencia del DAO
    @Autowired
    private ReseñaDao reseñaDao;

    @Override
    public List<Reseña> getReseñas(Long idRestaurante) {
        // Llama al método del DAO para obtener las reseñas por restaurante
        return reseñaDao.findByRestauranteIdRestaurante(idRestaurante);
    }

    @Override
    public void save(Reseña reseña) {
        // Llama al método del DAO para guardar o actualizar la reseña
        reseñaDao.save(reseña);
    }
}