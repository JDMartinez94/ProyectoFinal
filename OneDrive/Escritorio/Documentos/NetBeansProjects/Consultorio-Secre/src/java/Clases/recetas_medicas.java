
package Clases;


public class recetas_medicas {
    private int idregReceta; 
    private registro_consultas idregConsulta;
    private String nombreMedicina; 
    private String indicaciones;

    public recetas_medicas() {
    }

    public recetas_medicas(int idregReceta, registro_consultas idregConsulta, String nombreMedicina, String indicaciones) {
        this.idregReceta = idregReceta;
        this.idregConsulta = idregConsulta;
        this.nombreMedicina = nombreMedicina;
        this.indicaciones = indicaciones;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public int getIdregReceta() {
        return idregReceta;
    }

    public void setIdregReceta(int idregReceta) {
        this.idregReceta = idregReceta;
    }

    public registro_consultas getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(registro_consultas idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public String getNombreMedicina() {
        return nombreMedicina;
    }

    public void setNombreMedicina(String nombreMedicina) {
        this.nombreMedicina = nombreMedicina;
    }
    
    
}
