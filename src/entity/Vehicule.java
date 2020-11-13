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
@Table(name = "vehicule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicule.findAll", query = "SELECT v FROM Vehicule v"),
    @NamedQuery(name = "Vehicule.findById", query = "SELECT v FROM Vehicule v WHERE v.id = :id"),
    @NamedQuery(name = "Vehicule.findByNumeroOrdre", query = "SELECT v FROM Vehicule v WHERE v.numeroOrdre = :numeroOrdre"),
    @NamedQuery(name = "Vehicule.findByNumeroSerie", query = "SELECT v FROM Vehicule v WHERE v.numeroSerie = :numeroSerie"),
    @NamedQuery(name = "Vehicule.findByCouleur", query = "SELECT v FROM Vehicule v WHERE v.couleur = :couleur"),
    @NamedQuery(name = "Vehicule.findByDateMiseEnCirculation", query = "SELECT v FROM Vehicule v WHERE v.dateMiseEnCirculation = :dateMiseEnCirculation"),
    @NamedQuery(name = "Vehicule.findByNumeroWw", query = "SELECT v FROM Vehicule v WHERE v.numeroWw = :numeroWw"),
    @NamedQuery(name = "Vehicule.findByNumeroChassis", query = "SELECT v FROM Vehicule v WHERE v.numeroChassis = :numeroChassis"),
    @NamedQuery(name = "Vehicule.findByModele", query = "SELECT v FROM Vehicule v WHERE v.modele = :modele"),
    @NamedQuery(name = "Vehicule.findByDateAcquisition", query = "SELECT v FROM Vehicule v WHERE v.dateAcquisition = :dateAcquisition"),
    @NamedQuery(name = "Vehicule.findByDateReception", query = "SELECT v FROM Vehicule v WHERE v.dateReception = :dateReception"),
    @NamedQuery(name = "Vehicule.findByDateDepotDossierImmatriculation", query = "SELECT v FROM Vehicule v WHERE v.dateDepotDossierImmatriculation = :dateDepotDossierImmatriculation"),
    @NamedQuery(name = "Vehicule.findByDimension", query = "SELECT v FROM Vehicule v WHERE v.dimension = :dimension"),
    @NamedQuery(name = "Vehicule.findByChargeMax", query = "SELECT v FROM Vehicule v WHERE v.chargeMax = :chargeMax"),
    @NamedQuery(name = "Vehicule.findByConsommationMixte", query = "SELECT v FROM Vehicule v WHERE v.consommationMixte = :consommationMixte"),
    @NamedQuery(name = "Vehicule.findByCarburantUtilise", query = "SELECT v FROM Vehicule v WHERE v.carburantUtilise = :carburantUtilise"),
    @NamedQuery(name = "Vehicule.findByMatricule", query = "SELECT v FROM Vehicule v WHERE v.matricule = :matricule"),
    @NamedQuery(name = "Vehicule.findByDateCarteGriseProvisoire", query = "SELECT v FROM Vehicule v WHERE v.dateCarteGriseProvisoire = :dateCarteGriseProvisoire"),
    @NamedQuery(name = "Vehicule.findByDateCarteGriseDefinitive", query = "SELECT v FROM Vehicule v WHERE v.dateCarteGriseDefinitive = :dateCarteGriseDefinitive"),
    @NamedQuery(name = "Vehicule.findByDateScession", query = "SELECT v FROM Vehicule v WHERE v.dateScession = :dateScession"),
    @NamedQuery(name = "Vehicule.findByMontantScession", query = "SELECT v FROM Vehicule v WHERE v.montantScession = :montantScession"),
    @NamedQuery(name = "Vehicule.findByCinBenificaireScession", query = "SELECT v FROM Vehicule v WHERE v.cinBenificaireScession = :cinBenificaireScession"),
    @NamedQuery(name = "Vehicule.findByMontantVignette", query = "SELECT v FROM Vehicule v WHERE v.montantVignette = :montantVignette"),
    @NamedQuery(name = "Vehicule.findByDateDebutAutorisationCirculation", query = "SELECT v FROM Vehicule v WHERE v.dateDebutAutorisationCirculation = :dateDebutAutorisationCirculation"),
    @NamedQuery(name = "Vehicule.findByDateFinAutorisationCirculation", query = "SELECT v FROM Vehicule v WHERE v.dateFinAutorisationCirculation = :dateFinAutorisationCirculation"),
    @NamedQuery(name = "Vehicule.findByIdSociete", query = "SELECT v FROM Vehicule v WHERE v.idSociete = :idSociete"),
    @NamedQuery(name = "Vehicule.findByStatus", query = "SELECT v FROM Vehicule v WHERE v.status = :status")})
public class Vehicule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero_ordre")
    private Integer numeroOrdre;
    @Size(max = 50)
    @Column(name = "numero_serie")
    private String numeroSerie;
    @Size(max = 50)
    @Column(name = "couleur")
    private String couleur;
    @Column(name = "date_mise_en_circulation")
    @Temporal(TemporalType.DATE)
    private Date dateMiseEnCirculation;
    @Size(max = 50)
    @Column(name = "numero_ww")
    private String numeroWw;
    @Column(name = "numero_chassis")
    private Integer numeroChassis;
    @Size(max = 50)
    @Column(name = "modele")
    private String modele;
    @Column(name = "date_acquisition")
    @Temporal(TemporalType.DATE)
    private Date dateAcquisition;
    @Column(name = "date_reception")
    @Temporal(TemporalType.DATE)
    private Date dateReception;
    @Column(name = "date_depot_dossier_immatriculation")
    @Temporal(TemporalType.DATE)
    private Date dateDepotDossierImmatriculation;
    @Size(max = 50)
    @Column(name = "dimension")
    private String dimension;
    @Column(name = "charge_max")
    private Integer chargeMax;
    @Size(max = 50)
    @Column(name = "consommation_mixte")
    private String consommationMixte;
    @Size(max = 50)
    @Column(name = "carburant_utilise")
    private String carburantUtilise;
    @Size(max = 50)
    @Column(name = "matricule")
    private String matricule;
    @Column(name = "date_carte_grise_provisoire")
    @Temporal(TemporalType.DATE)
    private Date dateCarteGriseProvisoire;
    @Column(name = "date_carte_grise_definitive")
    @Temporal(TemporalType.DATE)
    private Date dateCarteGriseDefinitive;
    @Column(name = "date_scession")
    @Temporal(TemporalType.DATE)
    private Date dateScession;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant_scession")
    private Double montantScession;
    @Size(max = 50)
    @Column(name = "cin_benificaire_scession")
    private String cinBenificaireScession;
    @Column(name = "montant_vignette")
    private Double montantVignette;
    @Column(name = "date_debut_autorisation_circulation")
    @Temporal(TemporalType.DATE)
    private Date dateDebutAutorisationCirculation;
    @Column(name = "date_fin_autorisation_circulation")
    @Temporal(TemporalType.DATE)
    private Date dateFinAutorisationCirculation;
    @Column(name = "id_societe")
    private Integer idSociete;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_type_marque", referencedColumnName = "id")
    @ManyToOne
    private TypeMarque idTypeMarque;
    @JoinColumn(name = "id_personnel_reception", referencedColumnName = "id")
    @ManyToOne
    private Personnel idPersonnelReception;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<PaiementVehicule> paiementVehiculeCollection;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<ContratLcd> contratLcdCollection;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<ContratLld> contratLldCollection;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<FinancementFacilite> financementFaciliteCollection;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<VisiteTechnique> visiteTechniqueCollection;
    @OneToMany(mappedBy = "idVehicule")
    private Collection<Financement> financementCollection;
    
    private Integer nbre_cylindre;
    private String puissance_fiscale;
    private String boite_automatique;
    
    public Vehicule() {
    }

    public Vehicule(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroOrdre() {
        return numeroOrdre;
    }

    public void setNumeroOrdre(Integer numeroOrdre) {
        this.numeroOrdre = numeroOrdre;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Date getDateMiseEnCirculation() {
        return dateMiseEnCirculation;
    }

    public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
        this.dateMiseEnCirculation = dateMiseEnCirculation;
    }

    public String getNumeroWw() {
        return numeroWw;
    }

    public void setNumeroWw(String numeroWw) {
        this.numeroWw = numeroWw;
    }

    public Integer getNumeroChassis() {
        return numeroChassis;
    }

    public void setNumeroChassis(Integer numeroChassis) {
        this.numeroChassis = numeroChassis;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public Date getDateDepotDossierImmatriculation() {
        return dateDepotDossierImmatriculation;
    }

    public void setDateDepotDossierImmatriculation(Date dateDepotDossierImmatriculation) {
        this.dateDepotDossierImmatriculation = dateDepotDossierImmatriculation;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Integer getChargeMax() {
        return chargeMax;
    }

    public void setChargeMax(Integer chargeMax) {
        this.chargeMax = chargeMax;
    }

    public String getConsommationMixte() {
        return consommationMixte;
    }

    public void setConsommationMixte(String consommationMixte) {
        this.consommationMixte = consommationMixte;
    }

    public String getCarburantUtilise() {
        return carburantUtilise;
    }

    public void setCarburantUtilise(String carburantUtilise) {
        this.carburantUtilise = carburantUtilise;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateCarteGriseProvisoire() {
        return dateCarteGriseProvisoire;
    }

    public void setDateCarteGriseProvisoire(Date dateCarteGriseProvisoire) {
        this.dateCarteGriseProvisoire = dateCarteGriseProvisoire;
    }

    public Date getDateCarteGriseDefinitive() {
        return dateCarteGriseDefinitive;
    }

    public void setDateCarteGriseDefinitive(Date dateCarteGriseDefinitive) {
        this.dateCarteGriseDefinitive = dateCarteGriseDefinitive;
    }

    public Date getDateScession() {
        return dateScession;
    }

    public void setDateScession(Date dateScession) {
        this.dateScession = dateScession;
    }

    public Double getMontantScession() {
        return montantScession;
    }

    public void setMontantScession(Double montantScession) {
        this.montantScession = montantScession;
    }

    public String getCinBenificaireScession() {
        return cinBenificaireScession;
    }

    public void setCinBenificaireScession(String cinBenificaireScession) {
        this.cinBenificaireScession = cinBenificaireScession;
    }

    public Double getMontantVignette() {
        return montantVignette;
    }

    public void setMontantVignette(Double montantVignette) {
        this.montantVignette = montantVignette;
    }

    public Date getDateDebutAutorisationCirculation() {
        return dateDebutAutorisationCirculation;
    }

    public void setDateDebutAutorisationCirculation(Date dateDebutAutorisationCirculation) {
        this.dateDebutAutorisationCirculation = dateDebutAutorisationCirculation;
    }

    public Date getDateFinAutorisationCirculation() {
        return dateFinAutorisationCirculation;
    }

    public void setDateFinAutorisationCirculation(Date dateFinAutorisationCirculation) {
        this.dateFinAutorisationCirculation = dateFinAutorisationCirculation;
    }

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TypeMarque getIdTypeMarque() {
        return idTypeMarque;
    }

    public void setIdTypeMarque(TypeMarque idTypeMarque) {
        this.idTypeMarque = idTypeMarque;
    }

    public Personnel getIdPersonnelReception() {
        return idPersonnelReception;
    }

    public void setIdPersonnelReception(Personnel idPersonnelReception) {
        this.idPersonnelReception = idPersonnelReception;
    }

    @XmlTransient
    public Collection<PaiementVehicule> getPaiementVehiculeCollection() {
        return paiementVehiculeCollection;
    }

    public void setPaiementVehiculeCollection(Collection<PaiementVehicule> paiementVehiculeCollection) {
        this.paiementVehiculeCollection = paiementVehiculeCollection;
    }

    @XmlTransient
    public Collection<ContratLcd> getContratLcdCollection() {
        return contratLcdCollection;
    }

    public void setContratLcdCollection(Collection<ContratLcd> contratLcdCollection) {
        this.contratLcdCollection = contratLcdCollection;
    }

    @XmlTransient
    public Collection<ContratLld> getContratLldCollection() {
        return contratLldCollection;
    }

    public void setContratLldCollection(Collection<ContratLld> contratLldCollection) {
        this.contratLldCollection = contratLldCollection;
    }

    @XmlTransient
    public Collection<FinancementFacilite> getFinancementFaciliteCollection() {
        return financementFaciliteCollection;
    }

    public void setFinancementFaciliteCollection(Collection<FinancementFacilite> financementFaciliteCollection) {
        this.financementFaciliteCollection = financementFaciliteCollection;
    }

    @XmlTransient
    public Collection<VisiteTechnique> getVisiteTechniqueCollection() {
        return visiteTechniqueCollection;
    }

    public void setVisiteTechniqueCollection(Collection<VisiteTechnique> visiteTechniqueCollection) {
        this.visiteTechniqueCollection = visiteTechniqueCollection;
    }

    @XmlTransient
    public Collection<Financement> getFinancementCollection() {
        return financementCollection;
    }

    public void setFinancementCollection(Collection<Financement> financementCollection) {
        this.financementCollection = financementCollection;
    }
    
    public String getPuissance_fiscale() {
		return puissance_fiscale;
	}

	public void setPuissance_fiscale(String puissance_fiscale) {
		this.puissance_fiscale = puissance_fiscale;
	}

	public String getBoite_automatique() {
		return boite_automatique;
	}

	public void setBoite_automatique(String boite_automatique) {
		this.boite_automatique = boite_automatique;
	}

	public Integer getNbre_cylindre() {
		return nbre_cylindre;
	}

	public void setNbre_cylindre(Integer nbre_cylindre) {
		this.nbre_cylindre = nbre_cylindre;
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
        if (!(object instanceof Vehicule)) {
            return false;
        }
        Vehicule other = (Vehicule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numeroOrdre+"" ;
    }
    
	
    
    
}
