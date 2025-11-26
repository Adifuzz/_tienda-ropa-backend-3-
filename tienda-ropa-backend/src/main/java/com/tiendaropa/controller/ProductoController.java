package com.tiendaropa.controller;

import com.tiendaropa.model.Producto;
import com.tiendaropa.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    // GET: Obtener todos los productos
    // URL: http://localhost:8080/api/productos
    @GetMapping
    public List<Producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }
    
    // GET: Obtener un producto por ID
    // URL: http://localhost:8080/api/productos/1
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Integer id) {
        return productoService.obtenerProductoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // GET: Obtener productos por categoría
    // URL: http://localhost:8080/api/productos/categoria/1
    @GetMapping("/categoria/{idCategoria}")
    public List<Producto> obtenerProductosPorCategoria(@PathVariable Integer idCategoria) {
        return productoService.obtenerProductosPorCategoria(idCategoria);
    }
    
    // GET: Buscar productos por nombre
    // URL: http://localhost:8080/api/productos/buscar?nombre=camiseta
    @GetMapping("/buscar")
    public List<Producto> buscarProductos(@RequestParam String nombre) {
        return productoService.buscarProductosPorNombre(nombre);
    }
    
    // GET: Obtener productos con stock disponible
    // URL: http://localhost:8080/api/productos/disponibles
    @GetMapping("/disponibles")
    public List<Producto> obtenerProductosDisponibles() {
        return productoService.obtenerProductosConStock();
    }
    
    // POST: Crear un nuevo producto
    // URL: http://localhost:8080/api/productos
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }
    
    // PUT: Actualizar un producto existente
    // URL: http://localhost:8080/api/productos/1
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoService.obtenerProductoPorId(id)
                .map(productoExistente -> {
                    producto.setIdProducto(id);
                    return ResponseEntity.ok(productoService.guardarProducto(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // DELETE: Eliminar un producto
    // URL: http://localhost:8080/api/productos/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}