package com.semillero.aerolinea.service;

import com.semillero.aerolinea.dto.PasajeroDto;
import com.semillero.aerolinea.dto.PasajeroSaveRequest;
import com.semillero.aerolinea.dto.PasajeroUpdateRequest;
import com.semillero.aerolinea.utilities.exceptions.ApiPasajeroConflict;
import com.semillero.aerolinea.utilities.exceptions.ApiUnprossesableEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IPasajeroService {

    public List<PasajeroDto> findAll();

    public PasajeroDto findById(int id);

    public PasajeroDto findByNumeroDocumento(String numeroDocumento);

    public PasajeroDto findByNombres(String nombres);

    public PasajeroDto save(PasajeroSaveRequest pasajeroSaveRequest) throws ApiPasajeroConflict, ApiUnprossesableEntity;

    public PasajeroDto update(PasajeroUpdateRequest pasajeroUpdateRequest, int id) throws ApiPasajeroConflict;

    public void deleteById(int id) throws ApiPasajeroConflict;

}
