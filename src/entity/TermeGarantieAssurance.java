/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hasnaa
 */
@Entity
@Table(name = "terme_garantie_assurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TermeGarantieAssurance.findAll", query = "SELECT t FROM TermeGarantieAssurance t"),
    @NamedQuery(name = "TermeGarantieAssurance.findById", query = "SELECT t FROM TermeGarantieAssurance t WHERE t.id = :id"),
    @NamedQuery(name = "TermeGarantieAssurance.findByIdAssurance", query = "SELECT t FROM TermeGarantieAssurance t WHERE t.idAssurance = :idAssurance"),
    @NamedQuery(name = "TermeGarantieAssurance.findByIdTypeGarantie", query = "SELECT t FROM TermeGarantieAssurance t WHERE t.idTypeGarantie = :idTypeGarantie"),
    @NamedQuery(name = "TermeGarantieAssurance.findByFranchise", query = "SELECT t FROM TermeGarantieAssurance t WHERE t.franchise = :franchise"),
    @NamedQuery(name = "TermeGarantieAssurance.findByObservations", query = "SELECT t FROM TermeGarantieAssurance t WHERE t.observations = :observations"),
    @NamedQuery(name = "TermeGarantieAssurance.findByIdSociete", query = "SELECT t FROM TermeGarantieAssurance t WHERE t.idSociete = :idSociete")})
public class TermeGarantieAssurance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_assurance", referencedColumnName = "id")
    @ManyToOne
    private Assurance idAssurance;
    
    @JoinColumn(name = "id_type_garantie", referencedColumnName = "id")
    @ManyToOne
    private TypeGarantie idTypeGarantie;
    
    @Size(max = 50)
    @Column(name = "franchise")
    private String franchise;
    @Size(max = 50)
    @Column(name = "observations")
    private String observations;
    @Column(name = "id_societe")
    private Integer idSociete;
    
    private String status;
    
    public TermeGarantieAssurance() {
    }

    public TermeGarantieAssurance(Integer id) {
        this.id = id;
    }
    
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Assurance getIdAssurance() {
		return idAssurance;
	}

	public void setIdAssurance(Assurance idAssurance) {
		this.idAssurance = idAssurance;
	}

	public TypeGarantie getIdTypeGarantie() {
		return idTypeGarantie;
	}

	public void setIdTypeGarantie(TypeGarantie idTypeGarantie) {
		this.idTypeGarantie = idTypeGarantie;
	}

	public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TermeGarantieAssurance)) {
            return false;
        }
        TermeGarantieAssurance other = (TermeGarantieAssurance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TermeGarantieAssurance[ id=" + id + " ]";
    }
    
}
