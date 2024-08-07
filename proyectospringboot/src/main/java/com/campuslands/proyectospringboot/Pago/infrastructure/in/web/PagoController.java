package com.campuslands.proyectospringboot.Pago.infrastructure.in.web;

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

import com.campuslands.proyectospringboot.Pago.application.services.PagoService;
import com.campuslands.proyectospringboot.Pago.domain.entities.Pago;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        Optional<Pago> foundPago = pagoService.findById(id);
        if (!foundPago.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundPago.orElseThrow(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pago> createPago(@Valid @RequestBody Pago pago) {
        pagoService.save(pago);
        return new ResponseEntity<>(pago, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
        public ResponseEntity<String> updatePago(@PathVariable Long id, @Valid @RequestBody Pago pago) {
            Optional<Pago> foundPago = pagoService.findById(id);
            if (!foundPago.isPresent()){
                return new ResponseEntity<>("Pago no encontrado", HttpStatus.NOT_FOUND);
            }
            pago.setId(id);
            pagoService.update(id, pago);  
        return new ResponseEntity<>("Pago actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeletePago(@PathVariable Long id) {
        Optional<Pago> foundPago = pagoService.findById(id);
        if (!foundPago.isPresent()){
            return new ResponseEntity<>("Pago no encontrado", HttpStatus.NOT_FOUND);
        } 
        pagoService.delete(id);
        return new ResponseEntity<>("Pago eliminado correctamente", HttpStatus.OK);
    }
}
