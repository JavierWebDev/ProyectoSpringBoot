package com.campuslands.proyectospringboot.FormaPago.infrastructure.adapters.in;

import java.util.List;

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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/formaPago")
@AllArgsConstructor
public class FormaPagoController {
    private final FormaPagoService formaPagoService;

    @GetMapping
    public List<FormaPago> getAllFormaPagos() {
        return formaPagoService.findAll();
    }

    @GetMapping("/{id}")
    public FormaPago getFormaPagoById(@PathVariable Long id) {
        return formaPagoService.findById(id);
    }

    @PostMapping
    public FormaPago createFormaPago(@RequestBody FormaPago formaPago) {
        return formaPagoService.save(formaPago);
    }

    @PutMapping("/{id}")
    public FormaPago updateFormaPago(@PathVariable Long id, @RequestBody FormaPago formaPago) {
        formaPago.setId(id);
        return formaPagoService.save(formaPago);
    }

    @DeleteMapping("/{id}")
    public void deleteFormaPago(@PathVariable Long id) {
        formaPagoService.deleteById(id);
    }
}
