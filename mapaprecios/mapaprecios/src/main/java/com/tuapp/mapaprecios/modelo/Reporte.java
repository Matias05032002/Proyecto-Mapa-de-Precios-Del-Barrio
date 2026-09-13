package com.tuapp.mapaprecios.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "Reporte")
@Data
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaDeReporte;
    private Integer puntuacion;
    private Double precio;
    private Boolean vigente;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Comercio comercio;
    @ManyToOne
    private Producto producto;


}
