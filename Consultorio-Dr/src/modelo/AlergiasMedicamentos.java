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
public class AlergiasMedicamentos {
    private int idAlergia;
    private Pacientes idPaciente;
    private String alergia_a_med;

    public AlergiasMedicamentos() {
    }

    public AlergiasMedicamentos(int idAlergia, int idPaciente, String alergia_a_med) {
        this.idAlergia = idAlergia;
        this.idPaciente = new Pacientes();
        this.alergia_a_med = alergia_a_med;
    }

    public int getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(int idAlergia) {
        this.idAlergia = idAlergia;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getAlergia_a_med() {
        return alergia_a_med;
    }

    public void setAlergia_a_med(String alergia_a_med) {
        this.alergia_a_med = alergia_a_med;
    }
        
}
