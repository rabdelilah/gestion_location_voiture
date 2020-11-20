package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import sessionBeans.CompagnieAssuranceFacade;
import entity.CompagnieAssurance;
import entity.Utilisateur;

@Named("compagnieAssuranceController")
@SessionScoped
public class CompagnieAssuranceController implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
    private CompagnieAssuranceFacade ejb;
    @Inject CompagnieAssurance selected;
    @Inject CompagnieAssurance nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public CompagnieAssurance getSelected() {
		return selected;
	}

	public void setSelected(CompagnieAssurance selected) {
		this.selected = selected;
	}

	public CompagnieAssurance getNouveau() {
		return nouveau;
	}

	public void setNouveau(CompagnieAssurance nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new CompagnieAssurance();
		return "List.xhtml";
	}
	
	public String edit(){
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public String remove(){
		selected.setStatus("deleted");
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public List<CompagnieAssurance> getAll(){
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
