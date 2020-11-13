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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "financement_facilite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinancementFacilite.findAll", query = "SELECT f FROM FinancementFacilite f"),
    @NamedQuery(name = "FinancementFacilite.findById", query = "SELECT f FROM FinancementFacilite f WHERE f.id = :id"),
    @NamedQuery(name = "FinancementFacilite.findByMontantFacilite", query = "SELECT f FROM FinancementFacilite f WHERE f.montantFacilite = :montantFacilite"),
    @NamedQuery(name = "FinancementFacilite.findByNbreEcheanceFacilite", query = "SELECT f FROM FinancementFacilite f WHERE f.nbreEcheanceFacilite = :nbreEcheanceFacilite"),
    @NamedQuery(name = "FinancementFacilite.findByDate1ereEcheanceFacilite", query = "SELECT f FROM FinancementFacilite f WHERE f.date1ereEcheanceFacilite = :date1ereEcheanceFacilite"),
    @NamedQuery(name = "FinancementFacilite.findByIdSociete", query = "SELECT f FROM FinancementFacilite f WHERE f.idSociete = :idSociete")})
public class FinancementFacilite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant_facilite")
    private Float montantFacilite;
    @Column(name = "nbre_echeance_facilite")
    private Integer nbreEcheanceFacilite;
    @Column(name = "date_1ere_echeance_facilite")
    @Temporal(TemporalType.DATE)
    private Date date1ereEcheanceFacilite;
    @Column(name = "id_societe")
    private Integer idSociete;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id")
    @ManyToOne
    private Vehicule idVehicule;

    private String status;
    
    public FinancementFacilite() {
    }

    public FinancementFacilite(Integer id) {
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

    public Float getMontantFacilite() {
        return montantFacilite;
    }

    public void setMontantFacilite(Float montantFacilite) {
        this.montantFacilite = montantFacilite;
    }

    public Integer getNbreEcheanceFacilite() {
        return nbreEcheanceFacilite;
    }

    public void setNbreEcheanceFacilite(Integer nbreEcheanceFacilite) {
        this.nbreEcheanceFacilite = nbreEcheanceFacilite;
    }

    public Date getDate1ereEcheanceFacilite() {
        return date1ereEcheanceFacilite;
    }

    public void setDate1ereEcheanceFacilite(Date date1ereEcheanceFacilite) {
        this.date1ereEcheanceFacilite = date1ereEcheanceFacilite;
    }

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
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
        if (!(object instanceof FinancementFacilite)) {
            return false;
        }
        FinancementFacilite other = (FinancementFacilite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FinancementFacilite[ id=" + id + " ]";
    }
    
}
