
package com.letseat.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "reseña")
public class Reseña  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reseña")
    private long idReseña;
    private String comentario;
    private int valoracion;
    
    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Reseña() {
    }

    public Reseña( String comentario, int valoracion, Restaurante restaurante, Usuario usuario) {
        this.comentario = comentario;
        this.valoracion = valoracion;
        this.restaurante = restaurante;
        this.usuario = usuario;
    }
    
    
    }