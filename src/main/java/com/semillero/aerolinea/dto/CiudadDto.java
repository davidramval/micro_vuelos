package com.semillero.aerolinea.dto;

import java.io.Serializable;

public class CiudadDto implements Serializable {

    private int id;
    private String nombreCiudad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
