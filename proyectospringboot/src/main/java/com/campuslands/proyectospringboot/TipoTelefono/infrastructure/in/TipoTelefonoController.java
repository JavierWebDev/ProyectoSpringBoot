package com.campuslands.proyectospringboot.TipoTelefono.infrastructure.in;

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

import com.campuslands.proyectospringboot.TipoTelefono.domain.entities.TipoTelefono;
import com.campuslands.proyectospringboot.TipoTelefono.app.service.TipoTelefonoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipotelefono")
public class TipoTelefonoController {
    
    private final TipoTelefonoService tipoTelefonoService;

    public TipoTelefonoController(TipoTelefonoService tipoTelefonoService) {
        this.tipoTelefonoService = tipoTelefonoService;
    }

    @GetMapping
    public List<TipoTelefono> getAllTipoTelefono() {
        return tipoTelefonoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTelefono> getTipoTelefonoById(@PathVariable Long id) {
        Optional<TipoTelefono> foundTipoTelefono = tipoTelefonoService.findById(id);
        if (!foundTipoTelefono.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundTipoTelefono.get(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<TipoTelefono> createTipoTelefono(@Valid @RequestBody TipoTelefono tipoTelefono){
        tipoTelefonoService.save(tipoTelefono);
        return new ResponseEntity<>(tipoTelefono, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTipoTelefono(@PathVariable Long id, @Valid @RequestBody TipoTelefono tipoTelefono) {
        Optional<TipoTelefono> foundTipoTelefono = tipoTelefonoService.findById(id);
        if (!foundTipoTelefono.isPresent()) {
            return new ResponseEntity<>("Tipo de Telefono no encontrado", HttpStatus.NOT_FOUND);
        }
        tipoTelefono.setId(id);
        tipoTelefonoService.save(tipoTelefono);
        return new ResponseEntity<>("Tipo de Telefono ha sido guardado correctamente", HttpStatus.OK);
    }

 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoTelefono(@PathVariable Long id) {
        Optional<TipoTelefono> foundTipoTelefono = tipoTelefonoService.findById(id);
        if (!foundTipoTelefono.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tipoTelefonoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
