package com.campuslands.proyectospringboot.Dimensiones.infrastructure.adapters.in;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectospringboot.Dimensiones.app.services.DimensionesService;
import com.campuslands.proyectospringboot.Dimensiones.domain.entities.Dimensiones;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/dimensiones")
@AllArgsConstructor
public class DimensionesController {
    private final DimensionesService dimensionesService;

    @GetMapping
    public List<Dimensiones> getAllDimensioness() {
        return dimensionesService.findAll();
    }

    @GetMapping("/{id}")
    public Dimensiones getDimensionesById(@PathVariable Long id) {
        return dimensionesService.findById(id);
    }

    @PostMapping
    public Dimensiones createDimensiones(@RequestBody Dimensiones dimensiones) {
        return dimensionesService.save(dimensiones);
    }

    @PutMapping("/{id}")
    public Dimensiones updateDimensiones(@PathVariable Long id, @RequestBody Dimensiones dimensiones) {
        dimensiones.setId(id);
        return dimensionesService.save(dimensiones);
    }

    @DeleteMapping("/{id}")
    public void deleteDimensiones(@PathVariable Long id) {
        dimensionesService.deleteById(id);
    }
}
