package com.semillero.aerolinea.dto;

import java.io.Serializable;

public class PasajeroVueloRequest implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
