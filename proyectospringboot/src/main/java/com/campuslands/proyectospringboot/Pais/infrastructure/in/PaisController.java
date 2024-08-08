package com.campuslands.proyectospringboot.Pais.infrastructure.in;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectospringboot.Pais.application.PaisService;
import com.campuslands.proyectospringboot.Pais.domain.entities.Pais;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/pais")
@AllArgsConstructor
public class PaisController {
    
    private final PaisService paisService;

    @GetMapping
    public List<Pais> getAllPais() {
        return paisService.getAllPais();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
        Optional<Pais> foundPais = paisService.findById(id);
        if (!foundPais.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundPais.get(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Pais> createPais(@Valid @RequestBody Pais pais){
        paisService.save(pais);
        return new ResponseEntity<>(pais, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePais(@PathVariable Long id, @Valid @RequestBody Pais pais) {
        Optional<Pais> foundPais = paisService.findById(id);
        if (!foundPais.isPresent()) {
            return new ResponseEntity<>("Pais no encontrado", HttpStatus.NOT_FOUND);
        }
        pais.setId(id);
        paisService.save(pais);
        return new ResponseEntity<>("Pais ha sido guardado correctamente", HttpStatus.OK);
    }

}
