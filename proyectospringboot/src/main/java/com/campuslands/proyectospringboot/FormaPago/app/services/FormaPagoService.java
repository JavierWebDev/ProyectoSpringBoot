package com.campuslands.proyectospringboot.FormaPago.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.FormaPago.domain.entities.FormaPago;
import com.campuslands.proyectospringboot.FormaPago.infrastructure.adapters.out.FormaPagoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FormaPagoService {

    private final FormaPagoRepository formaPagoRepository;

    public List<FormaPago> findAll(){
        return formaPagoRepository.findAll();
    }

    public Optional<FormaPago> findById(Long id){
        return formaPagoRepository.findById(id);
    }

    public FormaPago save(FormaPago formaPago){
        return formaPagoRepository.save(formaPago);
    }

    public void deleteById(Long id) {
        formaPagoRepository.deleteById(id);
    }
}
