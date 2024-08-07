package com.campuslands.proyectospringboot.Oficina.infrastructure.in.web;

import java.util.List;
import java.util.Optional;

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

import com.campuslands.proyectospringboot.Oficina.application.services.OficinaService;
import com.campuslands.proyectospringboot.Oficina.domain.entities.Oficina;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/oficinas")
public class OficinaController {

    private final OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    @GetMapping
    public List<Oficina> getAllOficinas() {
        return oficinaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oficina> getOficinaById(@PathVariable Long id) {
        Optional<Oficina> foundOficina = oficinaService.findById(id);
        if (!foundOficina.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundOficina.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Oficina> createOficina(@Valid @RequestBody Oficina oficina) {
        oficinaService.save(oficina);
        return new ResponseEntity<>(oficina, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOficina(@PathVariable Long id, @Valid @RequestBody Oficina oficina) {
        Optional<Oficina> foundOficina = oficinaService.findById(id);
        if (!foundOficina.isPresent()){
            return new ResponseEntity<>("Oficina no encontrada", HttpStatus.NOT_FOUND);
        }
        oficina.setId(id);
        oficinaService.update(id, oficina);  
        return new ResponseEntity<>("Oficina actualizada correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteOficina(@PathVariable Long id) {
        Optional<Oficina> foundOficina = oficinaService.findById(id);
        if (!foundOficina.isPresent()){
            return new ResponseEntity<>("Oficina no encontrada", HttpStatus.NOT_FOUND);
        } 
        oficinaService.delete(id);
        return new ResponseEntity<>("Oficina eliminada correctamente", HttpStatus.OK);
    }
}
