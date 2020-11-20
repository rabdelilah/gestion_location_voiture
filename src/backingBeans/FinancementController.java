package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.FinancementFacade;
import entity.Financement;
import entity.Utilisateur;

@ManagedBean(name = "financementController")
@SessionScoped
public class FinancementController implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
    private FinancementFacade ejb;
    @Inject Financement selected;
    @Inject Financement nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	
	public Financement getSelected() {
		return selected;
	}

	public void setSelected(Financement selected) {
		this.selected = selected;
	}

	public Financement getNouveau() {
		return nouveau;
	}

	public void setNouveau(Financement nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new Financement();
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
	
	public List<Financement> getAll(){
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
