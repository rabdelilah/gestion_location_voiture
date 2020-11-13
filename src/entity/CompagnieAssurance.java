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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hasnaa
 */
@Entity
@Table(name = "compagnie_assurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompagnieAssurance.findAll", query = "SELECT c FROM CompagnieAssurance c"),
    @NamedQuery(name = "CompagnieAssurance.findById", query = "SELECT c FROM CompagnieAssurance c WHERE c.id = :id"),
    @NamedQuery(name = "CompagnieAssurance.findByRaisonsociale", query = "SELECT c FROM CompagnieAssurance c WHERE c.raisonsociale = :raisonsociale"),
    @NamedQuery(name = "CompagnieAssurance.findByAdresse", query = "SELECT c FROM CompagnieAssurance c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "CompagnieAssurance.findByTel", query = "SELECT c FROM CompagnieAssurance c WHERE c.tel = :tel"),
    @NamedQuery(name = "CompagnieAssurance.findByFax", query = "SELECT c FROM CompagnieAssurance c WHERE c.fax = :fax"),
    @NamedQuery(name = "CompagnieAssurance.findByEmail", query = "SELECT c FROM CompagnieAssurance c WHERE c.email = :email"),
    @NamedQuery(name = "CompagnieAssurance.findByIdentifiantFiscal", query = "SELECT c FROM CompagnieAssurance c WHERE c.identifiantFiscal = :identifiantFiscal"),
    @NamedQuery(name = "CompagnieAssurance.findByRegistreCommerce", query = "SELECT c FROM CompagnieAssurance c WHERE c.registreCommerce = :registreCommerce"),
    @NamedQuery(name = "CompagnieAssurance.findByNcnss", query = "SELECT c FROM CompagnieAssurance c WHERE c.ncnss = :ncnss"),
    @NamedQuery(name = "CompagnieAssurance.findByPatente", query = "SELECT c FROM CompagnieAssurance c WHERE c.patente = :patente"),
    @NamedQuery(name = "CompagnieAssurance.findByContact", query = "SELECT c FROM CompagnieAssurance c WHERE c.contact = :contact"),
    @NamedQuery(name = "CompagnieAssurance.findByIdSociete", query = "SELECT c FROM CompagnieAssurance c WHERE c.idSociete = :idSociete")})
public class CompagnieAssurance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "Raison_sociale")
    private String raisonsociale;
    @Size(max = 50)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 50)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "fax")
    private String fax;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "identifiant_fiscal")
    private String identifiantFiscal;
    @Size(max = 50)
    @Column(name = "registre_commerce")
    private String registreCommerce;
    @Size(max = 50)
    @Column(name = "NCNSS")
    private String ncnss;
    @Size(max = 50)
    @Column(name = "patente")
    private String patente;
    @Size(max = 50)
    @Column(name = "contact")
    private String contact;
    @Column(name = "id_societe")
    private Integer idSociete;
    @OneToMany(mappedBy = "idCompagnieAssurance")
    private Collection<Assurance> assuranceCollection;

    private String status;
    
    public CompagnieAssurance() {
    }

    public CompagnieAssurance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaisonsociale() {
        return raisonsociale;
    }

    public void setRaisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentifiantFiscal() {
        return identifiantFiscal;
    }

    public void setIdentifiantFiscal(String identifiantFiscal) {
        this.identifiantFiscal = identifiantFiscal;
    }

    public String getRegistreCommerce() {
        return registreCommerce;
    }

    public void setRegistreCommerce(String registreCommerce) {
        this.registreCommerce = registreCommerce;
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

    public Integer getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Integer idSociete) {
        this.idSociete = idSociete;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlTransient
    public Collection<Assurance> getAssuranceCollection() {
        return assuranceCollection;
    }

    public void setAssuranceCollection(Collection<Assurance> assuranceCollection) {
        this.assuranceCollection = assuranceCollection;
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
        if (!(object instanceof CompagnieAssurance)) {
            return false;
        }
        CompagnieAssurance other = (CompagnieAssurance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return raisonsociale;
    }
    
}
