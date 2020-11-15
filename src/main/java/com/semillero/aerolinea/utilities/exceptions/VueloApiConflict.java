package com.semillero.aerolinea.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class VueloApiConflict extends Exception{

    public VueloApiConflict(String message){
        super(message);
    }
}
