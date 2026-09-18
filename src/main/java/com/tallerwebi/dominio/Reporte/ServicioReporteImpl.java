package com.tallerwebi.dominio.Reporte;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioReporte")
@Transactional
public class ServicioReporteImpl implements ServicioReporte {

  private RepositorioReporte repositorioReporte;

  @Autowired
  public ServicioReporteImpl(RepositorioReporte repositorioReporte) {
    this.repositorioReporte = repositorioReporte;
  }

  @Override
  public Reporte guardarReporte(Reporte reporte) {
    return repositorioReporte.guardarReporte(reporte);
  }

  @Override
  public Reporte buscarReporte(Long id) {
    return repositorioReporte.buscarReporte(id);
  }

  @Override
  public List<Reporte> buscarPorPorducto(Long productoId) {
    return repositorioReporte.buscarPorPorducto(productoId);
  }

  @Override
  public Reporte marcarDudoso(Long id) {
    return repositorioReporte.marcarDudoso(id);
  }

  @Override
  public List<Reporte> listarTodos() {
    return repositorioReporte.listarTodos();
  }
}
