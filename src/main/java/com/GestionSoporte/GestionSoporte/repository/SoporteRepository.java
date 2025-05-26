package com.GestionSoporte.GestionSoporte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionSoporte.GestionSoporte.model.Soporte;

@Repository
public interface SoporteRepository extends JpaRepository<Soporte, Integer>{

    
    
}


