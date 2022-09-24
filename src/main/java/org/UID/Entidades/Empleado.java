package org.UID.Entidades;
import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "documentoEmpleado")
    private int documentoEmpleado;
    @Column(name = "correo")
    private String correo;
    @Column(name = "rol")
    private String rol;

    //Al crear el empleado este se relaciona con una Empresa, para eso se genera el MayToOne al id de la empresa
    /* @Column(name = "empresa")
    private String empresa;*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EmpresaID", nullable = false)
    private Empresa empresas;

    //Se crea el mapeo para que el empleado pueda ser asignado a un movimiento de dinero
    //nuevo
    @OneToMany(mappedBy="empleadoMovimiento")
    private Set<MovimientoDinero> movimientos;

    public Empleado() {
    }

   /* public Empleado(long id, String nombre, String correo, String empresa, String rol) {
        this.id = id;
        Nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
    }*/

    public int getDocumentoEmpleado() {
        return documentoEmpleado;
    }

    public void setDocumentoEmpleado(int documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
/*
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
*/
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Empresa getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresa empresas) {
        this.empresas = empresas;
    }

    public Set<MovimientoDinero> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Set<MovimientoDinero> movimientos) {
        this.movimientos = movimientos;
    }
}
