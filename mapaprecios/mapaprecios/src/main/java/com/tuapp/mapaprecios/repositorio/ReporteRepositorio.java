package com.tuapp.mapaprecios.repositorio;

import com.tuapp.mapaprecios.modelo.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReporteRepositorio extends JpaRepository<Reporte, Long> {
    List<Reporte> findByProductoId(Long productoId);
}
