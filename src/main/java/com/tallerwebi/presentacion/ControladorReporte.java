package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Comercio.ServicioComercio;
import com.tallerwebi.dominio.Producto.ServicioProducto;
import com.tallerwebi.dominio.Reporte.Reporte;
import com.tallerwebi.dominio.Reporte.ServicioReporte;
import com.tallerwebi.dominio.RepositorioUsuario;
import com.tallerwebi.dominio.ServicioLogin;
import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.dominio.excepcion.PrecioIncorrecto;
import com.tallerwebi.dominio.excepcion.ReporteExistente;
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
  private ServicioLogin servicioLogin;
  private static final String VISTA_REPORTES = "reportes";

  @Autowired
  public ControladorReporte(
    ServicioReporte servicioReporte,
    ServicioProducto servicioProducto,
    ServicioComercio servicioComercio,
    ServicioLogin servicioLogin
  ) {
    this.servicioReporte = servicioReporte;
    this.servicioProducto = servicioProducto;
    this.servicioComercio = servicioComercio;
    this.servicioLogin = servicioLogin;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView guardarReporte(@ModelAttribute Reporte reporte, HttpServletRequest request) {
    try {
      if (reporte.getPrecio() == null || reporte.getPrecio() <= 0) {
        throw new PrecioIncorrecto();
      }
      String email = (String) request.getSession().getAttribute("EMAIL");
      Usuario usuario = servicioLogin.buscarPorEmail(email);
      reporte.setUsuario(usuario);
      servicioReporte.guardarReporte(reporte);
    } catch (PrecioIncorrecto e) {
      ModelAndView mav = new ModelAndView(VISTA_REPORTES);
      mav.addObject("error", "El precio debe ser mayor a cero");
      mav.addObject(VISTA_REPORTES, servicioReporte.listarTodos());
      mav.addObject("productos", servicioProducto.listarTodos());
      mav.addObject("comercios", servicioComercio.listarTodos());
      return mav;
    } catch (ReporteExistente e) {
      ModelAndView mav = new ModelAndView(VISTA_REPORTES);
      mav.addObject("error", "Ya reportaste este precio hoy");
      mav.addObject(VISTA_REPORTES, servicioReporte.listarTodos());
      mav.addObject("productos", servicioProducto.listarTodos());
      mav.addObject("comercios", servicioComercio.listarTodos());
      return mav;
    }
    return new ModelAndView("redirect:/reporte");
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public ModelAndView buscarReporte(@PathVariable Long id) {
    Reporte reporte = servicioReporte.buscarReporte(id);
    ModelAndView mav = new ModelAndView(VISTA_REPORTES);
    mav.addObject(VISTA_REPORTES, reporte);
    return mav;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView listarTodos(HttpServletRequest request) {
    if (request.getSession().getAttribute("ROL") == null) {
      return new ModelAndView("redirect:/login");
    }
    List<Reporte> reportes = servicioReporte.listarTodos();
    ModelAndView mav = new ModelAndView(VISTA_REPORTES);
    mav.addObject(VISTA_REPORTES, reportes);
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
