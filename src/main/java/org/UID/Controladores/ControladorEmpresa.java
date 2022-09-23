package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Entidades.Empresa;
import org.UID.Entidades.MovimientoDinero;
import org.UID.Servicios.ServicioEmpresa;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ControladorEmpresa {

    ServicioEmpresa servicesEmp;

    public ControladorEmpresa(ServicioEmpresa servicesEmp) {
        this.servicesEmp = servicesEmp;
    }

    /*
    @GetMapping("/empresa")
    public List<Empresa> ListaEmpresa(){return this.servicesEmp.getListaEmpresa();}*/
    @GetMapping("/empresa")
    public String ListaEmpresa(Model modelp,@AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            modelp.addAttribute("profile", principal.getClaims());
        }
        List<Empresa> empresas = this.servicesEmp.getListaEmpresa();
        modelp.addAttribute("empresas",empresas);
        return "empresa";
    }
    @GetMapping("/empresa/{id}")
    public Empresa verEmpresa(@PathVariable Long id) {
        return this.servicesEmp.getVerEmpresa(id);
    }

    @PostMapping("/empresa")
    public Empresa createEmpresa(@RequestBody Empresa empresa){return this.servicesEmp.createEmpresa(empresa);}

    @PutMapping("/empresa/editar/{id}")
    public Empresa actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa actEmpresa){
    return this.servicesEmp.actEmpresa(id, actEmpresa);
    }

    @DeleteMapping("/empresa/eliminar/{id}")
    public Empresa eliminarEmpresa(@PathVariable(value = "id")Long id) {return this.servicesEmp.eliminarEmp(id);}
}
