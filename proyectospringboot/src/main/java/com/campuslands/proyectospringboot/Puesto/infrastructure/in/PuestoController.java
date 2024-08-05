package com.campuslands.proyectospringboot.Puesto.infrastructure.in;

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

import com.campuslands.proyectospringboot.Puesto.domain.entities.Puesto;
import com.campuslands.proyectospringboot.Puesto.app.services.PuestoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/puesto")
public class PuestoController {

    private final PuestoService puestoService;

    public PuestoController(PuestoService puestoService) {
        this.puestoService = puestoService;
    }

    @GetMapping
    public List<Puesto> getAllPuestos() {
        return puestoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Puesto> getPuestoById(@PathVariable Long id) {
        Optional<Puesto> foundPuesto = puestoService.findById(id);
        if (!foundPuesto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundPuesto.get(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Puesto> createPuesto(@Valid @RequestBody Puesto puesto){
        puestoService.save(puesto);
        return new ResponseEntity<>(puesto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePuesto(@PathVariable Long id, @Valid @RequestBody Puesto puesto) {
        Optional<Puesto> foundPuesto = puestoService.findById(id);
        if (!foundPuesto.isPresent()) {
            return new ResponseEntity<>("Puesto no encontrado", HttpStatus.NOT_FOUND);
        }
        puesto.setId(id);
        puestoService.save(puesto);
        return new ResponseEntity<>("Puesto ha sido guardado correctamente", HttpStatus.OK);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Puesto> updatePuesto(@PathVariable Long id, @Valid @RequestBody Puesto Puesto) {
    //     Optional<Puesto> existingPuesto = PuestoService.findById(id);
    //     if (!existingPuesto.isPresent()) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    //     Puesto.setId(id);
    //     PuestoService.save(Puesto);
    //     return new ResponseEntity<>(Puesto, HttpStatus.ACCEPTED);
    // }
 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePuesto(@PathVariable Long id) {
        Optional<Puesto> foundPuesto = puestoService.findById(id);
        if (!foundPuesto.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        puestoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
