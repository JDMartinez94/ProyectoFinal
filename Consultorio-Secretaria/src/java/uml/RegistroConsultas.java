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
@Table(name = "registro_consultas")
@NamedQueries({
    @NamedQuery(name = "RegistroConsultas.findAll", query = "SELECT r FROM RegistroConsultas r")
    , @NamedQuery(name = "RegistroConsultas.findByIdregConsulta", query = "SELECT r FROM RegistroConsultas r WHERE r.idregConsulta = :idregConsulta")
    , @NamedQuery(name = "RegistroConsultas.findByDiagnosticoConsulta", query = "SELECT r FROM RegistroConsultas r WHERE r.diagnosticoConsulta = :diagnosticoConsulta")})
public class RegistroConsultas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregConsulta", nullable = false)
    private Integer idregConsulta;
    @Column(name = "diagnosticoConsulta", length = 85)
    private String diagnosticoConsulta;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuarios idUsuario;
    @JoinColumn(name = "idCita", referencedColumnName = "idCita")
    @ManyToOne
    private Citas idCita;

    public RegistroConsultas() {
    }

    public RegistroConsultas(Integer idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public Integer getIdregConsulta() {
        return idregConsulta;
    }

    public void setIdregConsulta(Integer idregConsulta) {
        this.idregConsulta = idregConsulta;
    }

    public String getDiagnosticoConsulta() {
        return diagnosticoConsulta;
    }

    public void setDiagnosticoConsulta(String diagnosticoConsulta) {
        this.diagnosticoConsulta = diagnosticoConsulta;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Citas getIdCita() {
        return idCita;
    }

    public void setIdCita(Citas idCita) {
        this.idCita = idCita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregConsulta != null ? idregConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroConsultas)) {
            return false;
        }
        RegistroConsultas other = (RegistroConsultas) object;
        if ((this.idregConsulta == null && other.idregConsulta != null) || (this.idregConsulta != null && !this.idregConsulta.equals(other.idregConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uml.RegistroConsultas[ idregConsulta=" + idregConsulta + " ]";
    }
    
}
