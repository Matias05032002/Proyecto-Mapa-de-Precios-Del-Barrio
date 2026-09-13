package com.tuapp.mapaprecios.controlador;


import com.tuapp.mapaprecios.modelo.Comercio;
import com.tuapp.mapaprecios.repositorio.ComercioRepositorio;
import com.tuapp.mapaprecios.servicio.ComercioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comercios")
public class ComercioControlador {

    @Autowired
    private ComercioServicio comercioServicio;

    @GetMapping
    public List<Comercio> seleccionarTodos(){
        return comercioServicio.listarTodos();
    }
    @PostMapping
    public Comercio guardarComercioNuevo(@RequestBody Comercio comercio){
        return comercioServicio.guardarComercioNuevo(comercio);
    }

}
