
package Clases;


public class registro_consultas {
    private int idregConsulta; 
    private citas idCita; 
    private String diagnosticoConsulta; 
    private usuarios idUsuario; 

    public registro_consultas() {
    }
    
    public registro_consultas(int idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public registro_consultas(int idregConsulta, citas idCita, String diagnosticoConsulta, usuarios idUsuario) {
        this.idregConsulta = idregConsulta;
        this.idCita = idCita;
        this.diagnosticoConsulta = diagnosticoConsulta;
        this.idUsuario = idUsuario;
    }

    public usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(int idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public citas getIdCita() {
        return idCita;
    }

    public void setIdCita(citas idCita) {
        this.idCita = idCita;
    }

    public String getDiagnosticoConsulta() {
        return diagnosticoConsulta;
    }

    public void setDiagnosticoConsulta(String diagnosticoConsulta) {
        this.diagnosticoConsulta = diagnosticoConsulta;
    }
    
    
}
