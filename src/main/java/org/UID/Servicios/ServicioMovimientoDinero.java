package org.UID.Servicios;

import org.UID.Entidades.MovimientoDinero;
import org.UID.Repositorio.RepositorioMovimientoDinero;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioMovimientoDinero {
    private RepositorioMovimientoDinero repositorioMD;

    //constructor
    public ServicioMovimientoDinero(RepositorioMovimientoDinero repositorioMD){
        this.repositorioMD = repositorioMD;
    }
    public List<MovimientoDinero> getListaMovimientoDinero(){
        return this.repositorioMD.findAll();
    }

    public MovimientoDinero createMovimiento(MovimientoDinero ingreso){
        return this.repositorioMD.save(ingreso);
    }


}
