package com.semillero.aerolinea.service;

import com.semillero.aerolinea.dto.VueloDto;
import com.semillero.aerolinea.dto.VueloSaveRequest;
import com.semillero.aerolinea.utilities.exceptions.VueloApiConflict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVueloService {

    public List<VueloDto> findAll();
    public void save(VueloSaveRequest vueloSaveRequest);
    public void update(VueloSaveRequest vueloSaveRequest, int id) throws VueloApiConflict;
    public void deleteById(int id) throws VueloApiConflict;
}
