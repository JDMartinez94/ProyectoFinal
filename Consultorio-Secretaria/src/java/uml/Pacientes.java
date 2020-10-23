/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jdmar
 */
@Entity
@Table(name = "pacientes")
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p")
    , @NamedQuery(name = "Pacientes.findByIdPaciente", query = "SELECT p FROM Pacientes p WHERE p.idPaciente = :idPaciente")
    , @NamedQuery(name = "Pacientes.findByNombresPaciente", query = "SELECT p FROM Pacientes p WHERE p.nombresPaciente = :nombresPaciente")
    , @NamedQuery(name = "Pacientes.findByApellidosPaciente", query = "SELECT p FROM Pacientes p WHERE p.apellidosPaciente = :apellidosPaciente")
    , @NamedQuery(name = "Pacientes.findByFechaNacPaciente", query = "SELECT p FROM Pacientes p WHERE p.fechaNacPaciente = :fechaNacPaciente")
    , @NamedQuery(name = "Pacientes.findByTelPaciente", query = "SELECT p FROM Pacientes p WHERE p.telPaciente = :telPaciente")
    , @NamedQuery(name = "Pacientes.findByEmailPaciente", query = "SELECT p FROM Pacientes p WHERE p.emailPaciente = :emailPaciente")
    , @NamedQuery(name = "Pacientes.findByDireccionPaciente", query = "SELECT p FROM Pacientes p WHERE p.direccionPaciente = :direccionPaciente")
    , @NamedQuery(name = "Pacientes.findByNombreemergPaciente", query = "SELECT p FROM Pacientes p WHERE p.nombreemergPaciente = :nombreemergPaciente")
    , @NamedQuery(name = "Pacientes.findByTelemergPaciente", query = "SELECT p FROM Pacientes p WHERE p.telemergPaciente = :telemergPaciente")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaciente", nullable = false)
    private Integer idPaciente;
    @Column(name = "nombresPaciente", length = 50)
    private String nombresPaciente;
    @Column(name = "apellidosPaciente", length = 50)
    private String apellidosPaciente;
    @Column(name = "fechaNacPaciente")
    @Temporal(TemporalType.DATE)
    private Date fechaNacPaciente;
    @Column(name = "telPaciente", length = 16)
    private String telPaciente;
    @Column(name = "emailPaciente", length = 35)
    private String emailPaciente;
    @Column(name = "direccionPaciente", length = 100)
    private String direccionPaciente;
    @Column(name = "nombreemergPaciente", length = 50)
    private String nombreemergPaciente;
    @Column(name = "telemergPaciente", length = 16)
    private String telemergPaciente;
    @OneToMany(mappedBy = "idPaciente")
    private List<Citas> citasList;
    @OneToMany(mappedBy = "idPaciente")
    private List<EnfermedadesHereditarias> enfermedadesHereditariasList;
    @OneToMany(mappedBy = "idPaciente")
    private List<Operaciones> operacionesList;
    @OneToMany(mappedBy = "idPaciente")
    private List<AlergiasMedicamentos> alergiasMedicamentosList;

    public Pacientes() {
    }

    public Pacientes(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombresPaciente() {
        return nombresPaciente;
    }

    public void setNombresPaciente(String nombresPaciente) {
        this.nombresPaciente = nombresPaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public Date getFechaNacPaciente() {
        return fechaNacPaciente;
    }

    public void setFechaNacPaciente(Date fechaNacPaciente) {
        this.fechaNacPaciente = fechaNacPaciente;
    }

    public String getTelPaciente() {
        return telPaciente;
    }

    public void setTelPaciente(String telPaciente) {
        this.telPaciente = telPaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getDireccionPaciente() {
        return direccionPaciente;
    }

    public void setDireccionPaciente(String direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }

    public String getNombreemergPaciente() {
        return nombreemergPaciente;
    }

    public void setNombreemergPaciente(String nombreemergPaciente) {
        this.nombreemergPaciente = nombreemergPaciente;
    }

    public String getTelemergPaciente() {
        return telemergPaciente;
    }

    public void setTelemergPaciente(String telemergPaciente) {
        this.telemergPaciente = telemergPaciente;
    }

    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    public List<EnfermedadesHereditarias> getEnfermedadesHereditariasList() {
        return enfermedadesHereditariasList;
    }

    public void setEnfermedadesHereditariasList(List<EnfermedadesHereditarias> enfermedadesHereditariasList) {
        this.enfermedadesHereditariasList = enfermedadesHereditariasList;
    }

    public List<Operaciones> getOperacionesList() {
        return operacionesList;
    }

    public void setOperacionesList(List<Operaciones> operacionesList) {
        this.operacionesList = operacionesList;
    }

    public List<AlergiasMedicamentos> getAlergiasMedicamentosList() {
        return alergiasMedicamentosList;
    }

    public void setAlergiasMedicamentosList(List<AlergiasMedicamentos> alergiasMedicamentosList) {
        this.alergiasMedicamentosList = alergiasMedicamentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uml.Pacientes[ idPaciente=" + idPaciente + " ]";
    }
    
}
