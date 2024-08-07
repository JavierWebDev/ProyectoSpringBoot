package com.campuslands.proyectospringboot.FormaPago.infrastructure.adapters.in;

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

import com.campuslands.proyectospringboot.FormaPago.app.services.FormaPagoService;
import com.campuslands.proyectospringboot.FormaPago.domain.entities.FormaPago;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/formaPago")
@AllArgsConstructor
public class FormaPagoController {

    private final FormaPagoService formaPagoService;

    @GetMapping
    public List<FormaPago> getAllFormasPago() {
        return formaPagoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPago> getFormaPagoById(@PathVariable Long id) {
        Optional<FormaPago> foundFormaPago = formaPagoService.findById(id);
        if (!foundFormaPago.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundFormaPago.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FormaPago> createFormaPago(@Valid @RequestBody FormaPago formaPago) {
        formaPagoService.save(formaPago);
        return new ResponseEntity<>(formaPago, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFormaPago(@PathVariable Long id, @Valid @RequestBody FormaPago formaPago) {
        Optional<FormaPago> foundFormaPago = formaPagoService.findById(id);
        if (!foundFormaPago.isPresent()) {
            return new ResponseEntity<>("FormaPago no encontrado", HttpStatus.NOT_FOUND);
        }
        formaPago.setId(id);
        formaPagoService.save(formaPago);
        return new ResponseEntity<>("FormaPago actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFormaPago(@PathVariable Long id) {
        Optional<FormaPago> foundFormaPago = formaPagoService.findById(id);
        if (!foundFormaPago.isPresent()) {
            return new ResponseEntity<>("FormaPago no encontrado", HttpStatus.NOT_FOUND);
        }
        formaPagoService.deleteById(id);
        return new ResponseEntity<>("FormaPago eliminado correctamente", HttpStatus.OK);
    }
}
