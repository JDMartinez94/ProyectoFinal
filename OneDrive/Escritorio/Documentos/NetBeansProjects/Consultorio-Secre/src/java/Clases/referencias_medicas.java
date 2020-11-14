
package Clases;


public class referencias_medicas {
    private int idReferencia; 
    private registro_consultas idregConsulta; 
    private String motivoRef; 
    private String ReferidoA; 

    public referencias_medicas() {
    }

    public referencias_medicas(int idReferencia, registro_consultas idregConsulta, String motivoRef, String ReferidoA) {
        this.idReferencia = idReferencia;
        this.idregConsulta = idregConsulta;
        this.motivoRef = motivoRef;
        this.ReferidoA = ReferidoA;
    }

    public String getReferidoA() {
        return ReferidoA;
    }

    public void setReferidoA(String ReferidoA) {
        this.ReferidoA = ReferidoA;
    }

    public int getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(int idReferencia) {
        this.idReferencia = idReferencia;
    }

    public registro_consultas getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(registro_consultas idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public String getMotivoRef() {
        return motivoRef;
    }

    public void setMotivoRef(String motivoRef) {
        this.motivoRef = motivoRef;
    }
    
    
}
