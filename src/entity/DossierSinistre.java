package entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the dossier_sinistre database table.
 * 
 */
@Entity
@Table(name="dossier_sinistre")
@NamedQuery(name="DossierSinistre.findAll", query="SELECT d FROM DossierSinistre d")
public class DossierSinistre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_accord_devis")
	private Date dateAccordDevis;

	@Temporal(TemporalType.DATE)
	@Column(name="date_depot")
	private Date dateDepot;

	@Temporal(TemporalType.DATE)
	@Column(name="date_remise_rapport_expert_1")
	private Date dateRemiseRapportExpert1;

	@Temporal(TemporalType.DATE)
	@Column(name="date_remise_rapport_expert_2")
	private Date dateRemiseRapportExpert2;

	@Temporal(TemporalType.DATE)
	@Column(name="date_visite_expert_1")
	private Date dateVisiteExpert1;

	@Temporal(TemporalType.DATE)
	@Column(name="date_visite_expert_2")
	private Date dateVisiteExpert2;

	@Column(name="designation_expert_1")
	private String designationExpert1;

	@Column(name="designation_expert_2")
	private String designationExpert2;

	@Column(name="id_societe")
	private int idSociete;

	@Column(name="montant_accorde")
	private double montantAccorde;

	@Column(name="montant_frais_reparation")
	private double montantFraisReparation;

	@Column(name="montant_franchise_deduite")
	private double montantFranchiseDeduite;

	private String observation;

	private String prestataire;

	@Column(name="reference_courrier_accord")
	private String referenceCourrierAccord;

	@Column(name="reference_devis_reparation")
	private String referenceDevisReparation;

	@Column(name="reference_dossier")
	private String referenceDossier;

	private String status;

	@Column(name="valeur_venale")
	private double valeurVenale;

	//bi-directional many-to-one association to Sinistre
	@ManyToOne
	@JoinColumn(name="id_sinistre")
	private Sinistre sinistre;

	public DossierSinistre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateAccordDevis() {
		return this.dateAccordDevis;
	}

	public void setDateAccordDevis(Date dateAccordDevis) {
		this.dateAccordDevis = dateAccordDevis;
	}

	public Date getDateDepot() {
		return this.dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public Date getDateRemiseRapportExpert1() {
		return this.dateRemiseRapportExpert1;
	}

	public void setDateRemiseRapportExpert1(Date dateRemiseRapportExpert1) {
		this.dateRemiseRapportExpert1 = dateRemiseRapportExpert1;
	}

	public Date getDateRemiseRapportExpert2() {
		return this.dateRemiseRapportExpert2;
	}

	public void setDateRemiseRapportExpert2(Date dateRemiseRapportExpert2) {
		this.dateRemiseRapportExpert2 = dateRemiseRapportExpert2;
	}

	public Date getDateVisiteExpert1() {
		return this.dateVisiteExpert1;
	}

	public void setDateVisiteExpert1(Date dateVisiteExpert1) {
		this.dateVisiteExpert1 = dateVisiteExpert1;
	}

	public Date getDateVisiteExpert2() {
		return this.dateVisiteExpert2;
	}

	public void setDateVisiteExpert2(Date dateVisiteExpert2) {
		this.dateVisiteExpert2 = dateVisiteExpert2;
	}

	public String getDesignationExpert1() {
		return this.designationExpert1;
	}

	public void setDesignationExpert1(String designationExpert1) {
		this.designationExpert1 = designationExpert1;
	}

	public String getDesignationExpert2() {
		return this.designationExpert2;
	}

	public void setDesignationExpert2(String designationExpert2) {
		this.designationExpert2 = designationExpert2;
	}

	public int getIdSociete() {
		return this.idSociete;
	}

	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}

	public double getMontantAccorde() {
		return this.montantAccorde;
	}

	public void setMontantAccorde(double montantAccorde) {
		this.montantAccorde = montantAccorde;
	}

	public double getMontantFraisReparation() {
		return this.montantFraisReparation;
	}

	public void setMontantFraisReparation(double montantFraisReparation) {
		this.montantFraisReparation = montantFraisReparation;
	}

	public double getMontantFranchiseDeduite() {
		return this.montantFranchiseDeduite;
	}

	public void setMontantFranchiseDeduite(double montantFranchiseDeduite) {
		this.montantFranchiseDeduite = montantFranchiseDeduite;
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

	public String getReferenceCourrierAccord() {
		return this.referenceCourrierAccord;
	}

	public void setReferenceCourrierAccord(String referenceCourrierAccord) {
		this.referenceCourrierAccord = referenceCourrierAccord;
	}

	public String getReferenceDevisReparation() {
		return this.referenceDevisReparation;
	}

	public void setReferenceDevisReparation(String referenceDevisReparation) {
		this.referenceDevisReparation = referenceDevisReparation;
	}

	public String getReferenceDossier() {
		return this.referenceDossier;
	}

	public void setReferenceDossier(String referenceDossier) {
		this.referenceDossier = referenceDossier;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getValeurVenale() {
		return this.valeurVenale;
	}

	public void setValeurVenale(double valeurVenale) {
		this.valeurVenale = valeurVenale;
	}

	public Sinistre getSinistre() {
		return this.sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

}