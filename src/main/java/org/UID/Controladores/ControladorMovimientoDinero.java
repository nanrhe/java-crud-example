package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Entidades.MovimientoDinero;
import org.UID.Servicios.ServicioEmpleado;
import org.UID.Servicios.ServicioMovimientoDinero;
import org.springframework.format.annotation.DateTimeFormat;
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
    public RedirectView createMovimiento(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD")MovimientoDinero p, Model modelNm){
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
    public RedirectView actualizarMovimiento(@PathVariable Long id, MovimientoDinero editMovimiento){
        this.servicesMD.actMovimiento(id, editMovimiento);
        return new RedirectView("/movimiento");
    }
    //Controlador para eliminar un movimiento segun id
    /*@DeleteMapping("/movimiento/{id}")
    public MovimientoDinero eliminarMovimiento(@PathVariable(value = "id") Long id) {
        return this.servicesMD.eliminarM(id);
    }*/
    @DeleteMapping("/movimiento/{id}")
    public RedirectView eliminarMovimiento(@PathVariable(value = "id") Long id){
        this.servicesMD.eliminarM(id);
        return new RedirectView("/movimiento");
    }



}