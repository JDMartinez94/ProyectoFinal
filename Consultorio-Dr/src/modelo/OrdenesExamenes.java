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
public class OrdenesExamenes {
    private int idOrden;
    private RegistroConsultas idregConsulta;
    private String examen;

    public OrdenesExamenes() {
    }

    public OrdenesExamenes(int idOrden, int idregConsulta, String examen) {
        this.idOrden = idOrden;
        this.idregConsulta = new RegistroConsultas();
        this.examen = examen;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public RegistroConsultas getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(RegistroConsultas idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }   
    
}
