package org.UID.Controladores;

import org.UID.Entidades.MovimientoDinero;
import org.UID.Servicios.ServicioMovimientoDinero;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@RestController
public class ControladorMovimientoDinero {
    ServicioMovimientoDinero servicesMD;
    public ControladorMovimientoDinero(ServicioMovimientoDinero servicesMD) {
        this.servicesMD = servicesMD;
    }
    //////////// Mapeador navegacion Servicio movimiento
    @PostMapping("/movimiento")
    public RedirectView createMovimiento(@ModelAttribute MovimientoDinero p, Model modelNm){
        modelNm.addAttribute((p));
        this.servicesMD.createMovimiento(p);
        return new RedirectView("/movimiento");
    }

    //controlador para editar un movimiento de dinero, consultado por el id
    /*@PutMapping("/movimiento/{id}")
    public MovimientoDinero actualizarMovimiento(@PathVariable Long id, @RequestBody MovimientoDinero actMovimiento) {
        return this.servicesMD.actMovimiento(id, actMovimiento);
    }*/

    @PutMapping("/movimiento/{id}")
    public RedirectView actualizarMovimiento(@PathVariable Long id, MovimientoDinero actMovimiento){
        this.servicesMD.actMovimiento(id, actMovimiento);
        return new RedirectView("/movimiento");
    }
    //Controlador para eliminar un movimiento segun id
    @DeleteMapping("/movimiento/eliminar/{id}")
    public MovimientoDinero eliminarMovimiento(@PathVariable(value = "id") Long id) {
        return this.servicesMD.eliminarM(id);
    }
}