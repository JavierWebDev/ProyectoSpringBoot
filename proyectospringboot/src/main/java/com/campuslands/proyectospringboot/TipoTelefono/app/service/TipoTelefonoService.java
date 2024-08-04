package com.campuslands.proyectospringboot.TipoTelefono.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.TipoTelefono.domain.entities.TipoTelefono;
import com.campuslands.proyectospringboot.TipoTelefono.infrastructure.persistence.out.TipoTelefonoRepository;

@Service
public class TipoTelefonoService {
    
    private final TipoTelefonoRepository tipoTelefonoRepository;

    public TipoTelefonoService(TipoTelefonoRepository tipoTelefonoRepository) {
        this.tipoTelefonoRepository = tipoTelefonoRepository;
    }

    public List<TipoTelefono> findAll(){
        return tipoTelefonoRepository.findAll();  
    } 
    
    public Optional<TipoTelefono> findById(Long id){
        return  tipoTelefonoRepository.findById(id);
    }

    public TipoTelefono save(TipoTelefono tipoTelefono){
        return tipoTelefonoRepository.save(tipoTelefono);
    }

    public void deleteById(Long id){
        tipoTelefonoRepository.deleteById(id);
    }
    
}
