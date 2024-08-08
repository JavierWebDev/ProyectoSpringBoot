package com.campuslands.proyectospringboot.CodigoPostal.infrastructure.adapters.in;

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

import com.campuslands.proyectospringboot.CodigoPostal.application.CodigoPostalService;
import com.campuslands.proyectospringboot.CodigoPostal.domain.CodigoPostal;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/codigopostal")
public class CodigoPostalController {
    @Autowired
    CodigoPostalService codigoPostalService;

    public CodigoPostalController(CodigoPostalService codigoPostalService) {
        this.codigoPostalService = codigoPostalService;
    }

    @GetMapping
    public ResponseEntity<List<CodigoPostal>> list() {
        List<CodigoPostal> codigoPostales = codigoPostalService.list();
        return ResponseEntity.ok(codigoPostales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CodigoPostal> listById(@PathVariable Long id) {
        Optional<CodigoPostal> fCodigoPostal = codigoPostalService.findById(id);
        if (!fCodigoPostal.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fCodigoPostal.get(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@Valid @RequestBody CodigoPostal codigoPostal) {
        codigoPostalService.create(codigoPostal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCodigoPostal(@PathVariable Long id, @Valid @RequestBody CodigoPostal CodigoPostal) {
        Optional<CodigoPostal> foundCodigoPostal = codigoPostalService.findById(id);
        if (!foundCodigoPostal.isPresent()) {
            return new ResponseEntity<>("CodigoPostal no encontrado", HttpStatus.NOT_FOUND);
        }
        CodigoPostal.setId(id);
        codigoPostalService.create(CodigoPostal);
        return new ResponseEntity<>("CodigoPostal ha sido guardado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCodigoPostal(@PathVariable Long id) {
        Optional<CodigoPostal> foundCodigoPostal = codigoPostalService.findById(id);
        if (!foundCodigoPostal.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        codigoPostalService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
