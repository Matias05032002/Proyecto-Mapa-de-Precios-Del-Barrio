package com.tuapp.mapaprecios.controlador;


import com.tuapp.mapaprecios.modelo.Reporte;
import com.tuapp.mapaprecios.servicio.ReporteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reportes")

public class ReporteControlador {

    @Autowired
    private ReporteServicio reporteServicio;

    @GetMapping("/{id}")
    public Optional<Reporte> buscarPorId (@PathVariable Long id){
        return reporteServicio.buscarReporte(id);
    }
    @GetMapping("/productos/{productoId}")
    public List<Reporte> buscarPorProducto(@PathVariable Long productoId){
        return reporteServicio.buscarPorProducto(productoId);
    }
    @PostMapping
    public Reporte guardarReporteNuevo (@RequestBody Reporte reporte){
        return reporteServicio.guardarReporteNuevo(reporte);
    }

    @PutMapping("/{id}/dudoso")
    public Optional<Reporte> marcarReporteDudoso(@PathVariable Long id){
        return reporteServicio.marcarDudoso(id);
    }

}
