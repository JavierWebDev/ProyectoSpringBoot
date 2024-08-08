package com.campuslands.proyectospringboot.Dimensiones.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Dimensiones.domain.entities.Dimensiones;
import com.campuslands.proyectospringboot.Dimensiones.infrastructure.adapters.out.DimensionesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DimensionesService {

    private final DimensionesRepository dimensionesRepository;

    public List<Dimensiones> findAll(){
        return dimensionesRepository.findAll(); 
    }

    public Optional<Dimensiones> findById(Long id){
        return dimensionesRepository.findById(id);
    }

    public Dimensiones save(Dimensiones dimensiones){
        return dimensionesRepository.save(dimensiones);
    }

    public void deleteById(Long id) {
        dimensionesRepository.deleteById(id);
    }
}
