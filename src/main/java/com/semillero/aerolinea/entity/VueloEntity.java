package com.semillero.aerolinea.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vuelos")
public class VueloEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero_vuelo", nullable = false, length = 50)
    private String numeroVuelo;

    @Column(name = "codigo_avion", nullable = false, length = 50)
    private String codigoAvion;

    @Column(name = "fecha_salida", nullable = false)
    private Date fechaSalida;

    @JoinColumn(name = "id_ciudad_salida", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CiudadEntity ciudadSalida;

    @JoinColumn(name = "id_ciudad_destino", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CiudadEntity ciudadDestino;

    @ManyToMany
    @JoinTable(
            name = "vuelos_por_pasajeros",
            joinColumns = @JoinColumn(name = "id_vuelo"),
            inverseJoinColumns = @JoinColumn(name = "id_pasajero"),
            uniqueConstraints = @UniqueConstraint(columnNames={"id_vuelo", "id_pasajero"})
    )
    private List<PasajeroEntity> pasajeroList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public CiudadEntity getCiudadSalida() {
        return ciudadSalida;
    }

    public void setCiudadSalida(CiudadEntity ciudadSalida) {
        this.ciudadSalida = ciudadSalida;
    }

    public CiudadEntity getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(CiudadEntity ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public List<PasajeroEntity> getPasajeroList() {
        return pasajeroList;
    }

    public void setPasajeroList(List<PasajeroEntity> pasajeroList) {
        this.pasajeroList = pasajeroList;
    }
}



