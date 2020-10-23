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
@Table(name = "enfermedades_hereditarias")
@NamedQueries({
    @NamedQuery(name = "EnfermedadesHereditarias.findAll", query = "SELECT e FROM EnfermedadesHereditarias e")
    , @NamedQuery(name = "EnfermedadesHereditarias.findByIdEnfermedadH", query = "SELECT e FROM EnfermedadesHereditarias e WHERE e.idEnfermedadH = :idEnfermedadH")
    , @NamedQuery(name = "EnfermedadesHereditarias.findByEnfermedadH", query = "SELECT e FROM EnfermedadesHereditarias e WHERE e.enfermedadH = :enfermedadH")})
public class EnfermedadesHereditarias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEnfermedadH", nullable = false)
    private Integer idEnfermedadH;
    @Column(name = "enfermedadH", length = 50)
    private String enfermedadH;
    @JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne
    private Pacientes idPaciente;

    public EnfermedadesHereditarias() {
    }

    public EnfermedadesHereditarias(Integer idEnfermedadH) {
        this.idEnfermedadH = idEnfermedadH;
    }

    public Integer getIdEnfermedadH() {
        return idEnfermedadH;
    }

    public void setIdEnfermedadH(Integer idEnfermedadH) {
        this.idEnfermedadH = idEnfermedadH;
    }

    public String getEnfermedadH() {
        return enfermedadH;
    }

    public void setEnfermedadH(String enfermedadH) {
        this.enfermedadH = enfermedadH;
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
        hash += (idEnfermedadH != null ? idEnfermedadH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnfermedadesHereditarias)) {
            return false;
        }
        EnfermedadesHereditarias other = (EnfermedadesHereditarias) object;
        if ((this.idEnfermedadH == null && other.idEnfermedadH != null) || (this.idEnfermedadH != null && !this.idEnfermedadH.equals(other.idEnfermedadH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uml.EnfermedadesHereditarias[ idEnfermedadH=" + idEnfermedadH + " ]";
    }
    
}
