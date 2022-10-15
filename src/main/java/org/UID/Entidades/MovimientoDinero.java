package org.UID.Entidades;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table (name="MovimientoDinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "conceptoMovimiento")
    private String conceptoMovimiento;
    @Column(name = "montoMovimiento")
    private Float montoMovimiento;
    @Column(name = "egreso")
    private boolean egreso;
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;
    @Column(name = "fechaActualizacion")
    private Date fechaActualizacion;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idEmpleado")
    private Empleado empleadoMovimiento;

    //constructor
    public MovimientoDinero() {
    }
/*
    public MovimientoDinero(long id, String conceptoMovimiento, Float montoMovimiento, boolean egreso, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.conceptoMovimiento = conceptoMovimiento;
        this.montoMovimiento = montoMovimiento;
        this.egreso = egreso;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }*/

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
    public Empleado getEmpleadoMovimiento() {
        return empleadoMovimiento;
    }
    public void setEmpleadoMovimiento(Empleado empleadoMovimiento) {
        this.empleadoMovimiento = empleadoMovimiento;
    }
}
