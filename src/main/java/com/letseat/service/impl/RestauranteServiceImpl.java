package com.letseat.service.impl;

import com.letseat.dao.RestauranteDao;
import com.letseat.domain.Categoria;
import com.letseat.domain.Restaurante;
import com.letseat.service.RestauranteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteDao restauranteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Restaurante> getRestaurantes(boolean activos) {
        var lista = restauranteDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Restaurante> getRestaurantes(Long idCategoria) {

        return restauranteDao.findByCategoriaIdCategoria(idCategoria);

    }
    

    @Override
    @Transactional(readOnly = true)
    public Restaurante getRestaurante(Restaurante restaurante) {
        return restauranteDao.findById(restaurante.getIdRestaurante()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Restaurante restaurante) {
        restauranteDao.save(restaurante);
    }

    @Override
    @Transactional
    public void delete(Restaurante restaurante) {
        restauranteDao.delete(restaurante);
    }

    @Override
    @Transactional
    public List<Restaurante> buscarRestaurante(String item, String item2) {
        return restauranteDao.findByDescripcionContainingOrNombreContaining(item, item2);
    }
    
    @Override
    public Restaurante obtenerRestaurantePorId(long idRestaurante) {
        return restauranteDao.findById(idRestaurante).orElse(null);
    }
    
    
}
