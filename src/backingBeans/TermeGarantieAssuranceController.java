package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.TermeGarantieAssuranceFacade;
import entity.TermeGarantieAssurance;
import entity.Utilisateur;

@ManagedBean(name="termeGarantieAssuranceController")
@javax.faces.bean.SessionScoped
public class TermeGarantieAssuranceController implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
    private TermeGarantieAssuranceFacade ejb;
    @Inject TermeGarantieAssurance selected;
    @Inject TermeGarantieAssurance nouveau;
    
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public TermeGarantieAssurance getSelected() {
		return selected;
	}

	public void setSelected(TermeGarantieAssurance selected) {
		this.selected = selected;
	}

	public TermeGarantieAssurance getNouveau() {
		return nouveau;
	}

	public void setNouveau(TermeGarantieAssurance nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		System.out.println("nouveau "+nouveau);
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new TermeGarantieAssurance();
		return "List.xhtml";
	}
	
	public String edit(){
		System.out.println("edit "+selected);
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public String remove(){
		System.out.println("remove "+selected);
		selected.setStatus("deleted");
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public List<TermeGarantieAssurance> getAll(){
		return ejb.getAllActif();
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
