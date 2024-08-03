package com.campuslands.proyectospringboot.Barrio.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Barrio.domain.entities.Barrio;
import com.campuslands.proyectospringboot.Barrio.domain.repositories.BarrioRepository;

@Service
public class BarrioService {
    
    private final BarrioRepository barrioRepository;

    public BarrioService(BarrioRepository barrioRepository) {
        this.barrioRepository = barrioRepository;
    }

    public List<Barrio> list() {
        return barrioRepository.findAll();
    }

    public void create(Barrio barrio) {
        barrioRepository.save(barrio);
    }
}
