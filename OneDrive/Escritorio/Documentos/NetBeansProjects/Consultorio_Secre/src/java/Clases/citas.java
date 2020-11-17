
package Clases;

import java.sql.Time;
import java.sql.Date;


public class citas {
    private int idCita; 
    private pacientes idPaciente;
    private Date fechaCita; 
    private Time horaCita; 
    private String statusCita; 
    private usuarios idUsuario;
    private pacientes nombresPaciente;
    private pacientes apellidosPaciente;
    private usuarios nombreUsuario;

    public citas() {
    }
    
    public citas(int idCita) {
        this.idCita = idCita;
    }

    public citas(int idCita, pacientes idPaciente, Date fechaCita, Time horaCita, String statusCita, usuarios idUsuario) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.statusCita = statusCita;
        this.idUsuario = idUsuario;
    }
    
    public citas(int idCita, pacientes nombresPaciente, pacientes apellidosPaciente, Date fechaCita, Time horaCita, String statusCita, usuarios nombreUsuario) {
        this.idCita = idCita;
        this.nombresPaciente = nombresPaciente;
        this.apellidosPaciente = apellidosPaciente;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.statusCita = statusCita;
        this.nombreUsuario = nombreUsuario;
    }

    public usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Time getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Time horaCita) {
        this.horaCita = horaCita;
    }

    public String getStatusCita() {
        return statusCita;
    }

    public void setStatusCita(String statusCita) {
        this.statusCita = statusCita;
    }
    
        
}
