package entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the detail_cmd_frs database table.
 * 
 */
@Entity
@Table(name="detail_cmd_frs")
@XmlRootElement
@NamedQuery(name="DetailCmdFr.findAll", query="SELECT d FROM DetailCmdFr d")
public class DetailCmdFr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="prix_unitaire")
	private double prixUnitaire;

	private int quantite;

	private String status;

	//bi-directional many-to-one association to CommandeFr
	@ManyToOne
	@JoinColumn(name="id_cmd_frs")
	private CommandeFr commandeFr;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="id_article")
	private Article article;

	 @Column(name = "id_societe")
	 private Integer idSociete;
	   public Integer getIdSociete() {
	        return idSociete;
	    }

	 public void setIdSociete(Integer idSociete) {
	        this.idSociete = idSociete;
	    }
	public DetailCmdFr() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrixUnitaire() {
		return this.prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CommandeFr getCommandeFr() {
		return this.commandeFr;
	}

	public void setCommandeFr(CommandeFr commandeFr) {
		this.commandeFr = commandeFr;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
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
		DetailCmdFr other = (DetailCmdFr) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetailCmdFr [id=" + id + "]";
	}

}