package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.FinancementFaciliteFacade;
import entity.FinancementFacilite;
import entity.Utilisateur;

@ManagedBean(name = "financementFaciliteController")
@SessionScoped
public class FinancementFaciliteController implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
    private FinancementFaciliteFacade ejb;
    @Inject FinancementFacilite selected;
    @Inject FinancementFacilite nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public FinancementFacilite getSelected() {
		return selected;
	}

	public void setSelected(FinancementFacilite selected) {
		this.selected = selected;
	}

	public FinancementFacilite getNouveau() {
		return nouveau;
	}

	public void setNouveau(FinancementFacilite nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new FinancementFacilite();
		return "List.xhtml";
	}
	
	public String edit(){
		selected.setStatus("deleted");
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public String remove(){
		ejb.remove(selected);
		return "List.xhtml";
	}
	
	public List<FinancementFacilite> getAll(){
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
