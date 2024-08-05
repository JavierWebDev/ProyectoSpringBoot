package com.campuslands.proyectospringboot.Telefono.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Telefono.domain.entitie.Telefono;
import com.campuslands.proyectospringboot.Telefono.infrastructure.persistence.out.TelefonoRepository;

@Service
public class TelefonoService {
    
    private final TelefonoRepository telefonoRepository;

    public TelefonoService(TelefonoRepository telefonoRepository) {
        this.telefonoRepository = telefonoRepository;
    }

    public List<Telefono> findAll(){
        return telefonoRepository.findAll();  
    } 
    
    public Optional<Telefono> findById(Long id){
        return  telefonoRepository.findById(id);
    }

    public Telefono save(Telefono telefono){
        return telefonoRepository.save(telefono);
    }

    public void deleteById(Long id){
        telefonoRepository.deleteById(id);
    }
}
