package com.semillero.aerolinea.validator;


import com.semillero.aerolinea.dto.PasajeroSaveRequest;
import com.semillero.aerolinea.dto.PasajeroUpdateRequest;
import com.semillero.aerolinea.utilities.exceptions.ApiUnprossesableEntity;
import org.springframework.stereotype.Component;

@Component
public class PasajerosValidatorImpl implements IPasajeroValidator {

    @Override
    public void validatorSave(PasajeroSaveRequest pasajeroSaveRequest) throws ApiUnprossesableEntity {

        if(pasajeroSaveRequest.getNombres() == null || pasajeroSaveRequest.getNombres().isEmpty()){
            message("Los nombres son obligatorios");
        }
        if(pasajeroSaveRequest.getNombres().length() < 3){
            message("Nombres incorrectos");
        }
        if(pasajeroSaveRequest.getApellidos() == null || pasajeroSaveRequest.getApellidos().isEmpty()){
            message("Los apellido son obligatorios");
        }
        if(pasajeroSaveRequest.getApellidos().length() < 3){
            message("Los apellidos son incorrectos");
        }
        if(pasajeroSaveRequest.getTipoDocumento() == null || pasajeroSaveRequest.getTipoDocumento().isEmpty()){
            message("El tipo de documento es obligatorio");
        }
        if(pasajeroSaveRequest.getNumeroDocumento() == null || pasajeroSaveRequest.getNumeroDocumento().isEmpty()){
            message("El numero de documento es obligatorio");
        }
        if(pasajeroSaveRequest.getNumeroDocumento().length() < 3){
            message("El numero de docuemnto es incorrecto");
        }
        if(pasajeroSaveRequest.getTelefono() == null || pasajeroSaveRequest.getTelefono().isEmpty()){
            message("El numero de telefono es obligatorio");
        }
        if(pasajeroSaveRequest.getTelefono().length() < 3){
            message("El numero de telefono es incorrecto");
        }
        if(pasajeroSaveRequest.getDireccion() == null || pasajeroSaveRequest.getDireccion().isEmpty()){
            message("La direccion es obligatoria");
        }
        if(pasajeroSaveRequest.getDireccion().length() < 3){
            message("La direccion es incorrecta");
        }
        if(pasajeroSaveRequest.getCorreo() == null || pasajeroSaveRequest.getCorreo().isEmpty()){
            message("El correo es obligatorio");
        }
        if(pasajeroSaveRequest.getCorreo().length() < 3){
            message("el correo es incorrecto");
        }
    }
    @Override
    public void validatorUpdate(PasajeroUpdateRequest pasajeroUpdateRequest) throws ApiUnprossesableEntity {

        if (pasajeroUpdateRequest.getNombres() == null || pasajeroUpdateRequest.getNombres().isEmpty()) {
            message("Los nombres son obligatorios");
        }
        if(pasajeroUpdateRequest.getApellidos() == null || pasajeroUpdateRequest.getApellidos().isEmpty()){
            message("Los apellidos son obligatorios");
        }
        if(pasajeroUpdateRequest.getTelefono() == null || pasajeroUpdateRequest.getTelefono().isEmpty()){
            message("El numero de telefono es obligatorio");
        }
        if(pasajeroUpdateRequest.getCorreo() == null || pasajeroUpdateRequest.getCorreo().isEmpty()){
            message("el numero de telefono es obligatorio");
        }
    }

    private void message (String message) throws ApiUnprossesableEntity {
        throw new ApiUnprossesableEntity(message);

    }
}
