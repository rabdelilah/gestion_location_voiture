/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "financement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Financement.findAll", query = "SELECT f FROM Financement f"),
    @NamedQuery(name = "Financement.findById", query = "SELECT f FROM Financement f WHERE f.id = :id"),
    @NamedQuery(name = "Financement.findByOrganismeLeasing", query = "SELECT f FROM Financement f WHERE f.organismeLeasing = :organismeLeasing"),
    @NamedQuery(name = "Financement.findByDate1ereMensualite", query = "SELECT f FROM Financement f WHERE f.date1ereMensualite = :date1ereMensualite"),
    @NamedQuery(name = "Financement.findByNbreMensualite", query = "SELECT f FROM Financement f WHERE f.nbreMensualite = :nbreMensualite"),
    @NamedQuery(name = "Financement.findByMntMensualite", query = "SELECT f FROM Financement f WHERE f.mntMensualite = :mntMensualite"),
    @NamedQuery(name = "Financement.findByValeurResiduelle", query = "SELECT f FROM Financement f WHERE f.valeurResiduelle = :valeurResiduelle"),
    @NamedQuery(name = "Financement.findByIdSociete", query = "SELECT f FROM Financement f WHERE f.idSociete = :idSociete")})
public class Financement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "organisme_leasing")
    private String organismeLeasing;
    @Column(name = "date_1ere_mensualite")
    @Temporal(TemporalType.DATE)
    private Date date1ereMensualite;
    @Column(name = "nbre_mensualite")
    private Integer nbreMensualite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mnt_mensualite")
    private Float mntMensualite;
    @Column(name = "valeur_residuelle")
    private Float valeurResiduelle;
    @Column(name = "id_societe")
    private Integer idSociete;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id")
    @ManyToOne
    private Vehicule idVehicule;

    private String status;
    
    public Financement() {
    }

    public Financement(Integer id) {
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

    public String getOrganismeLeasing() {
        return organismeLeasing;
    }

    public void setOrganismeLeasing(String organismeLeasing) {
        this.organismeLeasing = organismeLeasing;
    }

    public Date getDate1ereMensualite() {
        return date1ereMensualite;
    }

    public void setDate1ereMensualite(Date date1ereMensualite) {
        this.date1ereMensualite = date1ereMensualite;
    }

    public Integer getNbreMensualite() {
        return nbreMensualite;
    }

    public void setNbreMensualite(Integer nbreMensualite) {
        this.nbreMensualite = nbreMensualite;
    }

    public Float getMntMensualite() {
        return mntMensualite;
    }

    public void setMntMensualite(Float mntMensualite) {
        this.mntMensualite = mntMensualite;
    }

    public Float getValeurResiduelle() {
        return valeurResiduelle;
    }

    public void setValeurResiduelle(Float valeurResiduelle) {
        this.valeurResiduelle = valeurResiduelle;
    }

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
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
        if (!(object instanceof Financement)) {
            return false;
        }
        Financement other = (Financement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Financement[ id=" + id + " ]";
    }
    
}
