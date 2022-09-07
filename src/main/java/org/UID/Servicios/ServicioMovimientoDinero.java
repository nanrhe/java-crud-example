package org.UID.Servicios;

import org.UID.Entidades.Empleado;
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

   //falta aclarar como se modifica un bolean, porque al ingresar no  me sale la opcion del getEgreso
    public MovimientoDinero actMovimiento(Long id, MovimientoDinero nuevomovimiento){
        MovimientoDinero movimentoActual = repositorioMD.findById(id).orElseThrow();
        movimentoActual.setMontoMovimiento(nuevomovimiento.getMontoMovimiento());
        movimentoActual.setConceptoMovimiento(nuevomovimiento.getConceptoMovimiento());
        return this.repositorioMD.save(nuevomovimiento);
    }
    //metodo Borrar
    public MovimientoDinero eliminarM(Long id){
        MovimientoDinero movimientoActual = repositorioMD.findById(id).orElseThrow(); // Muestra lo que se borro
        this.repositorioMD.deleteById(id);
        return movimientoActual;
    }

}
