package com.tuapp.mapaprecios.controlador;

import com.tuapp.mapaprecios.modelo.Producto;
import com.tuapp.mapaprecios.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;


    @GetMapping
    public List<Producto> seleccionarTodos(){
        return productoServicio.listarTodos();
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto){
        return productoServicio.guardarProducto(producto);
    }

}
