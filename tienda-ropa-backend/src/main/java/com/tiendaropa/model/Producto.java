package com.tiendaropa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    @Column(name = "stock", nullable = false)
    private Integer stock;
    
    @Column(name = "talla", length = 10)
    private String talla;
    
    @Column(name = "color", length = 30)
    private String color;
    
    @Column(name = "imagen_url", length = 255)
    private String imagenUrl;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}