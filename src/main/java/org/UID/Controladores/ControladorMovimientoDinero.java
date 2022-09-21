package org.UID.Controladores;

import org.UID.Entidades.MovimientoDinero;
import org.UID.Servicios.ServicioMovimientoDinero;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class ControladorMovimientoDinero {

    ServicioMovimientoDinero servicesMD;
    public ControladorMovimientoDinero(ServicioMovimientoDinero servicesMD) {
        this.servicesMD = servicesMD;
    }
    //////////// Mapeador navegacion Servicio movimiento

    @PostMapping("/movimiento")
    public RedirectView createMovimiento(@ModelAttribute MovimientoDinero ingreso, Model modelNm){
        modelNm.addAttribute(ingreso);
        this.servicesMD.createMovimiento(ingreso);
        return new RedirectView("/movimiento");
    }

    //Controlador para consulta el movimiento con el ID
    @GetMapping("/movimiento/{id}")
    public MovimientoDinero verMovimientoDinero(@PathVariable Long id) {
        return this.servicesMD.getVerMovimientoDinero(id);
    }


    //controlador para editar un movimiento de dinero, consultado por el id
    @PutMapping("/movimiento/editar/{id}")
    public MovimientoDinero actualizarMovimiento(@PathVariable Long id, @RequestBody MovimientoDinero actMovimiento) {
        return this.servicesMD.actMovimiento(id, actMovimiento);
    }
    //Controlador para eliminar un movimiento segun id
    @DeleteMapping("/movimiento/eliminar/{id}")
    public MovimientoDinero eliminarMovimiento(@PathVariable(value = "id") Long id) {
        return this.servicesMD.eliminarM(id);
    }





}