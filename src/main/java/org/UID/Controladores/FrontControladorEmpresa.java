package org.UID.Controladores;

import org.UID.Entidades.Empresa;
import org.UID.Servicios.ServicioEmpresa;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontControladorEmpresa {

    ServicioEmpresa servicesEmp;
    public FrontControladorEmpresa(ServicioEmpresa servicesEmp) {
        this.servicesEmp = servicesEmp;
    }
    @GetMapping("/empresa")
    public String empresa(Model modelemp, @AuthenticationPrincipal OidcUser principal){
        if (principal != null){
            modelemp.addAttribute("profile",principal.getClaims());
        }
        List<Empresa> empresa = this.servicesEmp.getListaEmpresa();
        modelemp.addAttribute("empresa",empresa);
        return "empresa";
    }

    @GetMapping("/empresa/nuevo")
    public String createEmpresa(Model modelemp){
        modelemp.addAttribute("empresa",new Empresa());
        return "crear-empresa";
    }
    @GetMapping("/empresa/{id}")
    public String actualizarEmpresa(@PathVariable Long id, Model model){
        Empresa empresaFind = this.servicesEmp.getVerEmpresa(id);
        model.addAttribute("empresaFind",empresaFind);
        return "editar-empresa";
    }
}
