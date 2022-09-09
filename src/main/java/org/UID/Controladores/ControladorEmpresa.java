package org.UID.Controladores;

import org.UID.Entidades.Empresa;
import org.UID.Servicios.ServicioEmpresa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorEmpresa {

    ServicioEmpresa servicesEmp;

    public ControladorEmpresa(ServicioEmpresa servicesEmp) {
        this.servicesEmp = servicesEmp;
    }

    @GetMapping("/empresa")
    public List<Empresa> ListaEmpresa(){return this.servicesEmp.getListaEmpresa();}

    @PostMapping("/empresa")
    public Empresa createEmpresa(@RequestBody Empresa empresa){return this.servicesEmp.createEmpresa(empresa);}

    @PutMapping("/empresa/editar/{id}")
    public Empresa actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa actEmpresa){
    return this.servicesEmp.actEmpresa(id, actEmpresa);
    }

    @DeleteMapping("/empresa/eliminar/{id}")
    public Empresa eliminarEmpresa(@PathVariable(value = "id")Long id) {return this.servicesEmp.eliminarEmp(id);}
}
