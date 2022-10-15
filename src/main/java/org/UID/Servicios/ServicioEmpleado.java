package org.UID.Servicios;

import org.UID.Entidades.Empleado;
import org.UID.Repositorio.RepositorioEmpleado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpleado {

    private RepositorioEmpleado repositorioE;

    public ServicioEmpleado(RepositorioEmpleado repositorioMD) {
        this.repositorioE = repositorioMD;
    }
    public List<Empleado> getListaEmpleado(){
        return this.repositorioE.findAll();
    }
    public Empleado getVerEmpleado(Long id){
        return this.repositorioE.findById(id).orElseThrow();
    }

    public Empleado createEmpleado(Empleado empleado){
        return this.repositorioE.save(empleado);
    }

    // metodo acatualizar
    public Empleado actEmpleado(Long id, Empleado nuevoempleado){
        Empleado empleadoActual = repositorioE.findById(id).orElseThrow();
        empleadoActual.setNombre(nuevoempleado.getNombre());
        empleadoActual.setCorreo(nuevoempleado.getCorreo());
        empleadoActual.setEmpresas(nuevoempleado.getEmpresas());
        empleadoActual.setRol(nuevoempleado.getRol());
        empleadoActual.setDocumentoEmpleado(nuevoempleado.getDocumentoEmpleado());
        return this.repositorioE.save(empleadoActual);
    }
    //metodo Borrar
    public Empleado eliminarE(Long id){
        Empleado empleadoActual = repositorioE.findById(id).orElseThrow(); // Muestra lo que se borro
        this.repositorioE.deleteById(id);
        return empleadoActual;
    }
}
