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
public class Citas {
    private int idCita;
    private Pacientes idPaciente;
    private String fechaCita;
    private String horaCita;
    private String statusCita;
    private Usuarios idUsuario;

    public Citas() {
    }

    public Citas(int idCita, int idPaciente, String fechaCita, String horaCita, String statusCita, int idUsuario) {
        this.idCita = idCita;
        this.idPaciente = new Pacientes();
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.statusCita = statusCita;
        this.idUsuario = new Usuarios();
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getStatusCita() {
        return statusCita;
    }

    public void setStatusCita(String statusCita) {
        this.statusCita = statusCita;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }  
    
    
}
