package entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sinistre database table.
 * 
 */
@Entity
@NamedQuery(name="Sinistre.findAll", query="SELECT s FROM Sinistre s")
public class Sinistre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_sinistre")
	private Date dateSinistre;

	@Column(name="declaration_sinistre")
	private String declarationSinistre;

	private String degats;

	@Column(name="heure_sinistre")
	private String heureSinistre;

	@Column(name="id_contrat")
	private int idContrat;

	@Column(name="id_societe")
	private int idSociete;

	@Column(name="lieu_sinistre")
	private String lieuSinistre;

	private String observation;

	@Column(name="prise_en_charge_adverse")
	private String priseEnChargeAdverse;

	@Column(name="repercussion_frais_adverse")
	private String repercussionFraisAdverse;

	@Column(name="repercussion_frais_client")
	private String repercussionFraisClient;

	private String status;

	@Column(name="type_contrat")
	private String typeContrat;

	@Column(name="vehicule_fautif")
	private String vehiculeFautif;

	//bi-directional many-to-one association to DossierSinistre
	@OneToMany(mappedBy="sinistre")
	private List<DossierSinistre> dossierSinistres;

	//bi-directional many-to-one association to RemboursementSinistre
	@OneToMany(mappedBy="sinistre")
	private List<RemboursementSinistre> remboursementSinistres;

	//bi-directional many-to-one association to ReparationSinistre
	@OneToMany(mappedBy="sinistre")
	private List<ReparationSinistre> reparationSinistres;

	public Sinistre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateSinistre() {
		return this.dateSinistre;
	}

	public void setDateSinistre(Date dateSinistre) {
		this.dateSinistre = dateSinistre;
	}

	public String getDeclarationSinistre() {
		return this.declarationSinistre;
	}

	public void setDeclarationSinistre(String declarationSinistre) {
		this.declarationSinistre = declarationSinistre;
	}

	public String getDegats() {
		return this.degats;
	}

	public void setDegats(String degats) {
		this.degats = degats;
	}

	public String getHeureSinistre() {
		return this.heureSinistre;
	}

	public void setHeureSinistre(String heureSinistre) {
		this.heureSinistre = heureSinistre;
	}

	public int getIdContrat() {
		return this.idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}

	public int getIdSociete() {
		return this.idSociete;
	}

	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}

	public String getLieuSinistre() {
		return this.lieuSinistre;
	}

	public void setLieuSinistre(String lieuSinistre) {
		this.lieuSinistre = lieuSinistre;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getPriseEnChargeAdverse() {
		return this.priseEnChargeAdverse;
	}

	public void setPriseEnChargeAdverse(String priseEnChargeAdverse) {
		this.priseEnChargeAdverse = priseEnChargeAdverse;
	}

	public String getRepercussionFraisAdverse() {
		return this.repercussionFraisAdverse;
	}

	public void setRepercussionFraisAdverse(String repercussionFraisAdverse) {
		this.repercussionFraisAdverse = repercussionFraisAdverse;
	}

	public String getRepercussionFraisClient() {
		return this.repercussionFraisClient;
	}

	public void setRepercussionFraisClient(String repercussionFraisClient) {
		this.repercussionFraisClient = repercussionFraisClient;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypeContrat() {
		return this.typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public String getVehiculeFautif() {
		return this.vehiculeFautif;
	}

	public void setVehiculeFautif(String vehiculeFautif) {
		this.vehiculeFautif = vehiculeFautif;
	}

	public List<DossierSinistre> getDossierSinistres() {
		return this.dossierSinistres;
	}

	public void setDossierSinistres(List<DossierSinistre> dossierSinistres) {
		this.dossierSinistres = dossierSinistres;
	}

	public DossierSinistre addDossierSinistre(DossierSinistre dossierSinistre) {
		getDossierSinistres().add(dossierSinistre);
		dossierSinistre.setSinistre(this);

		return dossierSinistre;
	}

	public DossierSinistre removeDossierSinistre(DossierSinistre dossierSinistre) {
		getDossierSinistres().remove(dossierSinistre);
		dossierSinistre.setSinistre(null);

		return dossierSinistre;
	}

	public List<RemboursementSinistre> getRemboursementSinistres() {
		return this.remboursementSinistres;
	}

	public void setRemboursementSinistres(List<RemboursementSinistre> remboursementSinistres) {
		this.remboursementSinistres = remboursementSinistres;
	}

	public RemboursementSinistre addRemboursementSinistre(RemboursementSinistre remboursementSinistre) {
		getRemboursementSinistres().add(remboursementSinistre);
		remboursementSinistre.setSinistre(this);

		return remboursementSinistre;
	}

	public RemboursementSinistre removeRemboursementSinistre(RemboursementSinistre remboursementSinistre) {
		getRemboursementSinistres().remove(remboursementSinistre);
		remboursementSinistre.setSinistre(null);

		return remboursementSinistre;
	}

	public List<ReparationSinistre> getReparationSinistres() {
		return this.reparationSinistres;
	}

	public void setReparationSinistres(List<ReparationSinistre> reparationSinistres) {
		this.reparationSinistres = reparationSinistres;
	}

	public ReparationSinistre addReparationSinistre(ReparationSinistre reparationSinistre) {
		getReparationSinistres().add(reparationSinistre);
		reparationSinistre.setSinistre(this);

		return reparationSinistre;
	}

	public ReparationSinistre removeReparationSinistre(ReparationSinistre reparationSinistre) {
		getReparationSinistres().remove(reparationSinistre);
		reparationSinistre.setSinistre(null);

		return reparationSinistre;
	}

}