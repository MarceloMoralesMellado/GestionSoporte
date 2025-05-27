package com.GestionSoporte.GestionSoporte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //anotaciones de lombok
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "soporte")
public class Soporte {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSoporte;

    /*atributos */

    @Column(length = 50, nullable = false)
    private String tituloSoporte;

    @Column(length = 200, nullable = false)
    private String descripcionSoporte;

    @Enumerated(EnumType.STRING)
    private EstadosTicket estadoTicket;

    @Enumerated(EnumType.STRING)
    private CategoriaTicket categoriaTicket;

    @Column(nullable = true)
    private int idUsuario;

    @Column(nullable = true) /*le elimino el lenght para evitar inconsistencias (como el largo del nombre) */
    private String usuarioAsignado;

    @Column(length = 50, nullable = false)
    private String creadoPor;

    



    

    
}
