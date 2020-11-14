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
public class RegistroConsultas {
    private int idregConsulta;
    private Citas idCita;
    private String diagnosticoConsulta;
    private Usuarios idUsuario;    

    public RegistroConsultas() {
    }

    public RegistroConsultas(int idregConsulta, int idCita, String diagnosticoConsulta, int idUsuario) {
        this.idregConsulta = idregConsulta;
        this.idCita = new Citas();
        this.diagnosticoConsulta = diagnosticoConsulta;
        this.idUsuario = new Usuarios();
    }

    public int getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(int idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public Citas getIdCita() {
        return idCita;
    }

    public void setIdCita(Citas idCita) {
        this.idCita = idCita;
    }

    public String getDiagnosticoConsulta() {
        return diagnosticoConsulta;
    }

    public void setDiagnosticoConsulta(String diagnosticoConsulta) {
        this.diagnosticoConsulta = diagnosticoConsulta;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
