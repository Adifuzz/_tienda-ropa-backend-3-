package com.tiendaropa.service;

import com.tiendaropa.model.Categoria;
import com.tiendaropa.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    // Obtener todas las categorías
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }
    
    // Obtener una categoría por ID
    public Optional<Categoria> obtenerCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id);
    }
    
    // Guardar una nueva categoría o actualizar existente
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    // Eliminar una categoría por ID
    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}