package com.campuslands.proyectospringboot.Estado.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Estado.domain.entities.Estado;
import com.campuslands.proyectospringboot.Estado.infrastructure.adapters.out.EstadoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }

    public Estado findById(Long id) {
        return estadoRepository.findById(id).orElse(null);
    }

    public Estado save(Estado estado){
        return estadoRepository.save(estado);
    }

    public void deleteById(Long id) {
        estadoRepository.deleteById(id);
    }



}
