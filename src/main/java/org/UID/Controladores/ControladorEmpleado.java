package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Servicios.ServicioEmpleado;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorEmpleado {


    ServicioEmpleado servicesMD;

    public ControladorEmpleado(ServicioEmpleado servicesMD) {
        this.servicesMD = servicesMD;
    }

    @GetMapping("/empleado")
    public List<Empleado> ListaEmpleado() {
        return this.servicesMD.getListaEmpleado();
    }
    @PostMapping("/empleado")
    public Empleado createEmpleado(@RequestBody Empleado empleado ){return this.servicesMD.createEmpleado(empleado);
    }

    @PutMapping("/empleado/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado actEmpleado){
    return this.servicesMD.actEmpleado(id, actEmpleado);
    }

    @DeleteMapping("empleado/{id}")
    public Empleado eliminarEmpleado(@PathVariable(value = "id") Long id){
        return this.servicesMD.eliminarE(id);
    }
}