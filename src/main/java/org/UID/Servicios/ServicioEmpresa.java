package org.UID.Servicios;

import org.UID.Entidades.Empresa;
import org.UID.Repositorio.RepositorioEmpresa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpresa {

    private RepositorioEmpresa repositorioEmp;

    public ServicioEmpresa(RepositorioEmpresa repositorioEmp){this.repositorioEmp = repositorioEmp;}

    public List<Empresa> getListaEmpresa() {return this.repositorioEmp.findAll();}

    public Empresa getVerEmpresa(Long id){
        return this.repositorioEmp.findById(id).orElseThrow();
    }

    public Empresa createEmpresa(Empresa empresa){return  this.repositorioEmp.save(empresa);}

    public Empresa actEmpresa(Long id, Empresa nuevaempresa){
        Empresa estadoActual = repositorioEmp.findById(id).orElseThrow();
        estadoActual.setNit(nuevaempresa.getNit());
        estadoActual.setNombreEmpresa(nuevaempresa.getNombreEmpresa());
        estadoActual.setDireccion(nuevaempresa.getDireccion());
        estadoActual.setTelefono(nuevaempresa.getTelefono());
        return this.repositorioEmp.save(estadoActual);
    }
    public Empresa eliminarEmp(Long id){
        Empresa estadoActual = repositorioEmp.findById(id).orElseThrow();
        this.repositorioEmp.deleteById(id);
        return estadoActual;
    }

}
