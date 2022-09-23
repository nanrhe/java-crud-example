package org.UID.Controladores;

import org.UID.Entidades.MovimientoDinero;
import org.UID.Servicios.ServicioMovimientoDinero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontControladorMovimientoDinero {

    ServicioMovimientoDinero servicesMD;
    public FrontControladorMovimientoDinero(ServicioMovimientoDinero servicesMD) {
        this.servicesMD = servicesMD;
    }
    ///Mapeador para movimiento dinero

    @GetMapping("/movimiento")
    public String movimientos(Model modelp) {
        List<MovimientoDinero> movimientos = this.servicesMD.getListaMovimientoDinero();
        modelp.addAttribute("movimientos",movimientos);
        return "movimiento";
    }

    @GetMapping("/movimiento/nuevo")
    public String createMovimiento(Model modelnp){
        modelnp.addAttribute("movimiento", new MovimientoDinero());
        return "crear-movimiento";
    }

    @GetMapping("/movimiento/{id}")
    public String actualizarMovimiento(@PathVariable Long id, Model model){
        MovimientoDinero movimientoFind = this.servicesMD.getVerMovimientoDinero(id);
        model.addAttribute("movimientoFind", movimientoFind);
        return "editar-movimiento";
    }
}