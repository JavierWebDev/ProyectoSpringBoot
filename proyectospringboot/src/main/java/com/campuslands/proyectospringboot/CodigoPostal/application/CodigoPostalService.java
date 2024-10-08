package com.campuslands.proyectospringboot.CodigoPostal.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.CodigoPostal.domain.CodigoPostal;
import com.campuslands.proyectospringboot.CodigoPostal.infrastructure.adapters.out.CodigoPostalRepository;

@Service
public class CodigoPostalService {
    private final CodigoPostalRepository codigoPostalRepository;

    public CodigoPostalService(CodigoPostalRepository codigoPostalRepository) {
        this.codigoPostalRepository = codigoPostalRepository;
    }

    public List<CodigoPostal> findAll() {
        return codigoPostalRepository.findAll();
    }

    public Optional<CodigoPostal> findById(Long id) {
        return codigoPostalRepository.findById(id);
    }

    public void create(CodigoPostal codigoPostal) {
        codigoPostalRepository.save(codigoPostal);
    }

    public void deleteById(Long id) {
        codigoPostalRepository.deleteById(id);
    }
}
