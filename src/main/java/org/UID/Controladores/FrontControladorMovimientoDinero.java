package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Entidades.MovimientoDinero;
import org.UID.Servicios.ServicioEmpleado;
import org.UID.Servicios.ServicioMovimientoDinero;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontControladorMovimientoDinero {

    ServicioMovimientoDinero servicesMD;
    ServicioEmpleado servicesE;
    public FrontControladorMovimientoDinero(ServicioMovimientoDinero servicesMD,ServicioEmpleado servicesE) {
        this.servicesMD = servicesMD;
        this.servicesE = servicesE;
    }
    ///Mapeador para movimiento dinero

    @GetMapping("/movimiento")
    public String movimientos(Model modelp,@AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            modelp.addAttribute("profile", principal.getClaims());
        }
        List<MovimientoDinero> movimientos = this.servicesMD.getListaMovimientoDinero();
        modelp.addAttribute("movimientos",movimientos);
        List<Empleado> empleados = this.servicesE.getListaEmpleado();
        modelp.addAttribute("empleados",empleados);
        return "movimiento";
    }

    @GetMapping("/movimiento/nuevo")
    public String createMovimiento(Model modelnp,@AuthenticationPrincipal OidcUser principal){
        if (principal != null) {
            modelnp.addAttribute("profile", principal.getClaims());
        }
        List<Empleado> empleados = this.servicesE.getListaEmpleado();
        modelnp.addAttribute("empleados",empleados);
        modelnp.addAttribute("movimiento", new MovimientoDinero());
        return "crear-movimiento";
    }

    @GetMapping("/movimiento/{id}")
    public String actualizarMovimiento(@PathVariable Long id, Model model,@AuthenticationPrincipal OidcUser principal){
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
        }
        MovimientoDinero movimientoFind = this.servicesMD.getVerMovimientoDinero(id);
        model.addAttribute("movimientoFind", movimientoFind);
        return "editar-movimiento";
    }


}
