package com.campuslands.proyectospringboot.Stock.infrastructure.persistence.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Stock.domain.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    
}
