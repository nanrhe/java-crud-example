package org.UID.Controladores;

import org.UID.Entidades.MovimientoDinero;
import org.UID.Servicios.ServicioMovimientoDinero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorMovimientoDinero {
    ServicioMovimientoDinero servicesMD;

    public ControladorMovimientoDinero (ServicioMovimientoDinero servicesMD){
        this.servicesMD = servicesMD;
    }

    @GetMapping("/movimientos")
    public List<MovimientoDinero> ListaMovimientoDinero(){
        return this.servicesMD.getListaMovimientoDinero();
    }
}
