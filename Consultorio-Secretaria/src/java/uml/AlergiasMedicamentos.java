/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jdmar
 */
@Entity
@Table(name = "alergias_medicamentos")
@NamedQueries({
    @NamedQuery(name = "AlergiasMedicamentos.findAll", query = "SELECT a FROM AlergiasMedicamentos a")
    , @NamedQuery(name = "AlergiasMedicamentos.findByIdAlergia", query = "SELECT a FROM AlergiasMedicamentos a WHERE a.idAlergia = :idAlergia")
    , @NamedQuery(name = "AlergiasMedicamentos.findByAlergiaAMed", query = "SELECT a FROM AlergiasMedicamentos a WHERE a.alergiaAMed = :alergiaAMed")})
public class AlergiasMedicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlergia", nullable = false)
    private Integer idAlergia;
    @Column(name = "alergia_a_med", length = 50)
    private String alergiaAMed;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne
    private Pacientes idPaciente;

    public AlergiasMedicamentos() {
    }

    public AlergiasMedicamentos(Integer idAlergia) {
        this.idAlergia = idAlergia;
    }

    public Integer getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(Integer idAlergia) {
        this.idAlergia = idAlergia;
    }

    public String getAlergiaAMed() {
        return alergiaAMed;
    }

    public void setAlergiaAMed(String alergiaAMed) {
        this.alergiaAMed = alergiaAMed;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlergia != null ? idAlergia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlergiasMedicamentos)) {
            return false;
        }
        AlergiasMedicamentos other = (AlergiasMedicamentos) object;
        if ((this.idAlergia == null && other.idAlergia != null) || (this.idAlergia != null && !this.idAlergia.equals(other.idAlergia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uml.AlergiasMedicamentos[ idAlergia=" + idAlergia + " ]";
    }
    
}
