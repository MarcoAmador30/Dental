package com.functions.consultorio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.functions.consultorio.modelos.UsuarioModelo;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModelo, Long>{
    
}
