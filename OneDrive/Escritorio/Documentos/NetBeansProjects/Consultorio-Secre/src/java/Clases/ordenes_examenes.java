
package Clases;


public class ordenes_examenes {
    private int idOrden; 
    private registro_consultas idregConsulta; 
    private String examen; 

    public ordenes_examenes() {
    }

    public ordenes_examenes(int idOrden, registro_consultas idregConsulta, String examen) {
        this.idOrden = idOrden;
        this.idregConsulta = idregConsulta;
        this.examen = examen;
    }

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public registro_consultas getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(registro_consultas idregConsulta) {
        this.idregConsulta = idregConsulta;
    }
    
    
}
