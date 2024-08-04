package com.campuslands.proyectospringboot.Oficina.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Oficina.domain.entities.Oficina;

@Service
public interface OficinaService {
    List<Oficina> findAll();
    Optional<Oficina> findById(Long id);
    Oficina save(Oficina oficina);
    Optional<Oficina> update(Long id, Oficina oficina);
    Optional<Oficina> delete(Long id);
}
