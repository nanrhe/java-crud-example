package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Entidades.Empresa;
import org.UID.Entidades.MovimientoDinero;
import org.UID.Servicios.ServicioEmpleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ControladorEmpleado {


    ServicioEmpleado servicesE;

    public ControladorEmpleado(ServicioEmpleado servicesE) {
        this.servicesE = servicesE;
    }

    /*@GetMapping("/empleado")
    public List<Empleado> ListaEmpleado() {
        return this.servicesE.getListaEmpleado();
    }*/

    @GetMapping("/empleado")
    public String empleados(Model modele) {
        List<Empleado> empleados = this.servicesE.getListaEmpleado();
        modele.addAttribute("empleados",empleados);
        return "empleado";
    }
    @GetMapping("/empleado/{id}")
    public Empleado verEmpleado(@PathVariable Long id) {
        return this.servicesE.getVerEmpleado(id);
    }
    @PostMapping("/empleado")
    public Empleado createEmpleado(@RequestBody Empleado empleado ){return this.servicesE.createEmpleado(empleado);
    }

    @PutMapping("/empleado/editar/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado actEmpleado){
    return this.servicesE.actEmpleado(id, actEmpleado);
    }

    @DeleteMapping("/empleado/eliminar/{id}")
    public Empleado eliminarEmpleado(@PathVariable(value = "id") Long id){
        return this.servicesE.eliminarE(id);
    }
}