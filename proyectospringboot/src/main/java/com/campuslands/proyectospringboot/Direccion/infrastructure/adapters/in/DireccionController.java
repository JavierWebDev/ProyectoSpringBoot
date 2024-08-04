package com.campuslands.proyectospringboot.Direccion.infrastructure.adapters.in;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectospringboot.Direccion.app.services.DireccionService;
import com.campuslands.proyectospringboot.Direccion.domain.entities.Direccion;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/direccion")
@AllArgsConstructor
public class DireccionController {
    
    private final DireccionService direccionService;

    @GetMapping
    public List<Direccion> getAllDireccions() {
        return direccionService.findAll();
    }

    @GetMapping("/{id}")
    public Direccion getDireccionById(@PathVariable Long id) {
        return direccionService.findById(id);
    }

    @PostMapping
    public Direccion createDireccion(@RequestBody Direccion direccion) {
        return direccionService.save(direccion);
    }

    @PutMapping("/{id}")
    public Direccion updateDireccion(@PathVariable Long id, @RequestBody Direccion direccion) {
        direccion.setId(id);
        return direccionService.save(direccion);
    }

    @DeleteMapping("/{id}")
    public void deleteDireccion(@PathVariable Long id) {
        direccionService.deleteById(id);
    }
}
