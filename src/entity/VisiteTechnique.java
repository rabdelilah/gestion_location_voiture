/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "visite_technique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VisiteTechnique.findAll", query = "SELECT v FROM VisiteTechnique v"),
    @NamedQuery(name = "VisiteTechnique.findById", query = "SELECT v FROM VisiteTechnique v WHERE v.id = :id"),
    @NamedQuery(name = "VisiteTechnique.findByOrdre", query = "SELECT v FROM VisiteTechnique v WHERE v.ordre = :ordre"),
    @NamedQuery(name = "VisiteTechnique.findByDateVisite", query = "SELECT v FROM VisiteTechnique v WHERE v.dateVisite = :dateVisite"),
    @NamedQuery(name = "VisiteTechnique.findByTypeControle", query = "SELECT v FROM VisiteTechnique v WHERE v.typeControle = :typeControle"),
    @NamedQuery(name = "VisiteTechnique.findByDateProchaineVisite", query = "SELECT v FROM VisiteTechnique v WHERE v.dateProchaineVisite = :dateProchaineVisite"),
    @NamedQuery(name = "VisiteTechnique.findByCentreVisite", query = "SELECT v FROM VisiteTechnique v WHERE v.centreVisite = :centreVisite"),
    @NamedQuery(name = "VisiteTechnique.findByStatut", query = "SELECT v FROM VisiteTechnique v WHERE v.status = :statut")})
public class VisiteTechnique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ordre")
    private Integer ordre;
    @Column(name = "date_visite")
    @Temporal(TemporalType.DATE)
    private Date dateVisite;
    @Size(max = 50)
    @Column(name = "type_controle")
    private String typeControle;
    @Column(name = "date_prochaine_visite")
    @Temporal(TemporalType.DATE)
    private Date dateProchaineVisite;
    @Size(max = 50)
    @Column(name = "centre_visite")
    private String centreVisite;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id")
    @ManyToOne
    private Vehicule idVehicule;
    
    @Column(name = "id_societe")
    private Integer idSociete;
    
    public VisiteTechnique() {
    }

    public VisiteTechnique(Integer id) {
        this.id = id;
    }

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public String getTypeControle() {
        return typeControle;
    }

    public void setTypeControle(String typeControle) {
        this.typeControle = typeControle;
    }

    public Date getDateProchaineVisite() {
        return dateProchaineVisite;
    }

    public void setDateProchaineVisite(Date dateProchaineVisite) {
        this.dateProchaineVisite = dateProchaineVisite;
    }

    public String getCentreVisite() {
        return centreVisite;
    }

    public void setCentreVisite(String centreVisite) {
        this.centreVisite = centreVisite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatut(String status) {
        this.status = status;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Integer getIdSociete() {
		return idSociete;
	}

	public void setIdSociete(Integer idSociete) {
		this.idSociete = idSociete;
	}

	public void setStatus(String status) {
		this.status = status;
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
        if (!(object instanceof VisiteTechnique)) {
            return false;
        }
        VisiteTechnique other = (VisiteTechnique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VisiteTechnique[ id=" + id + " ]";
    }
    
}
