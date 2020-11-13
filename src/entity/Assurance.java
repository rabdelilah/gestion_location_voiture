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
 * @author hasnaa
 */
@Entity
@Table(name = "assurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assurance.findAll", query = "SELECT a FROM Assurance a"),
    @NamedQuery(name = "Assurance.findById", query = "SELECT a FROM Assurance a WHERE a.id = :id"),
    @NamedQuery(name = "Assurance.findByNumeroOrdre", query = "SELECT a FROM Assurance a WHERE a.numeroOrdre = :numeroOrdre"),
    @NamedQuery(name = "Assurance.findByNumeroPolice", query = "SELECT a FROM Assurance a WHERE a.numeroPolice = :numeroPolice"),
    @NamedQuery(name = "Assurance.findByIntermediaire", query = "SELECT a FROM Assurance a WHERE a.intermediaire = :intermediaire"),
    @NamedQuery(name = "Assurance.findByDateDebutGarantie", query = "SELECT a FROM Assurance a WHERE a.dateDebutGarantie = :dateDebutGarantie"),
    @NamedQuery(name = "Assurance.findByHeureDebutGarantie", query = "SELECT a FROM Assurance a WHERE a.heureDebutGarantie = :heureDebutGarantie"),
    @NamedQuery(name = "Assurance.findByDateFinGarantie", query = "SELECT a FROM Assurance a WHERE a.dateFinGarantie = :dateFinGarantie"),
    @NamedQuery(name = "Assurance.findByHeureFinGarantie", query = "SELECT a FROM Assurance a WHERE a.heureFinGarantie = :heureFinGarantie"),
    @NamedQuery(name = "Assurance.findByDuree", query = "SELECT a FROM Assurance a WHERE a.duree = :duree"),
    @NamedQuery(name = "Assurance.findByPeriodicite", query = "SELECT a FROM Assurance a WHERE a.periodicite = :periodicite"),
    @NamedQuery(name = "Assurance.findByIdSociete", query = "SELECT a FROM Assurance a WHERE a.idSociete = :idSociete")})
public class Assurance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "numero_ordre")
    private String numeroOrdre;
    @Size(max = 50)
    @Column(name = "numero_police")
    private String numeroPolice;
    @Size(max = 50)
    @Column(name = "intermediaire")
    private String intermediaire;
    @Basic(optional = false)
    @Column(name = "date_debut_garantie")
    @Temporal(TemporalType.DATE)
    private Date dateDebutGarantie;
    @Size(max = 50)
    @Column(name = "heure_debut_garantie")
    private String heureDebutGarantie;
    @Basic(optional = false)
    @Column(name = "date_fin_garantie")
    @Temporal(TemporalType.DATE)
    private Date dateFinGarantie;
    @Size(max = 50)
    @Column(name = "heure_fin_garantie")
    private String heureFinGarantie;
    @Size(max = 50)
    @Column(name = "duree")
    private String duree;
    @Size(max = 50)
    @Column(name = "periodicite")
    private String periodicite;
    @Column(name = "id_societe")
    private Integer idSociete;
    @JoinColumn(name = "id_compagnie_assurance", referencedColumnName = "id")
    @ManyToOne
    private CompagnieAssurance idCompagnieAssurance;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id")
    @ManyToOne
    private Vehicule idVehicule;
    
    private String status;
    
    public Assurance() {
    }

    public Assurance(Integer id) {
        this.id = id;
    }

    public Assurance(Integer id, Date dateDebutGarantie, Date dateFinGarantie) {
        this.id = id;
        this.dateDebutGarantie = dateDebutGarantie;
        this.dateFinGarantie = dateFinGarantie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroOrdre() {
        return numeroOrdre;
    }

    public void setNumeroOrdre(String numeroOrdre) {
        this.numeroOrdre = numeroOrdre;
    }

    public String getNumeroPolice() {
        return numeroPolice;
    }

    public void setNumeroPolice(String numeroPolice) {
        this.numeroPolice = numeroPolice;
    }

    public String getIntermediaire() {
        return intermediaire;
    }

    public void setIntermediaire(String intermediaire) {
        this.intermediaire = intermediaire;
    }

    public Date getDateDebutGarantie() {
        return dateDebutGarantie;
    }

    public void setDateDebutGarantie(Date dateDebutGarantie) {
        this.dateDebutGarantie = dateDebutGarantie;
    }

    public String getHeureDebutGarantie() {
        return heureDebutGarantie;
    }

    public void setHeureDebutGarantie(String heureDebutGarantie) {
        this.heureDebutGarantie = heureDebutGarantie;
    }

    public Date getDateFinGarantie() {
        return dateFinGarantie;
    }

    public void setDateFinGarantie(Date dateFinGarantie) {
        this.dateFinGarantie = dateFinGarantie;
    }

    public String getHeureFinGarantie() {
        return heureFinGarantie;
    }

    public void setHeureFinGarantie(String heureFinGarantie) {
        this.heureFinGarantie = heureFinGarantie;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    public CompagnieAssurance getIdCompagnieAssurance() {
        return idCompagnieAssurance;
    }

    public void setIdCompagnieAssurance(CompagnieAssurance idCompagnieAssurance) {
        this.idCompagnieAssurance = idCompagnieAssurance;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getStatus() {
		return status;
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
        if (!(object instanceof Assurance)) {
            return false;
        }
        Assurance other = (Assurance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Assurance[ id=" + id + " ]";
    }
    
}
