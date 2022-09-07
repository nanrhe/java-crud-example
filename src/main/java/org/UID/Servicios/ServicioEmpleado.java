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

    // metodo acatualizar
    public Empleado actEmpleado(Long id, Empleado nuevoempleado){
        Empleado empleadoActual = repositorioMD.findById(id).orElseThrow();
        empleadoActual.setNombre(nuevoempleado.getNombre());
        empleadoActual.setCorreo(nuevoempleado.getCorreo());
        return this.repositorioMD.save(empleadoActual);
    }
    //metodo Borrar
    public Empleado eliminarE(Long id){
        Empleado empleadoActual = repositorioMD.findById(id).orElseThrow(); // Muestra lo que se borro
        this.repositorioMD.deleteById(id);
        return empleadoActual;
    }
}
