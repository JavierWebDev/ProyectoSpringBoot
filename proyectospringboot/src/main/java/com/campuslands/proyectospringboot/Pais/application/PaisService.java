package com.campuslands.proyectospringboot.Pais.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.proyectospringboot.Pais.domain.entities.Pais;
import com.campuslands.proyectospringboot.Pais.infrastructure.out.PaisRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaisService {
    private final PaisRepository paisRepository;

    public List<Pais> getAllPais() {
        return paisRepository.findAll();
    }

        public Optional<Pais> findById(Long id){
        return  paisRepository.findById(id);
    }

    public Pais save(Pais pais){
        return paisRepository.save(pais);
    }

    public void deleteById(Long id){
        paisRepository.deleteById(id);
    }
}
