package com.campuslands.proyectospringboot.Barrio.infrastructure.adapters.in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.proyectospringboot.Barrio.domain.entities.Barrio;
import com.campuslands.proyectospringboot.Barrio.app.services.BarrioService;

@RestController
@RequestMapping("/barrio")
public class BarrioController {

    @Autowired
    BarrioService barrioService;

    @GetMapping
    public List<Barrio> list() {
        return barrioService.list();
    }

    @PostMapping
    public void create(@RequestBody Barrio barrio) {
        barrioService.create(barrio);
    }

}
