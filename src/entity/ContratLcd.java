/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "contrat_lcd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContratLcd.findAll", query = "SELECT c FROM ContratLcd c"),
    @NamedQuery(name = "ContratLcd.findById", query = "SELECT c FROM ContratLcd c WHERE c.id = :id"),
    @NamedQuery(name = "ContratLcd.findByNumeroContrat", query = "SELECT c FROM ContratLcd c WHERE c.numeroContrat = :numeroContrat"),
    @NamedQuery(name = "ContratLcd.findByDateContrat", query = "SELECT c FROM ContratLcd c WHERE c.dateContrat = :dateContrat"),
    @NamedQuery(name = "ContratLcd.findByTauxJournalier", query = "SELECT c FROM ContratLcd c WHERE c.tauxJournalier = :tauxJournalier"),
    @NamedQuery(name = "ContratLcd.findByDureeLocation", query = "SELECT c FROM ContratLcd c WHERE c.dureeLocation = :dureeLocation"),
    @NamedQuery(name = "ContratLcd.findByFranchise", query = "SELECT c FROM ContratLcd c WHERE c.franchise = :franchise"),
    @NamedQuery(name = "ContratLcd.findByAvance", query = "SELECT c FROM ContratLcd c WHERE c.avance = :avance"),
    @NamedQuery(name = "ContratLcd.findByDateDepart", query = "SELECT c FROM ContratLcd c WHERE c.dateDepart = :dateDepart"),
    @NamedQuery(name = "ContratLcd.findByHeureDepart", query = "SELECT c FROM ContratLcd c WHERE c.heureDepart = :heureDepart"),
    @NamedQuery(name = "ContratLcd.findByKmDepart", query = "SELECT c FROM ContratLcd c WHERE c.kmDepart = :kmDepart"),
    @NamedQuery(name = "ContratLcd.findByLieuLivraison", query = "SELECT c FROM ContratLcd c WHERE c.lieuLivraison = :lieuLivraison"),
    @NamedQuery(name = "ContratLcd.findByDatePrevueRetour", query = "SELECT c FROM ContratLcd c WHERE c.datePrevueRetour = :datePrevueRetour"),
    @NamedQuery(name = "ContratLcd.findByDateRetour", query = "SELECT c FROM ContratLcd c WHERE c.dateRetour = :dateRetour"),
    @NamedQuery(name = "ContratLcd.findByHeureRetour", query = "SELECT c FROM ContratLcd c WHERE c.heureRetour = :heureRetour"),
    @NamedQuery(name = "ContratLcd.findByKmRetour", query = "SELECT c FROM ContratLcd c WHERE c.kmRetour = :kmRetour"),
    @NamedQuery(name = "ContratLcd.findByNiveauReservoirDepart", query = "SELECT c FROM ContratLcd c WHERE c.niveauReservoirDepart = :niveauReservoirDepart"),
    @NamedQuery(name = "ContratLcd.findByNiveauReservoirRetour", query = "SELECT c FROM ContratLcd c WHERE c.niveauReservoirRetour = :niveauReservoirRetour"),
    @NamedQuery(name = "ContratLcd.findByIdSociete", query = "SELECT c FROM ContratLcd c WHERE c.idSociete = :idSociete")})
public class ContratLcd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "numero_contrat")
    private String numeroContrat;
    @Column(name = "date_contrat")
    @Temporal(TemporalType.DATE)
    private Date dateContrat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taux_journalier")
    private Float tauxJournalier;
    @Column(name = "duree_location")
    private Float dureeLocation;
    @Column(name = "franchise")
    private Float franchise;
    @Column(name = "Avance")
    private Float avance;
    @Column(name = "date_depart")
    @Temporal(TemporalType.DATE)
    private Date dateDepart;
    @Size(max = 50)
    @Column(name = "heure_depart")
    private String heureDepart;
    @Column(name = "km_depart")
    private Integer kmDepart;
    @Size(max = 50)
    @Column(name = "lieu_livraison")
    private String lieuLivraison;
    @Column(name = "date_prevue_retour")
    @Temporal(TemporalType.DATE)
    private Date datePrevueRetour;
    @Column(name = "date_retour")
    @Temporal(TemporalType.DATE)
    private Date dateRetour;
    @Size(max = 50)
    @Column(name = "heure_retour")
    private String heureRetour;
    @Column(name = "km_retour")
    private Float kmRetour;
    @Column(name = "niveau_reservoir_depart")
    private Float niveauReservoirDepart;
    @Column(name = "niveau_reservoir_retour")
    private Float niveauReservoirRetour;
    @Column(name = "id_societe")
    private Integer idSociete;
    @OneToMany(mappedBy = "idContrat")
    private Collection<ContratLcdProlongation> contratLcdProlongationCollection;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id")
    @ManyToOne
    private Vehicule idVehicule;
    @JoinColumn(name = "id_contact", referencedColumnName = "id")
    @ManyToOne
    private Contact idContact;
    @JoinColumn(name = "id_conducteur", referencedColumnName = "id")
    @ManyToOne
    private Contact idConducteur;
    @JoinColumn(name = "id_locataire", referencedColumnName = "id")
    @ManyToOne
    private Contact idLocataire;
    
    private String status;
    
    public ContratLcd() {
    }

    public ContratLcd(Integer id) {
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

    public String getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(String numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public Date getDateContrat() {
        return dateContrat;
    }

    public void setDateContrat(Date dateContrat) {
        this.dateContrat = dateContrat;
    }

    public Float getTauxJournalier() {
        return tauxJournalier;
    }

    public void setTauxJournalier(Float tauxJournalier) {
        this.tauxJournalier = tauxJournalier;
    }

    public Float getDureeLocation() {
        return dureeLocation;
    }

    public void setDureeLocation(Float dureeLocation) {
        this.dureeLocation = dureeLocation;
    }

    public Float getFranchise() {
        return franchise;
    }

    public void setFranchise(Float franchise) {
        this.franchise = franchise;
    }

    public Float getAvance() {
        return avance;
    }

    public void setAvance(Float avance) {
        this.avance = avance;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Integer getKmDepart() {
        return kmDepart;
    }

    public void setKmDepart(Integer kmDepart) {
        this.kmDepart = kmDepart;
    }

    public String getLieuLivraison() {
        return lieuLivraison;
    }

    public void setLieuLivraison(String lieuLivraison) {
        this.lieuLivraison = lieuLivraison;
    }

    public Date getDatePrevueRetour() {
        return datePrevueRetour;
    }

    public void setDatePrevueRetour(Date datePrevueRetour) {
        this.datePrevueRetour = datePrevueRetour;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getHeureRetour() {
        return heureRetour;
    }

    public void setHeureRetour(String heureRetour) {
        this.heureRetour = heureRetour;
    }

    public Float getKmRetour() {
        return kmRetour;
    }

    public void setKmRetour(Float kmRetour) {
        this.kmRetour = kmRetour;
    }

    public Float getNiveauReservoirDepart() {
        return niveauReservoirDepart;
    }

    public void setNiveauReservoirDepart(Float niveauReservoirDepart) {
        this.niveauReservoirDepart = niveauReservoirDepart;
    }

    public Float getNiveauReservoirRetour() {
        return niveauReservoirRetour;
    }

    public void setNiveauReservoirRetour(Float niveauReservoirRetour) {
        this.niveauReservoirRetour = niveauReservoirRetour;
    }

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    @XmlTransient
    public Collection<ContratLcdProlongation> getContratLcdProlongationCollection() {
        return contratLcdProlongationCollection;
    }

    public void setContratLcdProlongationCollection(Collection<ContratLcdProlongation> contratLcdProlongationCollection) {
        this.contratLcdProlongationCollection = contratLcdProlongationCollection;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Contact getIdContact() {
        return idContact;
    }

    public void setIdContact(Contact idContact) {
        this.idContact = idContact;
    }

    public Contact getIdConducteur() {
        return idConducteur;
    }

    public void setIdConducteur(Contact idConducteur) {
        this.idConducteur = idConducteur;
    }

    public Contact getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(Contact idLocataire) {
        this.idLocataire = idLocataire;
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
        if (!(object instanceof ContratLcd)) {
            return false;
        }
        ContratLcd other = (ContratLcd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ContratLcd[ id=" + id + " ]";
    }
    
}
