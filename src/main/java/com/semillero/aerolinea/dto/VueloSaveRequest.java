package com.semillero.aerolinea.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class VueloSaveRequest implements Serializable {


    private String numeroVuelo;
    private String codigoAvion;
    private Date fechaSalida;
    private CiudadDto ciudadSalida;
    private CiudadDto ciudadDestino;
    private List<PasajeroDto> pasajeroList;

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public CiudadDto getCiudadSalida() {
        return ciudadSalida;
    }

    public void setCiudadSalida(CiudadDto ciudadSalida) {
        this.ciudadSalida = ciudadSalida;
    }

    public CiudadDto getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(CiudadDto ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public List<PasajeroDto> getPasajeroList() {
        return pasajeroList;
    }

    public void setPasajeroList(List<PasajeroDto> pasajeroList) {
        this.pasajeroList = pasajeroList;
    }
}
