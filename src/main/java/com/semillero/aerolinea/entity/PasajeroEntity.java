package com.semillero.aerolinea.entity;

import javax.persistence.*;

@Entity
@Table(name = "pasajeros")
public class PasajeroEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Column (name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column (name = "tipo_documento", nullable = false, length = 3)
    private String tipoDocumento;

    @Column (name = "numero_documento",nullable = false, length = 15)
    private String numeroDocumento;

    @Column (name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column (name = "direccion", length = 50)
    private String direccion;

    @Column (name = "correo", nullable = false, length = 50)
    private String correo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
