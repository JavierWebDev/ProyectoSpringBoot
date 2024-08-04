package com.campuslands.proyectospringboot.Contacto.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.proyectospringboot.Contacto.domain.Contacto;
import com.campuslands.proyectospringboot.Contacto.infrastructure.adapters.out.ContactoRepository;

public class ContactoService {
    private final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public List<Contacto> list() {
        return contactoRepository.findAll();
    }

    public Optional<Contacto> findById(Long id) {
        return contactoRepository.findById(id);
    }

    public void create(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    public void deleteById(Long id) {
        contactoRepository.deleteById(id);
    }
}
