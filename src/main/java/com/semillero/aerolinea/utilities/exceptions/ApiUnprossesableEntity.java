package com.semillero.aerolinea.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Excepcion personalizada de status 422

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprossesableEntity extends Exception{

    public ApiUnprossesableEntity(String message){
        super(message);
    }
}
