package com.campuslands.proyectospringboot.Barrio.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Barrio.domain.Barrio;
import com.campuslands.proyectospringboot.Barrio.infrastructure.Out.persistence.BarrioRepository;

@Service
public class BarrioService {

    private final BarrioRepository barrioRepository;

    public BarrioService(BarrioRepository barrioRepository) {
        this.barrioRepository = barrioRepository;
    }

    public List<Barrio> list() {
        return barrioRepository.findAll();
    }

    public Optional<Barrio> findById(Long id) {
        return barrioRepository.findById(id);
    }

    public void create(Barrio barrio) {
        barrioRepository.save(barrio);
    }
}
