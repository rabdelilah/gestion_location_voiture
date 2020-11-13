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
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id"),
    @NamedQuery(name = "Reservation.findByNumeroJeton", query = "SELECT r FROM Reservation r WHERE r.numeroJeton = :numeroJeton"),
    @NamedQuery(name = "Reservation.findByTypeLocation", query = "SELECT r FROM Reservation r WHERE r.typeLocation = :typeLocation"),
    @NamedQuery(name = "Reservation.findByTypeCarburant", query = "SELECT r FROM Reservation r WHERE r.typeCarburant = :typeCarburant"),
    @NamedQuery(name = "Reservation.findByModeReservation", query = "SELECT r FROM Reservation r WHERE r.modeReservation = :modeReservation"),
    @NamedQuery(name = "Reservation.findByDateDebutReservation", query = "SELECT r FROM Reservation r WHERE r.dateDebutReservation = :dateDebutReservation"),
    @NamedQuery(name = "Reservation.findByHeureDebutReservation", query = "SELECT r FROM Reservation r WHERE r.heureDebutReservation = :heureDebutReservation"),
    @NamedQuery(name = "Reservation.findByDateFinReservation", query = "SELECT r FROM Reservation r WHERE r.dateFinReservation = :dateFinReservation"),
    @NamedQuery(name = "Reservation.findByHeureFinReservation", query = "SELECT r FROM Reservation r WHERE r.heureFinReservation = :heureFinReservation"),
    @NamedQuery(name = "Reservation.findByDuree", query = "SELECT r FROM Reservation r WHERE r.duree = :duree"),
    @NamedQuery(name = "Reservation.findByStatus", query = "SELECT r FROM Reservation r WHERE r.status = :status"),
    @NamedQuery(name = "Reservation.findByMiseadisposition", query = "SELECT r FROM Reservation r WHERE r.miseadisposition = :miseadisposition"),
    @NamedQuery(name = "Reservation.findByLieuMiseADisposition", query = "SELECT r FROM Reservation r WHERE r.lieuMiseADisposition = :lieuMiseADisposition"),
    @NamedQuery(name = "Reservation.findByVilleMiseADisposition", query = "SELECT r FROM Reservation r WHERE r.villeMiseADisposition = :villeMiseADisposition"),
    @NamedQuery(name = "Reservation.findByMotif", query = "SELECT r FROM Reservation r WHERE r.motif = :motif"),
    @NamedQuery(name = "Reservation.findByCommentaires", query = "SELECT r FROM Reservation r WHERE r.commentaires = :commentaires"),
    @NamedQuery(name = "Reservation.findByIdSociete", query = "SELECT r FROM Reservation r WHERE r.idSociete = :idSociete")})
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero_jeton")
    private Integer numeroJeton;
    @Size(max = 50)
    @Column(name = "type_location")
    private String typeLocation;
    @Size(max = 50)
    @Column(name = "type_carburant")
    private String typeCarburant;
    @Size(max = 50)
    @Column(name = "mode_reservation")
    private String modeReservation;
    @Column(name = "date_debut_reservation")
    @Temporal(TemporalType.DATE)
    private Date dateDebutReservation;
    @Size(max = 50)
    @Column(name = "heure_debut_reservation")
    private String heureDebutReservation;
    @Column(name = "date_fin_reservation")
    @Temporal(TemporalType.DATE)
    private Date dateFinReservation;
    @Size(max = 50)
    @Column(name = "heure_fin_reservation")
    private String heureFinReservation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "duree")
    private Float duree;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @Size(max = 50)
    @Column(name = "Mise_a_disposition")
    private String miseadisposition;
    @Size(max = 50)
    @Column(name = "lieu_mise_a_disposition")
    private String lieuMiseADisposition;
    @Size(max = 50)
    @Column(name = "ville_mise_a_disposition")
    private String villeMiseADisposition;
    @Size(max = 50)
    @Column(name = "Motif")
    private String motif;
    @Size(max = 50)
    @Column(name = "commentaires")
    private String commentaires;
    @Column(name = "id_societe")
    private Integer idSociete;
    @JoinColumn(name = "id_type_marque", referencedColumnName = "id")
    @ManyToOne
    private TypeMarque idTypeMarque;
    @JoinColumn(name = "id_contact", referencedColumnName = "id")
    @ManyToOne
    private Contact idContact;
    
    
    public Reservation() {
    }

    public Reservation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroJeton() {
        return numeroJeton;
    }

    public void setNumeroJeton(Integer numeroJeton) {
        this.numeroJeton = numeroJeton;
    }

    public String getTypeLocation() {
        return typeLocation;
    }

    public void setTypeLocation(String typeLocation) {
        this.typeLocation = typeLocation;
    }

    public String getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(String typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    public String getModeReservation() {
        return modeReservation;
    }

    public void setModeReservation(String modeReservation) {
        this.modeReservation = modeReservation;
    }

    public Date getDateDebutReservation() {
        return dateDebutReservation;
    }

    public void setDateDebutReservation(Date dateDebutReservation) {
        this.dateDebutReservation = dateDebutReservation;
    }

    public String getHeureDebutReservation() {
        return heureDebutReservation;
    }

    public void setHeureDebutReservation(String heureDebutReservation) {
        this.heureDebutReservation = heureDebutReservation;
    }

    public Date getDateFinReservation() {
        return dateFinReservation;
    }

    public void setDateFinReservation(Date dateFinReservation) {
        this.dateFinReservation = dateFinReservation;
    }

    public String getHeureFinReservation() {
        return heureFinReservation;
    }

    public void setHeureFinReservation(String heureFinReservation) {
        this.heureFinReservation = heureFinReservation;
    }

    public Float getDuree() {
        return duree;
    }

    public void setDuree(Float duree) {
        this.duree = duree;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMiseadisposition() {
        return miseadisposition;
    }

    public void setMiseadisposition(String miseadisposition) {
        this.miseadisposition = miseadisposition;
    }

    public String getLieuMiseADisposition() {
        return lieuMiseADisposition;
    }

    public void setLieuMiseADisposition(String lieuMiseADisposition) {
        this.lieuMiseADisposition = lieuMiseADisposition;
    }

    public String getVilleMiseADisposition() {
        return villeMiseADisposition;
    }

    public void setVilleMiseADisposition(String villeMiseADisposition) {
        this.villeMiseADisposition = villeMiseADisposition;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
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
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reservation[ id=" + id + " ]";
    }
    
}
