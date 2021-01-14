package modelo;

import java.sql.Date;

/**
 * @author lbojor
 */
public class Cliente {
    private int claveCliente;
    private String nombre;
    private Date fechaIngreso;
    private boolean activo;

    public Cliente(int claveCliente, String nombre, Date fechaIngreso, boolean activo) {
        this.claveCliente = claveCliente;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
    }

    public Cliente() {

    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(int id_clientes) {
        this.claveCliente = id_clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
