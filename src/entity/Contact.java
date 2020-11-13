/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findById", query = "SELECT c FROM Contact c WHERE c.id = :id"),
    @NamedQuery(name = "Contact.findByEtat", query = "SELECT c FROM Contact c WHERE c.etat = :etat"),
    @NamedQuery(name = "Contact.findByType", query = "SELECT c FROM Contact c WHERE c.type = :type"),
    @NamedQuery(name = "Contact.findByCin", query = "SELECT c FROM Contact c WHERE c.cin = :cin"),
    @NamedQuery(name = "Contact.findByRaisonsociale", query = "SELECT c FROM Contact c WHERE c.raisonsociale = :raisonsociale"),
    @NamedQuery(name = "Contact.findByNom", query = "SELECT c FROM Contact c WHERE c.nom = :nom"),
    @NamedQuery(name = "Contact.findByPrenom", query = "SELECT c FROM Contact c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Contact.findByNumpermispasseport", query = "SELECT c FROM Contact c WHERE c.numpermispasseport = :numpermispasseport"),
    @NamedQuery(name = "Contact.findByDateEmission", query = "SELECT c FROM Contact c WHERE c.dateEmission = :dateEmission"),
    @NamedQuery(name = "Contact.findByLieuEmission", query = "SELECT c FROM Contact c WHERE c.lieuEmission = :lieuEmission"),
    @NamedQuery(name = "Contact.findByTypeContact", query = "SELECT c FROM Contact c WHERE c.typeContact = :typeContact"),
    @NamedQuery(name = "Contact.findByTypePiece", query = "SELECT c FROM Contact c WHERE c.typePiece = :typePiece"),
    @NamedQuery(name = "Contact.findByAdresse", query = "SELECT c FROM Contact c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Contact.findByNationalite", query = "SELECT c FROM Contact c WHERE c.nationalite = :nationalite"),
    @NamedQuery(name = "Contact.findByRc", query = "SELECT c FROM Contact c WHERE c.rc = :rc"),
    @NamedQuery(name = "Contact.findByNcnss", query = "SELECT c FROM Contact c WHERE c.ncnss = :ncnss"),
    @NamedQuery(name = "Contact.findByPatente", query = "SELECT c FROM Contact c WHERE c.patente = :patente"),
    @NamedQuery(name = "Contact.findByContact", query = "SELECT c FROM Contact c WHERE c.contact = :contact"),
    @NamedQuery(name = "Contact.findByEmail", query = "SELECT c FROM Contact c WHERE c.email = :email"),
    @NamedQuery(name = "Contact.findByFax", query = "SELECT c FROM Contact c WHERE c.fax = :fax"),
    @NamedQuery(name = "Contact.findByIdSociete", query = "SELECT c FROM Contact c WHERE c.idSociete = :idSociete")})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "etat")
    private String etat;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @Size(max = 50)
    @Column(name = "cin")
    private String cin;
    @Size(max = 50)
    @Column(name = "Raison_sociale")
    private String raisonsociale;
    @Size(max = 50)
    @Column(name = "nom")
    private String nom;
    @Size(max = 50)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 50)
    @Column(name = "Num_permis_passeport")
    private String numpermispasseport;
    @Column(name = "date_emission")
    @Temporal(TemporalType.DATE)
    private Date dateEmission;
    @Size(max = 50)
    @Column(name = "lieu_emission")
    private String lieuEmission;
    @Size(max = 50)
    @Column(name = "type_contact")
    private String typeContact;
    @Size(max = 50)
    @Column(name = "type_piece")
    private String typePiece;
    @Size(max = 50)
    @Column(name = "tel")
    private String tel;
    @Size(max = 50)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 50)
    @Column(name = "nationalite")
    private String nationalite;
    @Size(max = 50)
    @Column(name = "RC")
    private String rc;
    @Size(max = 50)
    @Column(name = "NCNSS")
    private String ncnss;
    @Size(max = 50)
    @Column(name = "patente")
    private String patente;
    @Size(max = 50)
    @Column(name = "contact")
    private String contact;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "fax")
    private String fax;
    @Column(name = "id_societe")
    private Integer idSociete;
    @OneToMany(mappedBy = "idContact")
    private Collection<ContratLcd> contratLcdCollection;
    @OneToMany(mappedBy = "idConducteur")
    private Collection<ContratLcd> contratLcdCollection1;
    @OneToMany(mappedBy = "idLocataire")
    private Collection<ContratLcd> contratLcdCollection2;
    @OneToMany(mappedBy = "idContact")
    private Collection<OffreLld> offreLldCollection;
    @JoinColumn(name = "id_personnel", referencedColumnName = "id")
    @ManyToOne
    private Personnel idPersonnel;
    @OneToMany(mappedBy = "idLocataire")
    private Collection<ContratLld> contratLldCollection;
    @OneToMany(mappedBy = "idContact")
    private Collection<ContratLld> contratLldCollection1;
    @OneToMany(mappedBy = "idContact")
    private Collection<Reservation> reservationCollection;
    @OneToMany(mappedBy = "idContact")
    private Collection<OffreLcd> offreLcdCollection;
    
    private String status;
    
    public Contact() {
    }

    public Contact(Integer id) {
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getRaisonsociale() {
        return raisonsociale;
    }

    public void setRaisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumpermispasseport() {
        return numpermispasseport;
    }

    public void setNumpermispasseport(String numpermispasseport) {
        this.numpermispasseport = numpermispasseport;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public String getLieuEmission() {
        return lieuEmission;
    }

    public void setLieuEmission(String lieuEmission) {
        this.lieuEmission = lieuEmission;
    }

    public String getTypeContact() {
        return typeContact;
    }

    public void setTypeContact(String typeContact) {
        this.typeContact = typeContact;
    }

    public String getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(String typePiece) {
        this.typePiece = typePiece;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getNcnss() {
        return ncnss;
    }

    public void setNcnss(String ncnss) {
        this.ncnss = ncnss;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    @XmlTransient
    public Collection<ContratLcd> getContratLcdCollection() {
        return contratLcdCollection;
    }

    public void setContratLcdCollection(Collection<ContratLcd> contratLcdCollection) {
        this.contratLcdCollection = contratLcdCollection;
    }

    @XmlTransient
    public Collection<ContratLcd> getContratLcdCollection1() {
        return contratLcdCollection1;
    }

    public void setContratLcdCollection1(Collection<ContratLcd> contratLcdCollection1) {
        this.contratLcdCollection1 = contratLcdCollection1;
    }

    @XmlTransient
    public Collection<ContratLcd> getContratLcdCollection2() {
        return contratLcdCollection2;
    }

    public void setContratLcdCollection2(Collection<ContratLcd> contratLcdCollection2) {
        this.contratLcdCollection2 = contratLcdCollection2;
    }

    @XmlTransient
    public Collection<OffreLld> getOffreLldCollection() {
        return offreLldCollection;
    }

    public void setOffreLldCollection(Collection<OffreLld> offreLldCollection) {
        this.offreLldCollection = offreLldCollection;
    }

    public Personnel getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(Personnel idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @XmlTransient
    public Collection<ContratLld> getContratLldCollection() {
        return contratLldCollection;
    }

    public void setContratLldCollection(Collection<ContratLld> contratLldCollection) {
        this.contratLldCollection = contratLldCollection;
    }

    @XmlTransient
    public Collection<ContratLld> getContratLldCollection1() {
        return contratLldCollection1;
    }

    public void setContratLldCollection1(Collection<ContratLld> contratLldCollection1) {
        this.contratLldCollection1 = contratLldCollection1;
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
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Contact[ id=" + id + " ]";
    }
    
}
