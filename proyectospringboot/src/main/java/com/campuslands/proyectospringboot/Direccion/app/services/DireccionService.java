package com.campuslands.proyectospringboot.Direccion.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Direccion.domain.entities.Direccion;
import com.campuslands.proyectospringboot.Direccion.infrastructure.adapters.out.DireccionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DireccionService {

    private final DireccionRepository direccionRepository;
    
    public List<Direccion> findAll(){
        return direccionRepository.findAll();
    }

    public Optional<Direccion> findById(Long id){
        return direccionRepository.findById(id);
    }

    public Direccion save(Direccion direccion){
        return direccionRepository.save(direccion);
    }

    public void deleteById(Long id) {
        direccionRepository.deleteById(id);
    }

}
