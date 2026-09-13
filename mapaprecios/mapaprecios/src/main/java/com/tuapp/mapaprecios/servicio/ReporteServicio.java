package com.tuapp.mapaprecios.servicio;


import com.tuapp.mapaprecios.modelo.Reporte;
import com.tuapp.mapaprecios.repositorio.ReporteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteServicio {
    @Autowired
    private ReporteRepositorio reporteRepositorio;

    public Reporte guardarReporteNuevo(Reporte reporte){
        return reporteRepositorio.save(reporte);
    }

    public Optional<Reporte> buscarReporte(Long id){
        return reporteRepositorio.findById(id);
    }

    public List<Reporte> buscarPorProducto(Long productoId){
        return reporteRepositorio.findByProductoId(productoId);
    }
    public Optional<Reporte> marcarDudoso(Long id){
        Optional<Reporte> reporte = reporteRepositorio.findById(id);
        if (reporte.isPresent()){
            reporte.get().setPuntuacion(reporte.get().getPuntuacion() + 1);
            reporteRepositorio.save(reporte.get());
        }
        return reporte;
    }



}
