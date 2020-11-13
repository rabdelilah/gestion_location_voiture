package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.PaiementVehiculeFacade;
import entity.PaiementVehicule;
import entity.Utilisateur;

@ManagedBean(name = "paiementVehiculeController")
@SessionScoped
public class PaiementVehiculeController implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
    private PaiementVehiculeFacade ejb;
    @Inject PaiementVehicule selected;
    @Inject PaiementVehicule nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public PaiementVehicule getSelected() {
		return selected;
	}

	public void setSelected(PaiementVehicule selected) {
		this.selected = selected;
	}

	public PaiementVehicule getNouveau() {
		return nouveau;
	}

	public void setNouveau(PaiementVehicule nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new PaiementVehicule();
		return "List.xhtml";
	}
	
	public String edit(){
		System.out.println("edit "+selected);
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public String remove(){
		System.out.println("delete "+selected);
		selected.setStatus("deleted");
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public List<PaiementVehicule> getAll(){
		return ejb.getAllActif();
	}
	
	public List<String> getNaturePaiement(){
		return ejb.paramDesin("nature_paiement");
	}
	
	public String toAdd(){
		return "Create.xhtml";
	}
	public String toEdit(){
		return "Edit.xhtml";
	}
	public String toList(){
		return "List.xhtml";
	}
	public String toShow(){
		return "View.xhtml";
	}
}
