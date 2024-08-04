package com.campuslands.proyectospringboot.Barrio.infrastructure.in.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectospringboot.Barrio.application.BarrioService;
import com.campuslands.proyectospringboot.Barrio.domain.Barrio;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/barrio")
public class BarrioController {

    @Autowired
    BarrioService barrioService;

    @GetMapping
    public ResponseEntity<List<Barrio>> list() {
        List<Barrio> barrios = barrioService.list();
        return ResponseEntity.ok(barrios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barrio> listById(@PathVariable Long id) {
        Optional<Barrio> fBarrio = barrioService.findById(id);
        if (!fBarrio.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fBarrio.get(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody Barrio barrio) {
        barrioService.create(barrio);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Barrio barrio) {
        barrio.setId(id);
        barrioService.create(barrio);
    }

}
