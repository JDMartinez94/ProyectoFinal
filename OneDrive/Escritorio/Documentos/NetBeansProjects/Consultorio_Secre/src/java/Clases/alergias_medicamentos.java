
package Clases;

public class alergias_medicamentos {
    private int idAlergia;
    private pacientes idPaciente; 
    private String alergia_a_med; 

    public alergias_medicamentos() {
    }

    public alergias_medicamentos(int idAlergia, pacientes idPaciente, String alergia_a_med) {
        this.idAlergia = idAlergia;
        this.idPaciente = idPaciente;
        this.alergia_a_med = alergia_a_med;
    }

    public String getAlergia_a_med() {
        return alergia_a_med;
    }

    public void setAlergia_a_med(String alergia_a_med) {
        this.alergia_a_med = alergia_a_med;
    }

    public int getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(int idAlergia) {
        this.idAlergia = idAlergia;
    }

    public pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    
}
