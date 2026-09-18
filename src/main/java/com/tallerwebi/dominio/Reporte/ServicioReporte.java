package com.tallerwebi.dominio.Reporte;

import java.util.List;

public interface ServicioReporte {
  Reporte guardarReporte(Reporte reporte);
  Reporte buscarReporte(Long id);
  List<Reporte> buscarPorPorducto(Long productoId);
  Reporte marcarDudoso(Long id);
  List<Reporte> listarTodos();
}
