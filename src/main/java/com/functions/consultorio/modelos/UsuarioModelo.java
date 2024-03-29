package com.functions.consultorio.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasena")
    private String contrasena;

    @OneToOne()
    @JoinColumn(name = "id_cuenta")
    private CuentaModelo idCuenta;

    @Column(name = "tipo")
    private int tipo;

    @Column(name = "eliminado_usuario")
    private int eliminadoUsuario;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public CuentaModelo getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(CuentaModelo idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEliminadoUsuario() {
        return eliminadoUsuario;
    }

    public void setEliminadoUsuario(int eliminadoUsuario) {
        this.eliminadoUsuario = eliminadoUsuario;
    }
}
