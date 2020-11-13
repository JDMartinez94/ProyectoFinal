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
public class RecetasMedicas {
    private int idregReceta;
    private RegistroConsultas idregConsulta;
    private String nombreMedicina;
    private String indicaciones;

    public RecetasMedicas() {
    }

    public RecetasMedicas(int idregReceta, int idregConsulta, String nombreMedicina, String indicaciones) {
        this.idregReceta = idregReceta;
        this.idregConsulta = new RegistroConsultas();
        this.nombreMedicina = nombreMedicina;
        this.indicaciones = indicaciones;
    }

    public int getIdregReceta() {
        return idregReceta;
    }

    public void setIdregReceta(int idregReceta) {
        this.idregReceta = idregReceta;
    }

    public RegistroConsultas getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(RegistroConsultas idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public String getNombreMedicina() {
        return nombreMedicina;
    }

    public void setNombreMedicina(String nombreMedicina) {
        this.nombreMedicina = nombreMedicina;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }
    
    
    
}
