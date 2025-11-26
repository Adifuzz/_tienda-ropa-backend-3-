package com.tiendaropa.repository;

import com.tiendaropa.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Métodos personalizados
    
    // Buscar productos por categoría
    List<Producto> findByCategoria_IdCategoria(Integer idCategoria);
    
    // Buscar productos por nombre (contiene)
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    
    // Buscar productos con stock disponible
    List<Producto> findByStockGreaterThan(Integer stock);
}