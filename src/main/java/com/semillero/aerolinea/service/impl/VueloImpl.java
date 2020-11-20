package com.semillero.aerolinea.service.impl;

import com.semillero.aerolinea.dto.PasajeroDto;
import com.semillero.aerolinea.dto.VueloDto;
import com.semillero.aerolinea.dto.VueloSaveRequest;
import com.semillero.aerolinea.entity.PasajeroEntity;
import com.semillero.aerolinea.entity.VueloEntity;
import com.semillero.aerolinea.repository.IVueloRepository;
import com.semillero.aerolinea.service.IVueloService;
import com.semillero.aerolinea.utilities.exceptions.VueloApiConflict;
import com.semillero.aerolinea.utilities.helpers.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VueloImpl implements IVueloService {

    @Autowired
    private IVueloRepository vueloRepo;


    @Override
    public List<VueloDto> findAll() {
        List<VueloDto> listVueloDTO = new ArrayList<>();
        Iterable<VueloEntity> vuelos = vueloRepo.findAll();

        for (VueloEntity vueloEntity : vuelos) {
            VueloDto vueloDto = MHelpers.modelMapper().map(vueloEntity, VueloDto.class);
            listVueloDTO.add(vueloDto);
        }
        return listVueloDTO;
    }

    @Override
    public void save(VueloSaveRequest vueloSaveRequest) {
        VueloEntity vueloEntity = MHelpers.modelMapper().map(vueloSaveRequest, VueloEntity.class);
        vueloRepo.save(vueloEntity);
    }

    @Override
    public VueloDto update(VueloSaveRequest vueloSaveRequest, int id) throws VueloApiConflict {
        Optional<VueloEntity> optionalVuelo = vueloRepo.findById(id);
        if (optionalVuelo.isPresent()){
            VueloEntity vueloEntity = MHelpers.modelMapper().map(vueloSaveRequest, VueloEntity.class);
            vueloEntity.setId(optionalVuelo.get().getId());
            vueloRepo.save(vueloEntity);
            return MHelpers.modelMapper().map(vueloEntity, VueloDto.class);
        } else {
          throw new VueloApiConflict("el id del vuelo no exite");
        }

    }

    @Override
    public void deleteById(int id) throws VueloApiConflict {
        Optional<VueloEntity> optionalVueloEntity = vueloRepo.findById(id);
        if (!optionalVueloEntity.isPresent()){
            throw new VueloApiConflict("El id del vuelo no existe");
        }
        vueloRepo.deleteById(id);

    }

    @Override
    public VueloDto findById(int id) {
        Optional<VueloEntity> vuelo = vueloRepo.findById(id);
        VueloDto VueloDto = null;
        if (vuelo.isPresent()) {
            VueloDto = MHelpers.modelMapper().map(vuelo.get(), VueloDto.class);
        }
        return VueloDto;
    }

    private VueloDto convertToVueloDto (final VueloEntity vueloEntity){

        return MHelpers.modelMapper().map(vueloEntity, VueloDto.class);
    }
}



