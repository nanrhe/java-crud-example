package org.UID.Entidades;

public class Empresa {
    private  long id;
    private String nombreEmpresa;
    private String direccion;
    private int nit;

    public Empresa(long id, String nombreEmpresa, String direccion, int nit) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.nit = nit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
}
