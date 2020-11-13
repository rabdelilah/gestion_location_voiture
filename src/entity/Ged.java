/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ged")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ged.findAll", query = "SELECT g FROM Ged g"),
    @NamedQuery(name = "Ged.findById", query = "SELECT g FROM Ged g WHERE g.id = :id"),
    @NamedQuery(name = "Ged.findByChemin", query = "SELECT g FROM Ged g WHERE g.chemin = :chemin"),
    @NamedQuery(name = "Ged.findByType", query = "SELECT g FROM Ged g WHERE g.type = :type"),
    @NamedQuery(name = "Ged.findByIdCleEtrangere", query = "SELECT g FROM Ged g WHERE g.idCleEtrangere = :idCleEtrangere"),
    @NamedQuery(name = "Ged.findByNomTable", query = "SELECT g FROM Ged g WHERE g.nomTable = :nomTable")})
public class Ged implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "chemin")
    private String chemin;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @Column(name = "id_cle_etrangere")
    private Integer idCleEtrangere;
    @Size(max = 50)
    @Column(name = "nom_table")
    private String nomTable;
    @Column(name = "id_societe")
    private int idSociete;
    
    private String status;
    
    public Ged() {
    }

    public Ged(Integer id) {
        this.id = id;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIdCleEtrangere() {
        return idCleEtrangere;
    }

    public void setIdCleEtrangere(Integer idCleEtrangere) {
        this.idCleEtrangere = idCleEtrangere;
    }

    public String getNomTable() {
        return nomTable;
    }

    public void setNomTable(String nomTable) {
        this.nomTable = nomTable;
    }

    public int getIdSociete() {
		return idSociete;
	}

	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ged)) {
            return false;
        }
        Ged other = (Ged) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ged[ id=" + id + " ]";
    }
    
}
