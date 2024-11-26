package com.letseat.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurante")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante")
    private long idRestaurante;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String rutaImagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Restaurante() {
    }

    public Restaurante(String nombre, String descripcion, String direccion, String rutaImagen, boolean activo, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        this.categoria = categoria;
    }

    
}
