package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.MarqueFacade;
import entity.Marque;
import entity.Utilisateur;

@ManagedBean(name = "marqueController")
@SessionScoped
public class MarqueController  implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB
    private MarqueFacade ejb;
    @Inject Marque selected;
    @Inject Marque nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public Marque getSelected() {
		return selected;
	}

	public void setSelected(Marque selected) {
		this.selected = selected;
	}

	public Marque getNouveau() {
		return nouveau;
	}

	public void setNouveau(Marque nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new Marque();
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
	
	public List<Marque> getAll(){
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
