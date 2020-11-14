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
public class OperacionesC {
    private int idOperacion;
    private Pacientes idPaciente;
    private String operacion;
    private String anioOper;

    public OperacionesC() {
    }

    public OperacionesC(int idOperacion, int idPaciente, String operacion, String anioOper) {
        this.idOperacion = idOperacion;
        this.idPaciente = new Pacientes();
        this.operacion = operacion;
        this.anioOper = anioOper;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getAnioOper() {
        return anioOper;
    }

    public void setAnioOper(String anioOper) {
        this.anioOper = anioOper;
    }
    
    
}
