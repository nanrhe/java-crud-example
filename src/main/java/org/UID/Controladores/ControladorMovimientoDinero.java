package org.UID.Controladores;

import org.UID.Entidades.Empleado;
import org.UID.Entidades.MovimientoDinero;
import org.UID.Servicios.ServicioMovimientoDinero;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorMovimientoDinero {

    ServicioMovimientoDinero servicesMD;

    public ControladorMovimientoDinero(ServicioMovimientoDinero servicesMD) {
        this.servicesMD = servicesMD;
    }

    //Controlador para consulta todos los movimientos Lista
    @GetMapping("/movimiento")
    public List<MovimientoDinero> ListaMovimientoDinero() {
        return this.servicesMD.getListaMovimientoDinero();
    }

    //Controlador para consulta el movimiento con el ID
    @GetMapping("/movimiento/{id}")
    public MovimientoDinero verMovimientoDinero(@PathVariable Long id) {
        return this.servicesMD.getVerMovimientoDinero(id);
    }

    //Controlador para crear un movimiento de dinero
    @PostMapping("/movimiento")
    public MovimientoDinero createMovimiento(@RequestBody MovimientoDinero ingreso) {
        return this.servicesMD.createMovimiento(ingreso);
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