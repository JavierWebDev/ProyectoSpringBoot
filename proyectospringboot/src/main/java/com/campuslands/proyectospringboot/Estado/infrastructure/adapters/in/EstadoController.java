package com.campuslands.proyectospringboot.Estado.infrastructure.adapters.in;

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

import com.campuslands.proyectospringboot.Estado.app.services.EstadoService;
import com.campuslands.proyectospringboot.Estado.domain.entities.Estado;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/estado")
@AllArgsConstructor
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping
    public List<Estado> getAllEstados() {
        return estadoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Long id) {
        Optional<Estado> foundEstado = estadoService.findById(id);
        if (!foundEstado.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundEstado.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estado> createEstado(@Valid @RequestBody Estado estado) {
        estadoService.save(estado);
        return new ResponseEntity<>(estado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEstado(@PathVariable Long id, @Valid @RequestBody Estado estado) {
        Optional<Estado> foundEstado = estadoService.findById(id);
        if (!foundEstado.isPresent()) {
            return new ResponseEntity<>("Estado no encontrado", HttpStatus.NOT_FOUND);
        }
        estado.setId(id);
        estadoService.save(estado);
        return new ResponseEntity<>("Estado actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEstado(@PathVariable Long id) {
        Optional<Estado> foundEstado = estadoService.findById(id);
        if (!foundEstado.isPresent()) {
            return new ResponseEntity<>("Estado no encontrado", HttpStatus.NOT_FOUND);
        }
        estadoService.deleteById(id);
        return new ResponseEntity<>("Estado eliminado correctamente", HttpStatus.OK);
    }
}

