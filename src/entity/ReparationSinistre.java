package entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the reparation_sinistre database table.
 * 
 */
@Entity
@Table(name="reparation_sinistre")
@NamedQuery(name="ReparationSinistre.findAll", query="SELECT r FROM ReparationSinistre r")
public class ReparationSinistre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_deport_reparation")
	private Date dateDeportReparation;

	@Temporal(TemporalType.DATE)
	@Column(name="date_prevue_recuperation_vehicule")
	private Date datePrevueRecuperationVehicule;

	@Temporal(TemporalType.DATE)
	@Column(name="date_reglement")
	private Date dateReglement;

	@Temporal(TemporalType.DATE)
	@Column(name="date_relle_recuperation_vehicule")
	private Date dateRelleRecuperationVehicule;

	@Column(name="description_travaux")
	private String descriptionTravaux;

	@Column(name="id_societe")
	private int idSociete;

	private double montant;

	@Column(name="montant_reparation_reel")
	private double montantReparationReel;

	@Column(name="nbre_jours_immobilisations")
	private float nbreJoursImmobilisations;

	private String observation;

	private String prestataire;

	@Column(name="reference_facture_prestataire")
	private String referenceFacturePrestataire;

	private String status;

	//bi-directional many-to-one association to Sinistre
	@ManyToOne
	@JoinColumn(name="id_sinistre")
	private Sinistre sinistre;

	public ReparationSinistre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDeportReparation() {
		return this.dateDeportReparation;
	}

	public void setDateDeportReparation(Date dateDeportReparation) {
		this.dateDeportReparation = dateDeportReparation;
	}

	public Date getDatePrevueRecuperationVehicule() {
		return this.datePrevueRecuperationVehicule;
	}

	public void setDatePrevueRecuperationVehicule(Date datePrevueRecuperationVehicule) {
		this.datePrevueRecuperationVehicule = datePrevueRecuperationVehicule;
	}

	public Date getDateReglement() {
		return this.dateReglement;
	}

	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
	}

	public Date getDateRelleRecuperationVehicule() {
		return this.dateRelleRecuperationVehicule;
	}

	public void setDateRelleRecuperationVehicule(Date dateRelleRecuperationVehicule) {
		this.dateRelleRecuperationVehicule = dateRelleRecuperationVehicule;
	}

	public String getDescriptionTravaux() {
		return this.descriptionTravaux;
	}

	public void setDescriptionTravaux(String descriptionTravaux) {
		this.descriptionTravaux = descriptionTravaux;
	}

	public int getIdSociete() {
		return this.idSociete;
	}

	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getMontantReparationReel() {
		return this.montantReparationReel;
	}

	public void setMontantReparationReel(double montantReparationReel) {
		this.montantReparationReel = montantReparationReel;
	}

	public float getNbreJoursImmobilisations() {
		return this.nbreJoursImmobilisations;
	}

	public void setNbreJoursImmobilisations(float nbreJoursImmobilisations) {
		this.nbreJoursImmobilisations = nbreJoursImmobilisations;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getPrestataire() {
		return this.prestataire;
	}

	public void setPrestataire(String prestataire) {
		this.prestataire = prestataire;
	}

	public String getReferenceFacturePrestataire() {
		return this.referenceFacturePrestataire;
	}

	public void setReferenceFacturePrestataire(String referenceFacturePrestataire) {
		this.referenceFacturePrestataire = referenceFacturePrestataire;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Sinistre getSinistre() {
		return this.sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

}