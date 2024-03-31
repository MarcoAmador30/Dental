package com.functions.consultorio.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.functions.consultorio.modelos.CuentaModelo;
import com.functions.consultorio.repositorios.CuentaRepository;

@Service
public class CuentaServicio {
    @Autowired
    CuentaRepository cuentaRepository;

    public ArrayList<CuentaModelo> getCuentas(){
        return (ArrayList<CuentaModelo>) cuentaRepository.findAll();
    }

    public Optional<CuentaModelo> getCuenta(Long id){
        return cuentaRepository.findById(id);
    }

    public CuentaModelo crearCuenta(CuentaModelo cuenta){
        return cuentaRepository.save(cuenta);
    }

    public CuentaModelo actualizarCuenta(CuentaModelo peticion, Long id){
        CuentaModelo cuentaAuxiliar = cuentaRepository.findById(id).get();
        cuentaAuxiliar.setNombreCuenta(peticion.getNombreCuenta());
        cuentaAuxiliar.setApellidoP(peticion.getApellidoP());
        cuentaAuxiliar.setApellidoM(peticion.getApellidoM());
        cuentaAuxiliar.setSexo(peticion.getSexo());
        cuentaAuxiliar.setFechaNacimiento(peticion.getFechaNacimiento());

        cuentaRepository.save(cuentaAuxiliar);
        return cuentaAuxiliar;
    }

    public Boolean eliminarCuenta(Long id){
        try {
            CuentaModelo cuentaAuxiliar = cuentaRepository.findById(id).get();
            cuentaAuxiliar.setEliminadoCuenta(1);
            cuentaRepository.save(cuentaAuxiliar);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
