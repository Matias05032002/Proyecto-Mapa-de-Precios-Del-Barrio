package com.tuapp.mapaprecios.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Productos")
@Data
@NoArgsConstructor

public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String categoria;
    private String unidad;

}
