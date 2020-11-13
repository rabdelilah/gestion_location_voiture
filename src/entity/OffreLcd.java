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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "offre_lcd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OffreLcd.findAll", query = "SELECT o FROM OffreLcd o"),
    @NamedQuery(name = "OffreLcd.findById", query = "SELECT o FROM OffreLcd o WHERE o.id = :id"),
    @NamedQuery(name = "OffreLcd.findByNumeroOffre", query = "SELECT o FROM OffreLcd o WHERE o.numeroOffre = :numeroOffre"),
    @NamedQuery(name = "OffreLcd.findByDateOffre", query = "SELECT o FROM OffreLcd o WHERE o.dateOffre = :dateOffre"),
    @NamedQuery(name = "OffreLcd.findByDateRemise", query = "SELECT o FROM OffreLcd o WHERE o.dateRemise = :dateRemise"),
    @NamedQuery(name = "OffreLcd.findByDuree", query = "SELECT o FROM OffreLcd o WHERE o.duree = :duree"),
    @NamedQuery(name = "OffreLcd.findByTauxJournalier", query = "SELECT o FROM OffreLcd o WHERE o.tauxJournalier = :tauxJournalier"),
    @NamedQuery(name = "OffreLcd.findByIdSociete", query = "SELECT o FROM OffreLcd o WHERE o.idSociete = :idSociete")})
public class OffreLcd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero_offre")
    private Integer numeroOffre;
    @Column(name = "date_offre")
    @Temporal(TemporalType.DATE)
    private Date dateOffre;
    @Column(name = "date_remise")
    @Temporal(TemporalType.DATE)
    private Date dateRemise;
    @Column(name = "duree")
    private Integer duree;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taux_journalier")
    private Float tauxJournalier;
    @Column(name = "id_societe")
    private Integer idSociete;
    @JoinColumn(name = "id_type_marque", referencedColumnName = "id")
    @ManyToOne
    private TypeMarque idTypeMarque;
    @JoinColumn(name = "id_personnel", referencedColumnName = "id")
    @ManyToOne
    private Personnel idPersonnel;
    @JoinColumn(name = "id_contact", referencedColumnName = "id")
    @ManyToOne
    private Contact idContact;
    private String status;
    
    public OffreLcd() {
    }

    public OffreLcd(Integer id) {
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

    public Integer getNumeroOffre() {
        return numeroOffre;
    }

    public void setNumeroOffre(Integer numeroOffre) {
        this.numeroOffre = numeroOffre;
    }

    public Date getDateOffre() {
        return dateOffre;
    }

    public void setDateOffre(Date dateOffre) {
        this.dateOffre = dateOffre;
    }

    public Date getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(Date dateRemise) {
        this.dateRemise = dateRemise;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Float getTauxJournalier() {
        return tauxJournalier;
    }

    public void setTauxJournalier(Float tauxJournalier) {
        this.tauxJournalier = tauxJournalier;
    }

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    public TypeMarque getIdTypeMarque() {
        return idTypeMarque;
    }

    public void setIdTypeMarque(TypeMarque idTypeMarque) {
        this.idTypeMarque = idTypeMarque;
    }

    public Personnel getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(Personnel idPersonnel) {
        this.idPersonnel = idPersonnel;
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
        if (!(object instanceof OffreLcd)) {
            return false;
        }
        OffreLcd other = (OffreLcd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OffreLcd[ id=" + id + " ]";
    }
    
}
