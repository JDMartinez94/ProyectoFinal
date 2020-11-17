
package Clases;

import java.sql.Date;


public class pacientes {
    private int idPaciente; 
    private String nombresPaciente; 
    private String apellidosPaciente; 
    private Date fechaNacPaciente; 
    private String telPaciente; 
    private String emailPaciente; 
    private String direccionPaciente; 
    private String nombreemergPaciente; 
    private String telemergPaciente; 

    public pacientes() {
    }
    
    public pacientes(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    public pacientes(String nombresPaciente, String apellidosPaciente) {
        this.nombresPaciente = nombresPaciente;
        this.apellidosPaciente = apellidosPaciente;
    }
    
    
    public pacientes(int idPaciente, String nombresPaciente, String apellidosPaciente, Date fechaNacPaciente, String telPaciente, String emailPaciente, String direccionPaciente, String nombreemergPaciente, String telemergPaciente) {
        this.idPaciente = idPaciente;
        this.nombresPaciente = nombresPaciente;
        this.apellidosPaciente = apellidosPaciente;
        this.fechaNacPaciente = fechaNacPaciente;
        this.telPaciente = telPaciente;
        this.emailPaciente = emailPaciente;
        this.direccionPaciente = direccionPaciente;
        this.nombreemergPaciente = nombreemergPaciente;
        this.telemergPaciente = telemergPaciente;
    }

    public String getTelemergPaciente() {
        return telemergPaciente;
    }

    public void setTelemergPaciente(String telemergPaciente) {
        this.telemergPaciente = telemergPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombresPaciente() {
        return nombresPaciente;
    }

    public void setNombresPaciente(String nombresPaciente) {
        this.nombresPaciente = nombresPaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public Date getFechaNacPaciente() {
        return fechaNacPaciente;
    }

    public void setFechaNacPaciente(Date fechaNacPaciente) {
        this.fechaNacPaciente = fechaNacPaciente;
    }

    public String getTelPaciente() {
        return telPaciente;
    }

    public void setTelPaciente(String telPaciente) {
        this.telPaciente = telPaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getDireccionPaciente() {
        return direccionPaciente;
    }

    public void setDireccionPaciente(String direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }

    public String getNombreemergPaciente() {
        return nombreemergPaciente;
    }

    public void setNombreemergPaciente(String nombreemergPaciente) {
        this.nombreemergPaciente = nombreemergPaciente;
    }
    
    
}
