package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Servicios.ServicioEmpleado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorEmpleado {


    ServicioEmpleado servicesMD;

    public ControladorEmpleado(ServicioEmpleado servicesMD) {
        this.servicesMD = servicesMD;
    }

    @GetMapping("/Empleado")
    public List<Empleado> ListaEmpleado() {
        return this.servicesMD.getListaEmpleado();
    }
    @PostMapping("/Empleado")
    public Empleado createEmpleado(@RequestBody Empleado empleado ){return this.servicesMD.createEmpleado(empleado);
    }

}