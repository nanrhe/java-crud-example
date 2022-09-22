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

    //Servicio que lista y muestra todos los movimientos de dinero
    public List<MovimientoDinero> getListaMovimientoDinero(){
        return this.repositorioMD.findAll();
    }

    //Servicio para ver un movimiento de dinero segun ID
    public MovimientoDinero getVerMovimientoDinero(Long id){
        return this.repositorioMD.findById(id).orElseThrow();
    }
    //Servicio para Crear un movimiento de dinero
    public MovimientoDinero createMovimiento(MovimientoDinero nuevoMovimiento){
        return this.repositorioMD.save(nuevoMovimiento);
    }


    //Servicio para Editar un movimiento de dinero segun ID
    public MovimientoDinero actMovimiento(Long id, MovimientoDinero editMovimiento){
        MovimientoDinero movimentoActual = repositorioMD.findById(id).orElseThrow();
        movimentoActual.setMontoMovimiento(editMovimiento.getMontoMovimiento());
        movimentoActual.setConceptoMovimiento(editMovimiento.getConceptoMovimiento());
        movimentoActual.setFechaActualizacion(editMovimiento.getFechaActualizacion());
        movimentoActual.setEgreso(editMovimiento.isEgreso());
        movimentoActual.setEmpleadoMovimiento(editMovimiento.getEmpleadoMovimiento());
        movimentoActual.setFechaCreacion(editMovimiento.getFechaCreacion());
        return this.repositorioMD.save(movimentoActual);
    }

    //Servicio para eliminar un movimiento de dinero segun ID
    public MovimientoDinero eliminarM(Long id){
        MovimientoDinero movimientoActual = repositorioMD.findById(id).orElseThrow(); // Muestra lo que se borro
        this.repositorioMD.deleteById(id);
        return movimientoActual;
    }


}
