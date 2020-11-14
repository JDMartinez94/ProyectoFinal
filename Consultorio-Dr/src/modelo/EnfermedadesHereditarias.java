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
public class EnfermedadesHereditarias {
    private int idEnfermedadH;
    private Pacientes idPaciente;
    private String enfermedadH;

    public EnfermedadesHereditarias() {
    }

    public EnfermedadesHereditarias(int idEnfermedadH, int idPaciente, String enfermedadH) {
        this.idEnfermedadH = idEnfermedadH;
        this.idPaciente = new Pacientes();
        this.enfermedadH = enfermedadH;
    }

    public int getIdEnfermedadH() {
        return idEnfermedadH;
    }

    public void setIdEnfermedadH(int idEnfermedadH) {
        this.idEnfermedadH = idEnfermedadH;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEnfermedadH() {
        return enfermedadH;
    }

    public void setEnfermedadH(String enfermedadH) {
        this.enfermedadH = enfermedadH;
    }
    
    
}
