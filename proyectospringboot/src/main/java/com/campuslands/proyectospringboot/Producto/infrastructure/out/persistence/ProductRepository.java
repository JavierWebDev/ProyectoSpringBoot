package com.campuslands.proyectospringboot.Producto.infrastructure.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campuslands.proyectospringboot.Producto.domain.entities.Producto;
import com.campuslands.proyectospringboot.Producto.domain.entities.ProductoGamaDTO;

public interface ProductRepository extends JpaRepository<Producto,Long>{

        @Query("select new com.campuslands.proyectospringboot.Producto.domain.entities.ProductoGamaDTO(p.id, p.nombre, p.precio, p.stock, gp.nombre)" +
                "from Producto p" +
                "join p.gamaProducto gp"+
                "where gp.nombre=?1")
        List<ProductoGamaDTO> productosPorGama (String nombreGama);
}
