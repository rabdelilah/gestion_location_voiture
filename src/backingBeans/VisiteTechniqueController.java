package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.VisiteTechniqueFacade;
import entity.Utilisateur;
import entity.VisiteTechnique;

@ManagedBean(name = "visiteTechniqueController")
@SessionScoped
public class VisiteTechniqueController implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
    private VisiteTechniqueFacade ejb;
    @Inject VisiteTechnique selected;
    @Inject VisiteTechnique nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

	public VisiteTechnique getSelected() {
		return selected;
	}

	public void setSelected(VisiteTechnique selected) {
		this.selected = selected;
	}

	public VisiteTechnique getNouveau() {
		return nouveau;
	}

	public void setNouveau(VisiteTechnique nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new VisiteTechnique();
		return "List.xhtml";
	}
	
	public String edit(){
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public String remove(){
		selected.setStatut("deleted");
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public List<VisiteTechnique> getAll(){
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
