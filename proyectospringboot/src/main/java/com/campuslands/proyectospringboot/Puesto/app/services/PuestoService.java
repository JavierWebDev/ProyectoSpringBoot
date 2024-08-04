package com.campuslands.proyectospringboot.Puesto.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Puesto.domain.entities.Puesto;
import com.campuslands.proyectospringboot.Puesto.infrastructure.persistence.out.PuestoRepository;

@Service
public class PuestoService {

    private final PuestoRepository puestoRepository;

    public PuestoService(PuestoRepository puestoRepository) {
        this.puestoRepository = puestoRepository;
    }

    public List<Puesto> findAll(){
        return puestoRepository.findAll();
    }
    
    public Optional<Puesto> findById(Long id){
        return puestoRepository.findById(id);
    }

    public Puesto save(Puesto puesto){
        return puestoRepository.save(puesto);
    }



    public void deleteById(Long id){
        puestoRepository.deleteById(id);
    }
}
