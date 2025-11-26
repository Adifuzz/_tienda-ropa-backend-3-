package com.tiendaropa.controller;

import com.tiendaropa.model.Categoria;
import com.tiendaropa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    // GET: Obtener todas las categorías
    // URL: http://localhost:8080/api/categorias
    @GetMapping
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaService.obtenerTodasLasCategorias();
    }
    
    // GET: Obtener una categoría por ID
    // URL: http://localhost:8080/api/categorias/1
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Integer id) {
        return categoriaService.obtenerCategoriaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // POST: Crear una nueva categoría
    // URL: http://localhost:8080/api/categorias
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }
    
    // PUT: Actualizar una categoría existente
    // URL: http://localhost:8080/api/categorias/1
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        return categoriaService.obtenerCategoriaPorId(id)
                .map(categoriaExistente -> {
                    categoria.setIdCategoria(id);
                    return ResponseEntity.ok(categoriaService.guardarCategoria(categoria));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    // DELETE: Eliminar una categoría
    // URL: http://localhost:8080/api/categorias/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}