package com.tallerwebi.dominio.Reporte;

import java.util.List;
import java.util.Optional;

public interface RepositorioReporte {
  Reporte guardarReporte(Reporte reporte);
  Reporte buscarReporte(Long id);
  List<Reporte> buscarPorPorducto(Long productoId);
  Reporte marcarDudoso(Long id);
  List<Reporte> listarTodos();
}
