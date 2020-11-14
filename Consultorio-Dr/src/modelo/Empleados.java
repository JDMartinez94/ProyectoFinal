/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jdmar
 */
public class Empleados {
    private int idEmpleado;
    private String nombreEmpleado;
    private String direccionEmpleado;
    private String telEmpleado;

    public Empleados() {
    }

    public Empleados(int idEmpleado, String nombreEmpleado, String direccionEmpleado, String telEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.direccionEmpleado = direccionEmpleado;
        this.telEmpleado = telEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public String getTelEmpleado() {
        return telEmpleado;
    }

    public void setTelEmpleado(String telEmpleado) {
        this.telEmpleado = telEmpleado;
    }
    
    
    
}
