package com.campuslands.proyectospringboot.Dimensiones.infrastructure.adapters.in;

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

import com.campuslands.proyectospringboot.Dimensiones.app.services.DimensionesService;
import com.campuslands.proyectospringboot.Dimensiones.domain.entities.Dimensiones;

import jakarta.validation.Valid;
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
    public ResponseEntity<Dimensiones> listById(@PathVariable Long id) {
        Optional<Dimensiones> fDimensiones = dimensionesService.findById(id);
        if (!fDimensiones.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fDimensiones.get(), HttpStatus.OK);
    }

    @PostMapping
    public Dimensiones createDimensiones(@RequestBody Dimensiones dimensiones) {
        return dimensionesService.save(dimensiones);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDimensiones(@PathVariable Long id, @Valid @RequestBody Dimensiones Dimensiones) {
        Optional<Dimensiones> foundDimensiones = dimensionesService.findById(id);
        if (!foundDimensiones.isPresent()) {
            return new ResponseEntity<>("Dimensiones no encontrado", HttpStatus.NOT_FOUND);
        }
        Dimensiones.setId(id);
        dimensionesService.save(Dimensiones);
        return new ResponseEntity<>("Dimensiones ha sido guardado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDimensiones(@PathVariable Long id) {
        Optional<Dimensiones> foundDimensiones = dimensionesService.findById(id);
        if (!foundDimensiones.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dimensionesService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
