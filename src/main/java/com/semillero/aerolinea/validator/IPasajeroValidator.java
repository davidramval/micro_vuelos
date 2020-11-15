package com.semillero.aerolinea.validator;

import com.semillero.aerolinea.dto.PasajeroSaveRequest;
import com.semillero.aerolinea.dto.PasajeroUpdateRequest;
import com.semillero.aerolinea.utilities.exceptions.ApiUnprossesableEntity;
import org.springframework.stereotype.Service;

//Es la interface para la validacion de datos recibidos para la creacion de pasajeros

@Service
public interface IPasajeroValidator {

    public void validatorSave(PasajeroSaveRequest pasajeroSaveRequest) throws ApiUnprossesableEntity;
    public void validatorUpdate(PasajeroUpdateRequest pasajeroUpdateRequest) throws ApiUnprossesableEntity;
}
