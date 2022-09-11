package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Entidades.Empresa;
import org.UID.Servicios.ServicioEmpleado;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorEmpleado {


    ServicioEmpleado servicesE;

    public ControladorEmpleado(ServicioEmpleado servicesE) {
        this.servicesE = servicesE;
    }

    @GetMapping("/empleado")
    public List<Empleado> ListaEmpleado() {
        return this.servicesE.getListaEmpleado();
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