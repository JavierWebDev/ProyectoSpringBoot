package com.campuslands.proyectospringboot.Direccion.infrastructure.adapters.in;

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

import com.campuslands.proyectospringboot.Direccion.app.services.DireccionService;
import com.campuslands.proyectospringboot.Direccion.domain.entities.Direccion;

import jakarta.validation.Valid;
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
    public ResponseEntity<Direccion> listById(@PathVariable Long id) {
        Optional<Direccion> fDireccion = direccionService.findById(id);
        if (!fDireccion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fDireccion.get(), HttpStatus.OK);
    }

    @PostMapping
    public Direccion createDireccion(@Valid @RequestBody Direccion direccion) {
        return direccionService.save(direccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDireccion(@PathVariable Long id, @Valid @RequestBody Direccion Direccion) {
        Optional<Direccion> foundDireccion = direccionService.findById(id);
        if (!foundDireccion.isPresent()) {
            return new ResponseEntity<>("Direccion no encontrado", HttpStatus.NOT_FOUND);
        }
        Direccion.setId(id);
        direccionService.save(Direccion);
        return new ResponseEntity<>("Direccion ha sido guardado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDireccion(@PathVariable Long id) {
        Optional<Direccion> foundDireccion = direccionService.findById(id);
        if (!foundDireccion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        direccionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
