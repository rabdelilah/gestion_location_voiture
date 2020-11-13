/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "contrat_lld")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContratLld.findAll", query = "SELECT c FROM ContratLld c"),
    @NamedQuery(name = "ContratLld.findById", query = "SELECT c FROM ContratLld c WHERE c.id = :id"),
    @NamedQuery(name = "ContratLld.findByNumeroContrat", query = "SELECT c FROM ContratLld c WHERE c.numeroContrat = :numeroContrat"),
    @NamedQuery(name = "ContratLld.findByDateContrat", query = "SELECT c FROM ContratLld c WHERE c.dateContrat = :dateContrat"),
    @NamedQuery(name = "ContratLld.findByLieuLivraison", query = "SELECT c FROM ContratLld c WHERE c.lieuLivraison = :lieuLivraison"),
    @NamedQuery(name = "ContratLld.findByDate1ereMensualite", query = "SELECT c FROM ContratLld c WHERE c.date1ereMensualite = :date1ereMensualite"),
    @NamedQuery(name = "ContratLld.findByNbreMensualite", query = "SELECT c FROM ContratLld c WHERE c.nbreMensualite = :nbreMensualite"),
    @NamedQuery(name = "ContratLld.findByMntMensualite", query = "SELECT c FROM ContratLld c WHERE c.mntMensualite = :mntMensualite"),
    @NamedQuery(name = "ContratLld.findByIdSociete", query = "SELECT c FROM ContratLld c WHERE c.idSociete = :idSociete")})
public class ContratLld implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "numero_contrat")
    private String numeroContrat;
    @Column(name = "date_contrat")
    @Temporal(TemporalType.DATE)
    private Date dateContrat;
    @Size(max = 50)
    @Column(name = "lieu_livraison")
    private String lieuLivraison;
    @Column(name = "date_1ere_mensualite")
    @Temporal(TemporalType.DATE)
    private Date date1ereMensualite;
    @Column(name = "nbre_mensualite")
    private Integer nbreMensualite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mnt_mensualite")
    private Float mntMensualite;
    @Column(name = "id_societe")
    private Integer idSociete;
    @JoinColumn(name = "id_locataire", referencedColumnName = "id")
    @ManyToOne
    private Contact idLocataire;
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id")
    @ManyToOne
    private Vehicule idVehicule;
    @JoinColumn(name = "id_contact", referencedColumnName = "id")
    @ManyToOne
    private Contact idContact;

    private String status;
    
    public ContratLld() {
    }

    public ContratLld(Integer id) {
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

    public String getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(String numeroContrat) {
        this.numeroContrat = numeroContrat;
    }

    public Date getDateContrat() {
        return dateContrat;
    }

    public void setDateContrat(Date dateContrat) {
        this.dateContrat = dateContrat;
    }

    public String getLieuLivraison() {
        return lieuLivraison;
    }

    public void setLieuLivraison(String lieuLivraison) {
        this.lieuLivraison = lieuLivraison;
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

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    public Contact getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(Contact idLocataire) {
        this.idLocataire = idLocataire;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Contact getIdContact() {
        return idContact;
    }

    public void setIdContact(Contact idContact) {
        this.idContact = idContact;
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
        if (!(object instanceof ContratLld)) {
            return false;
        }
        ContratLld other = (ContratLld) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ContratLld[ id=" + id + " ]";
    }
    
}
