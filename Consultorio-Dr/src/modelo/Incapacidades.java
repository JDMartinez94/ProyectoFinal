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
public class Incapacidades {
    private int idInca;
    private RegistroConsultas idregConsulta;
    private String finalInca;

    public Incapacidades() {
    }

    public Incapacidades(int idInca, int idregConsulta, String finalInca) {
        this.idInca = idInca;
        this.idregConsulta = new RegistroConsultas();
        this.finalInca = finalInca;
    }

    public int getIdInca() {
        return idInca;
    }

    public void setIdInca(int idInca) {
        this.idInca = idInca;
    }

    public RegistroConsultas getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(RegistroConsultas idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public String getFinalInca() {
        return finalInca;
    }

    public void setFinalInca(String finalInca) {
        this.finalInca = finalInca;
    }    
    
}
