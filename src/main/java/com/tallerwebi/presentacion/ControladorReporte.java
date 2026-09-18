package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Comercio.ServicioComercio;
import com.tallerwebi.dominio.Producto.ServicioProducto;
import com.tallerwebi.dominio.Reporte.Reporte;
import com.tallerwebi.dominio.Reporte.ServicioReporte;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reporte")
public class ControladorReporte {

  private ServicioReporte servicioReporte;
  private ServicioProducto servicioProducto;
  private ServicioComercio servicioComercio;

  @Autowired
  public ControladorReporte(
    ServicioReporte servicioReporte,
    ServicioProducto servicioProducto,
    ServicioComercio servicioComercio
  ) {
    this.servicioReporte = servicioReporte;
    this.servicioProducto = servicioProducto;
    this.servicioComercio = servicioComercio;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView guardarReporte(@ModelAttribute Reporte reporte) {
    servicioReporte.guardarReporte(reporte);
    return new ModelAndView("redirect:/reporte");
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public ModelAndView buscarReporte(@PathVariable Long id) {
    Reporte reporte = servicioReporte.buscarReporte(id);
    ModelAndView mav = new ModelAndView("reportes");
    mav.addObject("reporte", reporte);
    return mav;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView listarTodos(HttpServletRequest request) {
    if (request.getSession().getAttribute("ROL") == null) {
      return new ModelAndView("redirect:/login");
    }
    List<Reporte> reportes = servicioReporte.listarTodos();
    ModelAndView mav = new ModelAndView("reportes");
    mav.addObject("reportes", reportes);
    mav.addObject("productos", servicioProducto.listarTodos());
    mav.addObject("comercios", servicioComercio.listarTodos());
    return mav;
  }

  @RequestMapping(path = "/{id}/dudoso", method = RequestMethod.POST)
  public ModelAndView marcarDudoso(@PathVariable Long id) {
    servicioReporte.marcarDudoso(id);
    return new ModelAndView("redirect:/reporte");
  }
}
