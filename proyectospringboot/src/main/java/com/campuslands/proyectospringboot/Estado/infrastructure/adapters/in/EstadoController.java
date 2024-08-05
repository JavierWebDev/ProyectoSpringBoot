package com.campuslands.proyectospringboot.Estado.infrastructure.adapters.in;

import java.util.List;

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
    public Estado getEstadoById(@PathVariable Long id) {
        return estadoService.findById(id);
    }

    @PostMapping
    public Estado createEstado(@Valid @RequestBody Estado estado) {
        return estadoService.save(estado);
    }

    @PutMapping("/{id}")
    public Estado updateEstado(@PathVariable Long id, @Valid @RequestBody Estado estado) {
        estado.setId(id);
        return estadoService.save(estado);
    }

    @DeleteMapping("/{id}")
    public void deleteEstado(@PathVariable Long id) {
        estadoService.deleteById(id);
    }
}

