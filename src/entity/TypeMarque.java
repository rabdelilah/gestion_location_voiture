/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "type_marque")
@XmlRootElement
public class TypeMarque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "idTypeMarque")
    private Collection<Vehicule> vehiculeCollection;
    @JoinColumn(name = "id_marque", referencedColumnName = "id")
    @ManyToOne
    private Marque idMarque;
    @OneToMany(mappedBy = "idTypeMarque")
    private Collection<OffreLld> offreLldCollection;
    @OneToMany(mappedBy = "idTypeMarque")
    private Collection<Reservation> reservationCollection;
    @OneToMany(mappedBy = "idTypeMarque")
    private Collection<OffreLcd> offreLcdCollection;
    private String status;
    
    @Column(name = "id_societe")
    private Integer idSociete;
    
    public TypeMarque() {
    }

    public TypeMarque(Integer id) {
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


    @XmlTransient
    public Collection<Vehicule> getVehiculeCollection() {
        return vehiculeCollection;
    }

    public void setVehiculeCollection(Collection<Vehicule> vehiculeCollection) {
        this.vehiculeCollection = vehiculeCollection;
    }

    public Marque getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Marque idMarque) {
        this.idMarque = idMarque;
    }

    public Integer getIdSociete() {
		return idSociete;
	}

	public void setIdSociete(Integer idSociete) {
		this.idSociete = idSociete;
	}

	@XmlTransient
    public Collection<OffreLld> getOffreLldCollection() {
        return offreLldCollection;
    }

    public void setOffreLldCollection(Collection<OffreLld> offreLldCollection) {
        this.offreLldCollection = offreLldCollection;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @XmlTransient
    public Collection<OffreLcd> getOffreLcdCollection() {
        return offreLcdCollection;
    }

    public void setOffreLcdCollection(Collection<OffreLcd> offreLcdCollection) {
        this.offreLcdCollection = offreLcdCollection;
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
        if (!(object instanceof TypeMarque)) {
            return false;
        }
        TypeMarque other = (TypeMarque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "TypeMarque [id=" + id + ", designation=" + designation +  ", idMarque=" + idMarque + "]";
	}
    
}
