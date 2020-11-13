package entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the fournisseur database table.
 * 
 */
@Entity
@Table(name = "fournisseur")
@XmlRootElement
@NamedQuery(name="Fournisseur.findAll", query="SELECT f FROM Fournisseur f")
public class Fournisseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String adresse;

	private String cnss;

	private String email;

	private String fax;

	@Column(name="identifiant_fiscal")
	private String identifiantFiscal;

	private String patente;

	@Column(name="raison_social")
	private String raisonSocial;

	private String status;

	private String tel;

	private String type;

	//bi-directional many-to-one association to CommandeFr
	@OneToMany(mappedBy="fournisseur")
	private List<CommandeFr> commandeFrs;

	//bi-directional many-to-one association to ContactFr
	@OneToMany(mappedBy="fournisseur")
	private List<ContactFr> contactFrs;

	//bi-directional many-to-one association to ProduitFr
	@OneToMany(mappedBy="fournisseur")
	private List<ProduitFr> produitFrs;

	 @Column(name = "id_societe")
	 private Integer idSociete;
	   public Integer getIdSociete() {
	        return idSociete;
	    }

	 public void setIdSociete(Integer idSociete) {
	        this.idSociete = idSociete;
	    }
	 
	public Fournisseur() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCnss() {
		return this.cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getIdentifiantFiscal() {
		return this.identifiantFiscal;
	}

	public void setIdentifiantFiscal(String identifiantFiscal) {
		this.identifiantFiscal = identifiantFiscal;
	}

	public String getPatente() {
		return this.patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getRaisonSocial() {
		return this.raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<CommandeFr> getCommandeFrs() {
		return this.commandeFrs;
	}

	public void setCommandeFrs(List<CommandeFr> commandeFrs) {
		this.commandeFrs = commandeFrs;
	}

	public CommandeFr addCommandeFr(CommandeFr commandeFr) {
		getCommandeFrs().add(commandeFr);
		commandeFr.setFournisseur(this);

		return commandeFr;
	}

	public CommandeFr removeCommandeFr(CommandeFr commandeFr) {
		getCommandeFrs().remove(commandeFr);
		commandeFr.setFournisseur(null);

		return commandeFr;
	}

	public List<ContactFr> getContactFrs() {
		return this.contactFrs;
	}

	public void setContactFrs(List<ContactFr> contactFrs) {
		this.contactFrs = contactFrs;
	}

	public ContactFr addContactFr(ContactFr contactFr) {
		getContactFrs().add(contactFr);
		contactFr.setFournisseur(this);

		return contactFr;
	}

	public ContactFr removeContactFr(ContactFr contactFr) {
		getContactFrs().remove(contactFr);
		contactFr.setFournisseur(null);

		return contactFr;
	}

	public List<ProduitFr> getProduitFrs() {
		return this.produitFrs;
	}

	public void setProduitFrs(List<ProduitFr> produitFrs) {
		this.produitFrs = produitFrs;
	}

	public ProduitFr addProduitFr(ProduitFr produitFr) {
		getProduitFrs().add(produitFr);
		produitFr.setFournisseur(this);

		return produitFr;
	}

	public ProduitFr removeProduitFr(ProduitFr produitFr) {
		getProduitFrs().remove(produitFr);
		produitFr.setFournisseur(null);

		return produitFr;
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
		Fournisseur other = (Fournisseur) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + "]";
	}
	

}