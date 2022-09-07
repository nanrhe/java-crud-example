package org.UID.Servicios;

import org.UID.Entidades.Empleado;
import org.UID.Repositorio.RepositorioEmpleado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpleado {

    private RepositorioEmpleado repositorioMD;

    public ServicioEmpleado(RepositorioEmpleado repositorioMD) {
        this.repositorioMD = repositorioMD;
    }
    public List<Empleado> getListaEmpleado(){
        return this.repositorioMD.findAll();
    }

    public Empleado createEmpleado(Empleado empleado){
        return this.repositorioMD.save(empleado);
    }
}
