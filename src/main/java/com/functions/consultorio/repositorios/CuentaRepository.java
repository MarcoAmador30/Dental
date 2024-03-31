package com.functions.consultorio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.functions.consultorio.modelos.CuentaModelo;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaModelo, Long> {
    
}
