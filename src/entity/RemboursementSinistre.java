package entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the remboursement_sinistre database table.
 * 
 */
@Entity
@Table(name="remboursement_sinistre")
@NamedQuery(name="RemboursementSinistre.findAll", query="SELECT r FROM RemboursementSinistre r")
public class RemboursementSinistre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_cloture")
	private Date dateCloture;

	@Temporal(TemporalType.DATE)
	@Column(name="date_depot_dossier_remb")
	private Date dateDepotDossierRemb;

	@Temporal(TemporalType.DATE)
	@Column(name="date_remboursement_sinistre")
	private Date dateRemboursementSinistre;

	@Column(name="delai_remboursement")
	private float delaiRemboursement;

	@Column(name="ecart_frais")
	private double ecartFrais;

	@Column(name="id_societe")
	private int idSociete;

	@Column(name="montant_accorde")
	private double montantAccorde;

	@Column(name="montant_rembourse")
	private double montantRembourse;

	private String observation;

	private String status;

	//bi-directional many-to-one association to Sinistre
	@ManyToOne
	@JoinColumn(name="id_sinistre")
	private Sinistre sinistre;

	public RemboursementSinistre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCloture() {
		return this.dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}

	public Date getDateDepotDossierRemb() {
		return this.dateDepotDossierRemb;
	}

	public void setDateDepotDossierRemb(Date dateDepotDossierRemb) {
		this.dateDepotDossierRemb = dateDepotDossierRemb;
	}

	public Date getDateRemboursementSinistre() {
		return this.dateRemboursementSinistre;
	}

	public void setDateRemboursementSinistre(Date dateRemboursementSinistre) {
		this.dateRemboursementSinistre = dateRemboursementSinistre;
	}

	public float getDelaiRemboursement() {
		return this.delaiRemboursement;
	}

	public void setDelaiRemboursement(float delaiRemboursement) {
		this.delaiRemboursement = delaiRemboursement;
	}

	public double getEcartFrais() {
		return this.ecartFrais;
	}

	public void setEcartFrais(double ecartFrais) {
		this.ecartFrais = ecartFrais;
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

	public double getMontantRembourse() {
		return this.montantRembourse;
	}

	public void setMontantRembourse(double montantRembourse) {
		this.montantRembourse = montantRembourse;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
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