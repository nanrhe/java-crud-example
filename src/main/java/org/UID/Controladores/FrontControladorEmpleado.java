package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Entidades.MovimientoDinero;
import org.UID.Servicios.ServicioEmpleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontControladorEmpleado {

    ServicioEmpleado servicesE;
    public FrontControladorEmpleado(ServicioEmpleado servicesE) {
        this.servicesE = servicesE;
    }

    @GetMapping("/empleado")
    public String empleados(Model modelemp) {
        List<Empleado> empleados = this.servicesE.getListaEmpleado();
        modelemp.addAttribute("empleados",empleados);
        return "empleado";
    }
}