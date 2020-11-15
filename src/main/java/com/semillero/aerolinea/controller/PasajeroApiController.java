package com.semillero.aerolinea.controller;

import com.semillero.aerolinea.dto.PasajeroSaveRequest;
import com.semillero.aerolinea.dto.PasajeroUpdateRequest;
import com.semillero.aerolinea.service.IPasajeroService;
import com.semillero.aerolinea.utilities.exceptions.ApiPasajeroConflict;
import com.semillero.aerolinea.utilities.exceptions.ApiUnprossesableEntity;
import com.semillero.aerolinea.validator.PasajerosValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pasajero")
public class PasajeroApiController {

    @Autowired
    private IPasajeroService pasajeroservice;
    @Autowired
    private PasajerosValidatorImpl validator;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody PasajeroSaveRequest requestSave) throws ApiPasajeroConflict, ApiUnprossesableEntity {
        validator.validatorSave(requestSave);
        pasajeroservice.save(requestSave);

        return ResponseEntity.ok("El pasajero se creo correctamente");

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> update(@RequestBody PasajeroUpdateRequest requestUpdate, @PathVariable int id) throws ApiUnprossesableEntity {
        validator.validatorUpdate(requestUpdate);
        pasajeroservice.update(requestUpdate, id);

        return ResponseEntity.ok("El pasajero se actualizo correctamente");

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) throws ApiPasajeroConflict {
        pasajeroservice.deleteById(id);

        return ResponseEntity.ok("El pasajero se elimino correctamente");

    }

    @GetMapping(value = "/numeroDocumento/{numeroDocumento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getByNumeroDocumento(@PathVariable(value = "numeroDocumento") String numeroDocumento) {

        return ResponseEntity.ok(pasajeroservice.findByNumeroDocumento(numeroDocumento));

    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index() {

        return ResponseEntity.ok(pasajeroservice.findAll());

    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(pasajeroservice.findById(id));
    }

    @GetMapping(value = "/nombres/{nombres}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getByNombres(@PathVariable(value = "nombres") String nombres) {

        return ResponseEntity.ok(pasajeroservice.findByNombres(nombres));

    }
}
