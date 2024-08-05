package com.campuslands.proyectospringboot.Stock.infrastructure.in;

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

import com.campuslands.proyectospringboot.Stock.domain.entities.Stock;
import com.campuslands.proyectospringboot.Stock.app.service.StockService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/stock")
public class StockController {
    
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getAllStock() {
        return stockService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Optional<Stock> foundStock = stockService.findById(id);
        if (!foundStock.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundStock.get(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Stock> createStock(@Valid @RequestBody Stock stock){
        stockService.save(stock);
        return new ResponseEntity<>(stock, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStock(@PathVariable Long id, @Valid @RequestBody Stock stock) {
        Optional<Stock> foundStock = stockService.findById(id);
        if (!foundStock.isPresent()) {
            return new ResponseEntity<>("Stock no encontrada", HttpStatus.NOT_FOUND);
        }
        stock.setId(id);
        stockService.save(stock);
        return new ResponseEntity<>("Stock ha sido guardada correctamente", HttpStatus.OK);
    }

 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        Optional<Stock> foundStock = stockService.findById(id);
        if (!foundStock.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        stockService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
