package entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the parametrage database table.
 * 
 */
@Entity
@NamedQuery(name="Parametrage.findAll", query="SELECT p FROM Parametrage p")
public class Parametrage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String commantaire;

	private String designation;

	@Column(name="var_name")
	private String varName;
	
	private String status;
	
	@Column(name = "id_societe")
    private int idSociete;
	
	public Parametrage() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommantaire() {
		return this.commantaire;
	}

	public void setCommantaire(String commantaire) {
		this.commantaire = commantaire;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getVarName() {
		return this.varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public int getIdSociete() {
		return idSociete;
	}

	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}

}