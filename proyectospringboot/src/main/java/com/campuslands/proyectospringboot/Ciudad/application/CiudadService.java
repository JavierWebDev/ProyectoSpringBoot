package com.campuslands.proyectospringboot.Ciudad.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Ciudad.domain.Ciudad;
import com.campuslands.proyectospringboot.Ciudad.infrastructure.adapters.CiudadRepository;

@Service
public class CiudadService {
    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public List<Ciudad> list() {
        return ciudadRepository.findAll();
    }

    public Optional<Ciudad> findById(Long id) {
        return ciudadRepository.findById(id);
    }

    public void create(Ciudad ciudad) {
        ciudadRepository.save(ciudad);
    }

    public void deleteById(Long id) {
        ciudadRepository.deleteById(id);
    }
}
