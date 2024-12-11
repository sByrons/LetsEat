
package com.letseat.service.impl;

import com.letseat.dao.ReseñaDao;
import com.letseat.domain.Reseña;
import com.letseat.service.ReseñaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReseñaServiceImpl implements ReseñaService {
    
    

    @Autowired
    private ReseñaDao reseñaDao;

    @Override
    public List<Reseña> getReseñas(boolean activos) {
        List<Reseña> lista= reseñaDao.findAll();
        if (activos) {
            lista.removeIf(e -> e.getIdReseña()== 0);
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Reseña getReseña(Reseña reseña) {
        return reseñaDao.findById(reseña.getIdReseña()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reseña reseña) {
        reseñaDao.save(reseña);
    }

    @Override
    @Transactional
    public void delete(Reseña reseña) {
        reseñaDao.delete(reseña);
    }
    
      @Override
    public List<Reseña> obtenerReseñasPorRestaurante(long idRestaurante) {
        return reseñaDao.findByRestauranteId(idRestaurante);
    }
}

