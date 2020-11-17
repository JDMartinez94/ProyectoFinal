
package Clases;

import java.time.Year;


public class operaciones {
    private int idOperacion; 
    private pacientes idPaciente; 
    private String operacion; 
    private int anioOper; 

    public operaciones() {
    }

    public operaciones(int idOperacion, pacientes idPaciente, String operacion, int anioOper) {
        this.idOperacion = idOperacion;
        this.idPaciente = idPaciente;
        this.operacion = operacion;
        this.anioOper = anioOper;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public int getAnioOper() {
        return anioOper;
    }

    public void setAnioOper(int anioOper) {
        this.anioOper = anioOper;
    }

    
    
}
