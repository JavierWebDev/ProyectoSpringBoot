package com.campuslands.proyectospringboot.Barrio.infrastructure.in.web;

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

import com.campuslands.proyectospringboot.Barrio.application.BarrioService;
import com.campuslands.proyectospringboot.Barrio.domain.Barrio;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/barrio")
public class BarrioController {

    @Autowired
    BarrioService barrioService;

    @GetMapping
    public ResponseEntity<List<Barrio>> list() {
        List<Barrio> barrios = barrioService.list();
        return ResponseEntity.ok(barrios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barrio> listById(@PathVariable Long id) {
        Optional<Barrio> fBarrio = barrioService.findById(id);
        if (!fBarrio.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fBarrio.get(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@Valid @RequestBody Barrio barrio) {
        barrioService.create(barrio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBarrio(@PathVariable Long id, @Valid @RequestBody Barrio barrio) {
        Optional<Barrio> foundBarrio = barrioService.findById(id);
        if (!foundBarrio.isPresent()) {
            return new ResponseEntity<>("Barrio no encontrado", HttpStatus.NOT_FOUND);
        }
        barrio.setId(id);
        barrioService.create(barrio);
        return new ResponseEntity<>("Barrio ha sido guardado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarrio(@PathVariable Long id) {
        Optional<Barrio> foundBarrio = barrioService.findById(id);
        if (!foundBarrio.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        barrioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
