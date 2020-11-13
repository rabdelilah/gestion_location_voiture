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
 * @author hasnaa
 */
@Entity
@Table(name = "type_garantie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeGarantie.findAll", query = "SELECT t FROM TypeGarantie t"),
    @NamedQuery(name = "TypeGarantie.findById", query = "SELECT t FROM TypeGarantie t WHERE t.id = :id"),
    @NamedQuery(name = "TypeGarantie.findByDesignation", query = "SELECT t FROM TypeGarantie t WHERE t.designation = :designation")})
public class TypeGarantie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 50)
    @Column(name = "designation")
    private String designation;
    private String status;
    @Column(name = "id_societe")
    private int idSociete;
    
    public TypeGarantie() {
    }

    public TypeGarantie(Integer id) {
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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
        if (!(object instanceof TypeGarantie)) {
            return false;
        }
        TypeGarantie other = (TypeGarantie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TypeGarantie[ id=" + id + " ]";
    }
    
}
