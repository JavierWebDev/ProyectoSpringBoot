package com.campuslands.proyectospringboot.Direccion.app.services;

import java.util.List;

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

    public Direccion findById(Long id) {
        return direccionRepository.findById(id).orElse(null);
    }

    public Direccion save(Direccion direccion){
        return direccionRepository.save(direccion);
    }

    public void deleteById(Long id) {
        direccionRepository.deleteById(id);
    }

}
