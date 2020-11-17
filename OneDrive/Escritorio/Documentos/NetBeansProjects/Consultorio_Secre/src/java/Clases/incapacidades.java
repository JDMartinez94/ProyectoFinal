
package Clases;

import java.sql.Date;


public class incapacidades {
    private int idInca; 
    private registro_consultas idregConsulta; 
    private Date finalInca; 

    public incapacidades() {
    }

    public incapacidades(int idInca, registro_consultas idregConsulta, Date finalInca) {
        this.idInca = idInca;
        this.idregConsulta = idregConsulta;
        this.finalInca = finalInca;
    }

    public Date getFinalInca() {
        return finalInca;
    }

    public void setFinalInca(Date finalInca) {
        this.finalInca = finalInca;
    }

    public int getIdInca() {
        return idInca;
    }

    public void setIdInca(int idInca) {
        this.idInca = idInca;
    }

    public registro_consultas getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(registro_consultas idregConsulta) {
        this.idregConsulta = idregConsulta;
    }
    
    
}
