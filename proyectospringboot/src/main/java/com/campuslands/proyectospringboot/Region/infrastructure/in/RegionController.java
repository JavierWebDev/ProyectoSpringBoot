package com.campuslands.proyectospringboot.Region.infrastructure.in;

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

import com.campuslands.proyectospringboot.Region.domain.entities.Region;
import com.campuslands.proyectospringboot.Region.app.services.RegionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/region")
public class RegionController {
    
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public List<Region> getAllRegiones() {
        return regionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Long id) {
        Optional<Region> foundRegion = regionService.findById(id);
        if (!foundRegion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundRegion.get(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Region> createRegion(@Valid @RequestBody Region region){
        regionService.save(region);
        return new ResponseEntity<>(region, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRegion(@PathVariable Long id, @Valid @RequestBody Region region) {
        Optional<Region> foundRegion = regionService.findById(id);
        if (!foundRegion.isPresent()) {
            return new ResponseEntity<>("Region no encontrada", HttpStatus.NOT_FOUND);
        }
        region.setId(id);
        regionService.save(region);
        return new ResponseEntity<>("Region ha sido guardada correctamente", HttpStatus.OK);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Region> updateRegion(@PathVariable Long id, @Valid @RequestBody Region Region) {
    //     Optional<Region> existingRegion = RegionService.findById(id);
    //     if (!existingRegion.isPresent()) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    //     Region.setId(id);
    //     RegionService.save(Region);
    //     return new ResponseEntity<>(Region, HttpStatus.ACCEPTED);
    // }
 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        Optional<Region> foundRegion = regionService.findById(id);
        if (!foundRegion.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        regionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
