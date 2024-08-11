package com.campuslands.proyectospringboot.Producto.infrastructure.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.campuslands.proyectospringboot.Producto.domain.entities.BajoStockDTO;
import com.campuslands.proyectospringboot.Producto.domain.entities.Producto;
import com.campuslands.proyectospringboot.Producto.domain.entities.ProductoGamaDTO;

@Repository
public interface ProductRepository extends JpaRepository<Producto,Long>{

    @Query("select new com.campuslands.proyectospringboot.Producto.domain.entities.ProductoGamaDTO(p.id, p.nombreProducto, gp.nombre)" +
            "from Producto p " +
            "join p.gamaProducto gp " +
            "where gp.nombre=?1")
    List<ProductoGamaDTO> productosPorGama (String nombreGama);

        @Query("select new com.campuslands.proyectospringboot.Producto.domain.entities.BajoStockDTO(p.id, p.nombreProducto, sp.stock)" +
                "from Producto p " +
                "join p.stockProducto sp "+
                "where sp.stock<?1")
        List<BajoStockDTO> productosConBajoStock (Integer stockLimite);
}
