package com.tuapp.mapaprecios.servicio;

import com.tuapp.mapaprecios.modelo.Producto;
import com.tuapp.mapaprecios.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    public Producto guardarProducto(Producto producto){

        return productoRepositorio.save(producto);
    }

    public List<Producto> listarTodos(){
        return productoRepositorio.findAll();
    }
}
