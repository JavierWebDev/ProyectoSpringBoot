package com.campuslands.proyectospringboot.Ciudad.infrastructure.adapters.in;

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

import com.campuslands.proyectospringboot.Ciudad.application.CiudadService;
import com.campuslands.proyectospringboot.Ciudad.domain.Ciudad;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    @Autowired
    CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping
    public ResponseEntity<List<Ciudad>> list() {
        List<Ciudad> ciudades = ciudadService.list();
        return ResponseEntity.ok(ciudades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> listById(@PathVariable Long id) {
        Optional<Ciudad> fCiudad = ciudadService.findById(id);
        if (!fCiudad.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fCiudad.get(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@Valid @RequestBody Ciudad ciudad) {
        ciudadService.create(ciudad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCiudad(@PathVariable Long id, @Valid @RequestBody Ciudad ciudad) {
        Optional<Ciudad> foundCiudad = ciudadService.findById(id);
        if (!foundCiudad.isPresent()) {
            return new ResponseEntity<>("Ciudad no encontrada", HttpStatus.NOT_FOUND);
        }
        ciudad.setId(id);
        ciudadService.create(ciudad);
        return new ResponseEntity<>("Ciudad ha sido guardada correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiudad(@PathVariable Long id) {
        Optional<Ciudad> foundCiudad = ciudadService.findById(id);
        if (!foundCiudad.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ciudadService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
