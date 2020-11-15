package com.semillero.aerolinea.service.impl;

import com.semillero.aerolinea.dto.PasajeroDto;
import com.semillero.aerolinea.dto.PasajeroSaveRequest;
import com.semillero.aerolinea.dto.PasajeroUpdateRequest;
import com.semillero.aerolinea.entity.PasajeroEntity;
import com.semillero.aerolinea.repository.IPasajeroRepository;
import com.semillero.aerolinea.service.IPasajeroService;
import com.semillero.aerolinea.utilities.exceptions.ApiPasajeroConflict;
import com.semillero.aerolinea.utilities.exceptions.ApiUnprossesableEntity;
import com.semillero.aerolinea.utilities.helpers.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class PasajeroImpl implements IPasajeroService {

    @Autowired
    private IPasajeroRepository pasajeroRepo;


    @Override
    public List<PasajeroDto> findAll() {
        List<PasajeroDto> listPasajeroDTO = new ArrayList<>();
        Iterable<PasajeroEntity> pasajeros = pasajeroRepo.findAll();

        for (PasajeroEntity pasajeroEntity : pasajeros) {
            PasajeroDto pasajeroDto = MHelpers.modelMapper().map(pasajeroEntity, PasajeroDto.class);
            listPasajeroDTO.add(pasajeroDto);
        }
        return listPasajeroDTO;
    }

    @Override
    public PasajeroDto findById(int id) {
        Optional<PasajeroEntity> pasajero = pasajeroRepo.findById(id);
        PasajeroDto pasajeroDto = null;
        if (pasajero.isPresent()) {
            pasajeroDto = MHelpers.modelMapper().map(pasajero.get(), PasajeroDto.class);
        }
        return pasajeroDto;
    }

    @Override
    public PasajeroDto findByNumeroDocumento(String numeroDocumento) {
        Optional<PasajeroEntity> pasajero = pasajeroRepo.findByNumeroDocumento(numeroDocumento);
        PasajeroDto pasajeroDto = null;
        if (pasajero.isPresent()) {
            pasajeroDto = MHelpers.modelMapper().map(pasajero.get(), PasajeroDto.class);
        }
        return pasajeroDto;
    }

    @Override
    public PasajeroDto findByNombres(String nombres) {
        Optional<PasajeroEntity> pasajero = pasajeroRepo.findByNombres(nombres);
        PasajeroDto pasajeroDto = null;
        if (pasajero.isPresent()) {
            pasajeroDto = MHelpers.modelMapper().map(pasajero.get(), PasajeroDto.class);
        }
        return pasajeroDto;

    }

    @Override
    public void save(PasajeroSaveRequest pasajeroSaveRequest) throws ApiPasajeroConflict, ApiUnprossesableEntity {
        PasajeroEntity pasajeroEntity = MHelpers.modelMapper().map(pasajeroSaveRequest, PasajeroEntity.class);
        Optional<PasajeroEntity> optionalPasajero = pasajeroRepo.findByNumeroDocumento(pasajeroSaveRequest.getNumeroDocumento());
        if (optionalPasajero.isPresent()) {
            throw new ApiPasajeroConflict("El numero de documento ya existe");
        }
        pasajeroRepo.save(pasajeroEntity);

    }

    @Override
    public void update(PasajeroUpdateRequest pasajeroUpdateRequest, int id) {
        Optional<PasajeroEntity> pasajeroOptional = pasajeroRepo.findById(id);
        if (pasajeroOptional.isPresent()) {
            PasajeroEntity pasajeroEntity = pasajeroOptional.get();
            pasajeroEntity.setNombres(pasajeroUpdateRequest.getNombres());
            pasajeroEntity.setApellidos(pasajeroUpdateRequest.getApellidos());
            pasajeroEntity.setTelefono(pasajeroUpdateRequest.getTelefono());
            pasajeroEntity.setDireccion(pasajeroUpdateRequest.getDireccion());
            pasajeroEntity.setCorreo(pasajeroUpdateRequest.getCorreo());
            pasajeroRepo.save(pasajeroEntity);
        }
    }

    @Override
    public void deleteById(int id) throws ApiPasajeroConflict {
        Optional<PasajeroEntity> optional = pasajeroRepo.findById(id);
        if (!optional.isPresent()) {
            throw new ApiPasajeroConflict("El id del pasajero no existe");
        }
        pasajeroRepo.deleteById(id);
    }

    private PasajeroDto convertToPasajeroDto(final PasajeroEntity pasajeroEntity) {

        return MHelpers.modelMapper().map(pasajeroEntity, PasajeroDto.class);
    }
}


