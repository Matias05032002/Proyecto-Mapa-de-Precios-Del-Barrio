package com.tuapp.mapaprecios.servicio;


import com.tuapp.mapaprecios.modelo.Comercio;
import com.tuapp.mapaprecios.repositorio.ComercioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercioServicio {

    @Autowired
    private ComercioRepositorio comercioRepositorio;

    public Comercio guardarComercioNuevo(Comercio comercio){

        return comercioRepositorio.save(comercio);
    }

    public List<Comercio> listarTodos(){
        return comercioRepositorio.findAll();
    }
}
