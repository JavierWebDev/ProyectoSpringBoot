package com.campuslands.proyectospringboot.Contacto.infrastructure.adapters.in;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectospringboot.Contacto.application.ContactoService;
import com.campuslands.proyectospringboot.Contacto.domain.Contacto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contacto")
public class ContactoController {
    @Autowired
    ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    public ResponseEntity<List<Contacto>> list() {
        List<Contacto> contactos = contactoService.list();
        return ResponseEntity.ok(contactos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacto> listById(@PathVariable Long id) {
        Optional<Contacto> fContacto = contactoService.findById(id);
        if (!fContacto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fContacto.get(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody Contacto contacto) {
        contactoService.create(contacto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContacto(@PathVariable Long id, @Valid @RequestBody Contacto Contacto) {
        Optional<Contacto> foundContacto = contactoService.findById(id);
        if (!foundContacto.isPresent()) {
            return new ResponseEntity<>("Contacto no encontrado", HttpStatus.NOT_FOUND);
        }
        Contacto.setId(id);
        contactoService.create(Contacto);
        return new ResponseEntity<>("Contacto ha sido guardado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContacto(@PathVariable Long id) {
        Optional<Contacto> foundContacto = contactoService.findById(id);
        if (!foundContacto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contactoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
