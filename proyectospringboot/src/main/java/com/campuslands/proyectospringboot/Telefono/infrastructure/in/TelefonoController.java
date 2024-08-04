package com.campuslands.proyectospringboot.Telefono.infrastructure.in;

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

import com.campuslands.proyectospringboot.Telefono.app.service.TelefonoService;
import com.campuslands.proyectospringboot.Telefono.domain.entitie.Telefono;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/telefono")
public class TelefonoController {
    
    private final TelefonoService telefonoService;

    public TelefonoController(TelefonoService telefonoService) {
        this.telefonoService = telefonoService;
    }

    @GetMapping
    public List<Telefono> getAllTelefono() {
        return telefonoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telefono> getTelefonoById(@PathVariable Long id) {
        Optional<Telefono> foundTelefono = telefonoService.findById(id);
        if (!foundTelefono.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundTelefono.get(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Telefono> createTelefono(@Valid @RequestBody Telefono telefono){
        telefonoService.save(telefono);
        return new ResponseEntity<>(telefono, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelefono(@PathVariable Long id, @Valid @RequestBody Telefono telefono) {
        Optional<Telefono> foundTelefono = telefonoService.findById(id);
        if (!foundTelefono.isPresent()) {
            return new ResponseEntity<>("Tipo de Telefono no encontrado", HttpStatus.NOT_FOUND);
        }
        telefono.setId(id);
        telefonoService.save(telefono);
        return new ResponseEntity<>("Tipo de Telefono ha sido guardado correctamente", HttpStatus.OK);
    }

 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelefono(@PathVariable Long id) {
        Optional<Telefono> foundTelefono = telefonoService.findById(id);
        if (!foundTelefono.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        telefonoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
