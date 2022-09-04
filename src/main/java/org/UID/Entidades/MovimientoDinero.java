package org.UID.Entidades;

import java.util.Date;

public class MovimientoDinero {

    private long id;
    private String conceptoMovimiento;
    private Float montoMovimiento;
    private boolean egreso;
    private Date fechaCreacion;
    private Date fechaActualizacion;

    //constructor

    public MovimientoDinero(long id, String conceptoMovimiento, Float montoMovimiento, boolean egreso, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.conceptoMovimiento = conceptoMovimiento;
        this.montoMovimiento = montoMovimiento;
        this.egreso = egreso;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }
    public Float getMontoMovimiento() {
        return montoMovimiento;
    }
    public void setMontoMovimiento(Float montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }
    public boolean isEgreso() {
        return egreso;
    }
    public void setEgreso(boolean egreso) {
        this.egreso = egreso;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
