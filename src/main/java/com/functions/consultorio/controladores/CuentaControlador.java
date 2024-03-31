package com.functions.consultorio.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.functions.consultorio.modelos.CuentaModelo;
import com.functions.consultorio.servicios.CuentaServicio;

@RestController
@RequestMapping("/cuenta")
public class CuentaControlador {
    @Autowired
    private CuentaServicio cuentaServicio;

    @GetMapping
    public ArrayList<CuentaModelo> getCuentas(){
        return this.cuentaServicio.getCuentas();
    }

    @GetMapping(path = "/{id}")
    public Optional<CuentaModelo> getCuenta(@PathVariable Long id){
        return this.cuentaServicio.getCuenta(id);
    }

    @PutMapping(path = "/{id}")
    public CuentaModelo actualizarCuenta(@RequestBody CuentaModelo cuenta, @PathVariable("id") Long id){
        return this.cuentaServicio.actualizarCuenta(cuenta, id);
    }
}
