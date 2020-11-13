package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.PersonnelFacade;
import entity.Personnel;
import entity.Utilisateur;

@ManagedBean(name = "personnelController")
@SessionScoped
public class PersonnelController implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
    private PersonnelFacade ejb;
    @Inject Personnel selected;
    @Inject Personnel nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public Personnel getSelected() {
		return selected;
	}

	public void setSelected(Personnel selected) {
		this.selected = selected;
	}

	public Personnel getNouveau() {
		return nouveau;
	}

	public void setNouveau(Personnel nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new Personnel();
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
	public List<Personnel> getAll(){
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
