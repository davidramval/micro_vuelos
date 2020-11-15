package com.semillero.aerolinea.repository;


import com.semillero.aerolinea.entity.PasajeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Repository
public interface IPasajeroRepository extends JpaRepository<PasajeroEntity, Integer> {

    @Transactional
    Optional<PasajeroEntity> findByNumeroDocumento(String numeroDocumento);

    @Transactional
    Optional<PasajeroEntity> findByNombres(String nombres);


}
