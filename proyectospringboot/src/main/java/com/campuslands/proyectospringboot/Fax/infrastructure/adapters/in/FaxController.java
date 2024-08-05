package com.campuslands.proyectospringboot.Fax.infrastructure.adapters.in;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectospringboot.Fax.app.services.FaxService;
import com.campuslands.proyectospringboot.Fax.domain.entities.Fax;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/fax")
@AllArgsConstructor
public class FaxController {
    private final FaxService faxService;

    @GetMapping
    public List<Fax> getAllFaxs() {
        return faxService.findAll();
    }

    @GetMapping("/{id}")
    public Fax getFaxById(@PathVariable Long id) {
        return faxService.findById(id);
    }

    @PostMapping
    public Fax createFax(@Valid @RequestBody Fax Fax) {
        return faxService.save(Fax);
    }

    @PutMapping("/{id}")
    public Fax updateFax(@PathVariable Long id, @Valid @RequestBody Fax fax) {
        fax.setId(id);
        return faxService.save(fax);
    }

    @DeleteMapping("/{id}")
    public void deleteFax(@PathVariable Long id) {
        faxService.deleteById(id);
    }
}
