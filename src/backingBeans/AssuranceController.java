package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.AssuranceFacade;
import entity.Assurance;
import entity.Utilisateur;

@ManagedBean(name="assuranceController")
@SessionScoped
public class AssuranceController implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB AssuranceFacade ejb;
	@Inject Assurance selected;
	@Inject Assurance nouveau;
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
	public Assurance getSelected() {
		return selected;
	}

	public void setSelected(Assurance selected) {
		this.selected = selected;
	}

	public Assurance getNouveau() {
		return nouveau;
	}

	public void setNouveau(Assurance nouveau) {
		this.nouveau = nouveau;
	}

	public String add() {
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau = new Assurance();
		return "List.xhtml";
	}

	public String edit() {
		ejb.edit(selected);
		return "List.xhtml";
	}

	public String remove() {
		selected.setStatus("deleted");
		ejb.edit(selected);
		return "List.xhtml";
	}

	public List<Assurance> getAll() {
		return ejb.getAllActif();
	}
	
	public List<String> getDuree(){
		return ejb.paramDesin("duree");
	}
	
	public String toAdd() {
		return "Create.xhtml";
	}

	public String toEdit() {
		return "Edit.xhtml";
	}

	public String toList() {
		return "List.xhtml";
	}

	public String toShow() {
		return "View.xhtml";
	}
}
