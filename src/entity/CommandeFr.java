package entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commande_frs database table.
 * 
 */
@Entity
@Table(name="commande_frs")
@XmlRootElement
@NamedQuery(name="CommandeFr.findAll", query="SELECT c FROM CommandeFr c")
public class CommandeFr implements Serializable,Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_cmd")
	private Date dateCmd;

	@Temporal(TemporalType.DATE)
	@Column(name="date_prevue_livr")
	private Date datePrevueLivr;

	@Column(name="modalites_paiements")
	private String modalitesPaiements;

	@Column(name="num_cmd")
	private String numCmd;

	private String observation;

	private String status;

	//bi-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name="id_frs")
	private Fournisseur fournisseur;

	//bi-directional many-to-one association to ContactFr
	@ManyToOne
	@JoinColumn(name="id_contact_frs")
	private ContactFr contactFr;

	//bi-directional many-to-one association to DetailCmdFr
	@OneToMany(mappedBy="commandeFr")
	private List<DetailCmdFr> detailCmdFrs;

	 @Column(name = "id_societe")
	 private Integer idSociete;
	   public Integer getIdSociete() {
	        return idSociete;
	    }

	 public void setIdSociete(Integer idSociete) {
	        this.idSociete = idSociete;
	    }
	 
	public CommandeFr() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCmd() {
		return this.dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public Date getDatePrevueLivr() {
		return this.datePrevueLivr;
	}

	public void setDatePrevueLivr(Date datePrevueLivr) {
		this.datePrevueLivr = datePrevueLivr;
	}

	public String getModalitesPaiements() {
		return this.modalitesPaiements;
	}

	public void setModalitesPaiements(String modalitesPaiements) {
		this.modalitesPaiements = modalitesPaiements;
	}

	public String getNumCmd() {
		return this.numCmd;
	}

	public void setNumCmd(String numCmd) {
		this.numCmd = numCmd;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public ContactFr getContactFr() {
		return this.contactFr;
	}

	public void setContactFr(ContactFr contactFr) {
		this.contactFr = contactFr;
	}

	public List<DetailCmdFr> getDetailCmdFrs() {
		return this.detailCmdFrs;
	}

	public void setDetailCmdFrs(List<DetailCmdFr> detailCmdFrs) {
		this.detailCmdFrs = detailCmdFrs;
	}

	public DetailCmdFr addDetailCmdFr(DetailCmdFr detailCmdFr) {
		getDetailCmdFrs().add(detailCmdFr);
		detailCmdFr.setCommandeFr(this);

		return detailCmdFr;
	}

	public DetailCmdFr removeDetailCmdFr(DetailCmdFr detailCmdFr) {
		getDetailCmdFrs().remove(detailCmdFr);
		detailCmdFr.setCommandeFr(null);

		return detailCmdFr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandeFr other = (CommandeFr) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommandeFr [id=" + id + "]";
	}
	
	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace(System.err);
		}
		return o;
	}
}