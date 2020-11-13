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
@Table(name = "paiement_vehicule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaiementVehicule.findAll", query = "SELECT p FROM PaiementVehicule p"),
    @NamedQuery(name = "PaiementVehicule.findById", query = "SELECT p FROM PaiementVehicule p WHERE p.id = :id"),
    @NamedQuery(name = "PaiementVehicule.findByNaturePaiement", query = "SELECT p FROM PaiementVehicule p WHERE p.naturePaiement = :naturePaiement"),
    @NamedQuery(name = "PaiementVehicule.findByMontant", query = "SELECT p FROM PaiementVehicule p WHERE p.montant = :montant"),
    @NamedQuery(name = "PaiementVehicule.findByNumeroCheque", query = "SELECT p FROM PaiementVehicule p WHERE p.numeroCheque = :numeroCheque"),
    @NamedQuery(name = "PaiementVehicule.findByBanque", query = "SELECT p FROM PaiementVehicule p WHERE p.banque = :banque"),
    @NamedQuery(name = "PaiementVehicule.findByDateCheque", query = "SELECT p FROM PaiementVehicule p WHERE p.dateCheque = :dateCheque"),
    @NamedQuery(name = "PaiementVehicule.findByIdSociete", query = "SELECT p FROM PaiementVehicule p WHERE p.idSociete = :idSociete")})
public class PaiementVehicule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nature_paiement")
    private String naturePaiement;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Double montant;
    @Size(max = 50)
    @Column(name = "numero_cheque")
    private String numeroCheque;
    @Size(max = 50)
    @Column(name = "banque")
    private String banque;
    @Column(name = "date_cheque")
    @Temporal(TemporalType.DATE)
    private Date dateCheque;
    @Column(name = "id_societe")
    private Integer idSociete;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id")
    @ManyToOne
    private Vehicule idVehicule;
    private String status;
    
    public PaiementVehicule() {
    }

    public PaiementVehicule(Integer id) {
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

    public String getNaturePaiement() {
        return naturePaiement;
    }

    public void setNaturePaiement(String naturePaiement) {
        this.naturePaiement = naturePaiement;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public Date getDateCheque() {
        return dateCheque;
    }

    public void setDateCheque(Date dateCheque) {
        this.dateCheque = dateCheque;
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
        if (!(object instanceof PaiementVehicule)) {
            return false;
        }
        PaiementVehicule other = (PaiementVehicule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PaiementVehicule[ id=" + id + " ]";
    }
    
}
