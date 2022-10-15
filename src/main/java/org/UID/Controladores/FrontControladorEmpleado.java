package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Servicios.ServicioEmpleado;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontControladorEmpleado {

    ServicioEmpleado servicesE;
    public FrontControladorEmpleado(ServicioEmpleado servicesE) {
        this.servicesE = servicesE;
    }

    @GetMapping("/empleado")
    public String empleados(Model modelemp, @AuthenticationPrincipal OidcUser principal){
        if (principal != null) {
            modelemp.addAttribute("profile", principal.getClaims());
        }
        List<Empleado> empleados = this.servicesE.getListaEmpleado();
        modelemp.addAttribute("empleados",empleados);
        return "empleado";
    }
    @GetMapping("/empleado/nuevo")
    public String createEmpleado(Model modelnp){
        modelnp.addAttribute("empleado", new Empleado());
        return "crear-empleado";
    }

    @GetMapping("/empleado/{id}")
    public String UpdateEmpelado(@PathVariable Long id, Model model){
        Empleado empleadoFind = this.servicesE.getVerEmpleado(id);
        model.addAttribute("empleadoFind", empleadoFind);
        return "editar-empleado";
    }
}
