package com.semillero.aerolinea.controller;

import com.semillero.aerolinea.dto.VueloSaveRequest;
import com.semillero.aerolinea.service.IVueloService;
import com.semillero.aerolinea.utilities.exceptions.VueloApiConflict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vuelos")
public class VueloApiController {

    @Autowired
    private IVueloService vueloservice;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index() {

        return ResponseEntity.ok(vueloservice.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody VueloSaveRequest vueloSaveRequest){
        vueloservice.save(vueloSaveRequest);

        return ResponseEntity.ok("El Vuelo se creo correctamente");
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> update(@RequestBody VueloSaveRequest vueloSaveRequest, @PathVariable int id) throws VueloApiConflict {
        vueloservice.update(vueloSaveRequest, id);

        return ResponseEntity.ok("el vuelo se actualizo correctamente");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) throws VueloApiConflict{
        vueloservice.deleteById(id);

        return ResponseEntity.ok("El vuelo se elimino correctamente");
    }

}
