package com.letseat.dao;


import com.letseat.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {    
    Usuario findByUsername(String username);
}
