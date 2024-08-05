package com.campuslands.proyectospringboot.Oficina.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.proyectospringboot.Oficina.domain.entities.Oficina;
import com.campuslands.proyectospringboot.Oficina.infrastructure.out.persistence.OficinaRepository;

@Component
public class OficinaImpl implements OficinaService{

    @Autowired
    private OficinaRepository repository;

    @Transactional
    @Override
    public List<Oficina> findAll() {
        return (List<Oficina>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Oficina> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Oficina save(Oficina oficina) {
        return repository.save(oficina);
    }

    @Transactional
    @Override
    public Optional<Oficina> delete(Long id) {
        Optional<Oficina> oficinaOpt = repository.findById(id);
        oficinaOpt.ifPresent(oI -> {
            repository.delete(oI);
        });
        return oficinaOpt;
    }

    @Transactional
    @Override
    public Optional<Oficina> update(Long id, Oficina oficina) {
        Optional<Oficina> oficinaOpt = repository.findById(id);
        if (oficinaOpt.isPresent()) {
            Oficina oficinaItem = oficinaOpt.orElseThrow();
            oficinaItem.setTelefono(oficina.getTelefono());
            oficinaItem.setCiudad(oficina.getCiudad());
            oficinaItem.setPais(oficina.getPais());
            oficinaItem.setCodigoPostal(oficina.getCodigoPostal());
            oficinaItem.setDireccion(oficina.getDireccion());
            return Optional.of(repository.save(oficinaItem));
        }
        return oficinaOpt;
    }
}
