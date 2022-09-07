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

    @GetMapping("/movimiento")
    public List<MovimientoDinero> ListaMovimientoDinero() {
        return this.servicesMD.getListaMovimientoDinero();
    }

    @PostMapping("/movimiento")
    public MovimientoDinero createMovimiento(@RequestBody MovimientoDinero ingreso) {
        return this.servicesMD.createMovimiento(ingreso);
    }

    @PutMapping("/movimiento/editar/{id}")
    public MovimientoDinero actualizarMovimiento(@PathVariable Long id, @RequestBody MovimientoDinero actMovimiento) {
        return this.servicesMD.actMovimiento(id, actMovimiento);
    }

    @DeleteMapping("/movimiento/eliminar/{id}")
    public MovimientoDinero eliminarMovimiento(@PathVariable(value = "id") Long id) {
        return this.servicesMD.eliminarM(id);
    }
}