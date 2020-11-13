package entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@Table(name = "produit")
@XmlRootElement
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String designation;

	private String gamme;

	private String marque;

	private String status;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="produit")
	private List<Article> articles;

	//bi-directional many-to-one association to ProduitFr
	@OneToMany(mappedBy="produit")
	private List<ProduitFr> produitFrs;

	 @Column(name = "id_societe")
	 private Integer idSociete;
	   public Integer getIdSociete() {
	        return idSociete;
	    }

	 public void setIdSociete(Integer idSociete) {
	        this.idSociete = idSociete;
	    }
	 
	public Produit() {
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

	public String getGamme() {
		return this.gamme;
	}

	public void setGamme(String gamme) {
		this.gamme = gamme;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setProduit(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setProduit(null);

		return article;
	}

	public List<ProduitFr> getProduitFrs() {
		return this.produitFrs;
	}

	public void setProduitFrs(List<ProduitFr> produitFrs) {
		this.produitFrs = produitFrs;
	}

	public ProduitFr addProduitFr(ProduitFr produitFr) {
		getProduitFrs().add(produitFr);
		produitFr.setProduit(this);

		return produitFr;
	}

	public ProduitFr removeProduitFr(ProduitFr produitFr) {
		getProduitFrs().remove(produitFr);
		produitFr.setProduit(null);

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
		Produit other = (Produit) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + "]";
	}

}