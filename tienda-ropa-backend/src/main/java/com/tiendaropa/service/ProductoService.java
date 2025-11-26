package com.tiendaropa.service;

import com.tiendaropa.model.Producto;
import com.tiendaropa.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    // Obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }
    
    // Obtener un producto por ID
    public Optional<Producto> obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id);
    }
    
    // Guardar un nuevo producto o actualizar existente
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    
    // Eliminar un producto por ID
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
    
    // Buscar productos por categoría
    public List<Producto> obtenerProductosPorCategoria(Integer idCategoria) {
        return productoRepository.findByCategoria_IdCategoria(idCategoria);
    }
    
    // Buscar productos por nombre
    public List<Producto> buscarProductosPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    // Obtener productos con stock disponible
    public List<Producto> obtenerProductosConStock() {
        return productoRepository.findByStockGreaterThan(0);
    }
}