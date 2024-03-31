package com.functions.consultorio.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta")
public class CuentaModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long idCuenta;

    @Column(name = "nombre_cuenta")
    private String nombreCuenta;

    @Column(name = "apellido_p")
    private String apellidoP;

    @Column(name = "apellido_m")
    private String apellidoM;

    @Column(name = "sexo")
    private int sexo;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "eliminado_cuenta")
    private int eliminadoCuenta;

    public Long getIdCuenta() {
        return idCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEliminadoCuenta() {
        return eliminadoCuenta;
    }

    public void setEliminadoCuenta(int eliminadoCuenta) {
        this.eliminadoCuenta = eliminadoCuenta;
    }
}
