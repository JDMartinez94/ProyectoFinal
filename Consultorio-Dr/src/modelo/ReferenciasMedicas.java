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
public class ReferenciasMedicas {
    private int idReferencia;
    private RegistroConsultas idregConsulta;
    private String motivoRef;
    private String ReferidoA;

    public ReferenciasMedicas() {
    }

    public ReferenciasMedicas(int idReferencia, int idregConsulta, String motivoRef, String ReferidoA) {
        this.idReferencia = idReferencia;
        this.idregConsulta = new RegistroConsultas();
        this.motivoRef = motivoRef;
        this.ReferidoA = ReferidoA;
    }

    public int getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(int idReferencia) {
        this.idReferencia = idReferencia;
    }

    public RegistroConsultas getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(RegistroConsultas idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public String getMotivoRef() {
        return motivoRef;
    }

    public void setMotivoRef(String motivoRef) {
        this.motivoRef = motivoRef;
    }

    public String getReferidoA() {
        return ReferidoA;
    }

    public void setReferidoA(String ReferidoA) {
        this.ReferidoA = ReferidoA;
    }  
        
}
