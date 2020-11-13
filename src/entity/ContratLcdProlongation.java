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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "contrat_lcd_prolongation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContratLcdProlongation.findAll", query = "SELECT c FROM ContratLcdProlongation c"),
    @NamedQuery(name = "ContratLcdProlongation.findById", query = "SELECT c FROM ContratLcdProlongation c WHERE c.id = :id"),
    @NamedQuery(name = "ContratLcdProlongation.findByOrdre", query = "SELECT c FROM ContratLcdProlongation c WHERE c.ordre = :ordre"),
    @NamedQuery(name = "ContratLcdProlongation.findByNombreJours", query = "SELECT c FROM ContratLcdProlongation c WHERE c.nombreJours = :nombreJours")})
public class ContratLcdProlongation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ordre")
    private Integer ordre;
    @Column(name = "nombre_jours")
    private Integer nombreJours;
    @JoinColumn(name = "id_contrat", referencedColumnName = "id")
    @ManyToOne
    private ContratLcd idContrat;
    
    private String status;
    
    @Column(name = "id_societe")
    private int idSociete; 
    
    public ContratLcdProlongation() {
    }

    public ContratLcdProlongation(Integer id) {
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

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

    public Integer getNombreJours() {
        return nombreJours;
    }

    public void setNombreJours(Integer nombreJours) {
        this.nombreJours = nombreJours;
    }

    public ContratLcd getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(ContratLcd idContrat) {
        this.idContrat = idContrat;
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
        if (!(object instanceof ContratLcdProlongation)) {
            return false;
        }
        ContratLcdProlongation other = (ContratLcdProlongation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ContratLcdProlongation[ id=" + id + " ]";
    }
    
}
