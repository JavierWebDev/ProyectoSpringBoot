package com.campuslands.proyectospringboot.Fax.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Fax.domain.entities.Fax;
import com.campuslands.proyectospringboot.Fax.infrastructure.adapters.out.FaxRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FaxService {

    private final FaxRepository faxRepository;

    public List<Fax> findAll(){
        return faxRepository.findAll();
    }

    public Fax findById(Long id){
        return faxRepository.findById(id).orElse(null);
    }

    public Fax save(Fax fax){
        return faxRepository.save(fax);
    }

    public void deleteById(Long id) {
        faxRepository.deleteById(id);
    }
}
