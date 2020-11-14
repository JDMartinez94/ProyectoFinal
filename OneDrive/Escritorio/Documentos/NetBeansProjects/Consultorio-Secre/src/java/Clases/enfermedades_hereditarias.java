
package Clases;


public class enfermedades_hereditarias {
    int idEnfermedadH; 
    pacientes idPaciente; 
    String enfermedadH; 

    public enfermedades_hereditarias() {
    }

    public enfermedades_hereditarias(int idEnfermedadH, pacientes idPaciente, String enfermedadH) {
        this.idEnfermedadH = idEnfermedadH;
        this.idPaciente = idPaciente;
        this.enfermedadH = enfermedadH;
    }

    public int getIdEnfermedadH() {
        return idEnfermedadH;
    }

    public void setIdEnfermedadH(int idEnfermedadH) {
        this.idEnfermedadH = idEnfermedadH;
    }

    public pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEnfermedadH() {
        return enfermedadH;
    }

    public void setEnfermedadH(String enfermedadH) {
        this.enfermedadH = enfermedadH;
    }
    
    
}
