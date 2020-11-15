package com.semillero.aerolinea.repository;

import com.semillero.aerolinea.entity.VueloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVueloRepository extends JpaRepository<VueloEntity,Integer> {
}
