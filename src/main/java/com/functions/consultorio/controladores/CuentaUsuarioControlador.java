package com.functions.consultorio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.functions.consultorio.modelos.CuentaModelo;
import com.functions.consultorio.modelos.UsuarioModelo;
import com.functions.consultorio.servicios.CuentaServicio;
import com.functions.consultorio.servicios.UsuarioServicio;

@RestController
@RequestMapping("/cuentausuario")
public class CuentaUsuarioControlador {
    @Autowired
    private CuentaServicio cuentaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping
    public boolean crearCuentaUsuario(@RequestBody CuentaModelo cuentaModelo, @RequestBody UsuarioModelo usuarioModelo){
        try {
            CuentaModelo nuevaCuenta = this.cuentaServicio.crearCuenta(cuentaModelo);
            this.usuarioServicio.crearUsuario(usuarioModelo, nuevaCuenta);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping(path = "/{id}")
    public boolean eliminarCuentaUsuario(@PathVariable("id") Long id){
        try {
            UsuarioModelo usuarioEliminado = this.usuarioServicio.getUsuario(id).get();
            CuentaModelo cuentaEliminada = usuarioEliminado.getIdCuenta();
            this.usuarioServicio.eliminarUsuario(usuarioEliminado.getIdUsuario());
            this.cuentaServicio.eliminarCuenta(cuentaEliminada.getIdCuenta());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
