package org.UID.Controladores;

import org.UID.Entidades.Empresa;
import org.UID.Servicios.ServicioEmpresa;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ControladorEmpresa {

    ServicioEmpresa servicesEmp;

    public ControladorEmpresa(ServicioEmpresa servicesEmp) {
        this.servicesEmp = servicesEmp;
    }

    /*
    @GetMapping("/empresa")
    public List<Empresa> ListaEmpresa(){return this.servicesEmp.getListaEmpresa();}*/
//    @GetMapping("/empresa")
//    public String ListaEmpresa(Model modelp,@AuthenticationPrincipal OidcUser principal) {
//        if (principal != null) {
//            modelp.addAttribute("profile", principal.getClaims());
//        }
//        List<Empresa> empresas = this.servicesEmp.getListaEmpresa();
//        modelp.addAttribute("empresas",empresas);
//        return "empresa";
//    }
//    @GetMapping("/empresa/{id}")
//    public Empresa verEmpresa(@PathVariable Long id) {
//        return this.servicesEmp.getVerEmpresa(id);
//    }

    @PostMapping("/empresa")
    public RedirectView createEmpresa(@ModelAttribute Empresa empresa, Model model){
        model.addAttribute(empresa);
        this.servicesEmp.createEmpresa(empresa);
        return new RedirectView("/empresa");
    }

    @PutMapping("/empresa/{id}")
    public RedirectView actualizarEmpresa(@PathVariable Long id, Empresa actEmpresa){
     this.servicesEmp.actEmpresa(id, actEmpresa);
     return new RedirectView("/empresa");
    }

    @DeleteMapping("/empresa/{id}")
    public RedirectView eliminarEmpresa(@PathVariable(value = "id")Long id) {
        this.servicesEmp.eliminarEmp(id);
        return new RedirectView("/empresa");
    }
}
