package entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@Table(name = "article")
@XmlRootElement
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String designation;

	@Column(name="prix_unitaire")
	private double prixUnitaire;

	private String status;

	@Column(name="taux_tva")
	private double tauxTva;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;

	//bi-directional many-to-one association to DetailCmdFr
	@OneToMany(mappedBy="article")
	private List<DetailCmdFr> detailCmdFrs;

	 @Column(name = "id_societe")
	 private Integer idSociete;
	   public Integer getIdSociete() {
	        return idSociete;
	    }

	 public void setIdSociete(Integer idSociete) {
	        this.idSociete = idSociete;
	    }
	public Article() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTauxTva() {
		return this.tauxTva;
	}

	public void setTauxTva(double tauxTva) {
		this.tauxTva = tauxTva;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<DetailCmdFr> getDetailCmdFrs() {
		return this.detailCmdFrs;
	}

	public void setDetailCmdFrs(List<DetailCmdFr> detailCmdFrs) {
		this.detailCmdFrs = detailCmdFrs;
	}

	public DetailCmdFr addDetailCmdFr(DetailCmdFr detailCmdFr) {
		getDetailCmdFrs().add(detailCmdFr);
		detailCmdFr.setArticle(this);

		return detailCmdFr;
	}

	public DetailCmdFr removeDetailCmdFr(DetailCmdFr detailCmdFr) {
		getDetailCmdFrs().remove(detailCmdFr);
		detailCmdFr.setArticle(null);

		return detailCmdFr;
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
		Article other = (Article) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + "]";
	}

}