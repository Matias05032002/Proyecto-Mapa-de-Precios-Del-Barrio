package com.tuapp.mapaprecios.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Comercio")
@Data
@NoArgsConstructor

public class Comercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String localidad;
    private String direccion;
    private String descripcion;
    private String tipo;
    private Boolean activo;
    private LocalDateTime fechaRegistro;

}


