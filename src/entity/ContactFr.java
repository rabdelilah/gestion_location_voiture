package entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the contact_frs database table.
 * 
 */
@Entity
@Table(name="contact_frs")
@XmlRootElement
@NamedQuery(name="ContactFr.findAll", query="SELECT c FROM ContactFr c")
public class ContactFr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String fonction;

	private String gsm;

	private String nom;

	private String observation;

	private String prenom;

	private String status;

	//bi-directional many-to-one association to CommandeFr
	@OneToMany(mappedBy="contactFr")
	private List<CommandeFr> commandeFrs;

	//bi-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name="id_frs")
	private Fournisseur fournisseur;

	 @Column(name = "id_societe")
	 private Integer idSociete;
	   public Integer getIdSociete() {
	        return idSociete;
	    }

	 public void setIdSociete(Integer idSociete) {
	        this.idSociete = idSociete;
	    }
	public ContactFr() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getGsm() {
		return this.gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CommandeFr> getCommandeFrs() {
		return this.commandeFrs;
	}

	public void setCommandeFrs(List<CommandeFr> commandeFrs) {
		this.commandeFrs = commandeFrs;
	}

	public CommandeFr addCommandeFr(CommandeFr commandeFr) {
		getCommandeFrs().add(commandeFr);
		commandeFr.setContactFr(this);

		return commandeFr;
	}

	public CommandeFr removeCommandeFr(CommandeFr commandeFr) {
		getCommandeFrs().remove(commandeFr);
		commandeFr.setContactFr(null);

		return commandeFr;
	}

	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactFr other = (ContactFr) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContactFr [id=" + id + "]";
	}

}