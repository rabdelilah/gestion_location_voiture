package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.OffreLcdFacade;
import entity.OffreLcd;
import entity.Utilisateur;

@ManagedBean(name = "offreLcdController")
@SessionScoped
public class OffreLcdController implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
    private OffreLcdFacade ejb;
    @Inject OffreLcd selected;
    @Inject OffreLcd nouveau;
    
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public OffreLcd getSelected() {
		return selected;
	}

	public void setSelected(OffreLcd selected) {
		this.selected = selected;
	}

	public OffreLcd getNouveau() {
		return nouveau;
	}

	public void setNouveau(OffreLcd nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new OffreLcd();
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
	
	public List<OffreLcd> getAll(){
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
