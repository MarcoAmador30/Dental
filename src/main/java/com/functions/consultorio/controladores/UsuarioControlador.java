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

import com.functions.consultorio.modelos.UsuarioModelo;
import com.functions.consultorio.servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public ArrayList<UsuarioModelo> getUsuarios(){
        return this.usuarioServicio.getUsuarios();
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModelo> getUsuario(@PathVariable Long id){
        return this.usuarioServicio.getUsuario(id);
    }

    @PutMapping(path = "/{id}")
    public UsuarioModelo actualizarUsuario(@RequestBody UsuarioModelo usuario, @PathVariable("id") Long id){
        return this.usuarioServicio.actualizarUsuario(usuario, id);
    }
}
