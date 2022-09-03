package org.UID;

public class MovimientoDinero {

    private Float montoMovimiento;
    private String conceptoMovimiento;

    private long id;

    //constructor

    public MovimientoDinero(Float montoMovimiento, String conceptoMovimiento) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
    }


    //Getter
    public Float getMontoMovimiento() {
        return montoMovimiento;
    }
    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }


    //Setter
    public void setMontoMovimiento(Float montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }
    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    //metodos

    public void montos(){};
    public void usuarioEncargado(){};


}
