package com.functions.consultorio.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.functions.consultorio.modelos.CuentaModelo;
import com.functions.consultorio.modelos.UsuarioModelo;
import com.functions.consultorio.repositorios.UsuarioRepository;

@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModelo> getUsuarios(){
        return (ArrayList<UsuarioModelo>) usuarioRepository.findAll();
    }

    public Optional<UsuarioModelo> getUsuario(Long id){
        return usuarioRepository.findById(id);
    }

    public UsuarioModelo crearUsuario(UsuarioModelo usuario, CuentaModelo id){
        usuario.setIdCuenta(id);
        return usuarioRepository.save(usuario);
    }

    public UsuarioModelo actualizarUsuario(UsuarioModelo peticion, Long id){
        UsuarioModelo usuarioAuxiliar = usuarioRepository.findById(id).get();
        usuarioAuxiliar.setCorreo(peticion.getCorreo());
        usuarioAuxiliar.setContrasena(peticion.getContrasena());

        usuarioRepository.save(usuarioAuxiliar);
        return usuarioAuxiliar;
    }

    public Boolean eliminarUsuario(Long id){
        try {
            UsuarioModelo usuarioAuxiliar = usuarioRepository.findById(id).get();
            usuarioAuxiliar.setEliminadoUsuario(1);
            usuarioRepository.save(usuarioAuxiliar);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
