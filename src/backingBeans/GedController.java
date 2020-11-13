package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.GedFacade;
import entity.Ged;
import entity.Utilisateur;

@ManagedBean(name = "gedController")
@SessionScoped
public class GedController implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
    private GedFacade ejb;
    @Inject Ged selected;
    @Inject Ged nouveau;
    
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	
	public Ged getSelected() {
		return selected;
	}

	public void setSelected(Ged selected) {
		session.setAttribute("selected", selected);
		this.selected = selected;
	}

	public Ged getNouveau() {
		return nouveau;
	}

	public void setNouveau(Ged nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		System.out.println("nouveau "+nouveau);
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new Ged();
		return "List.xhtml";
	}
	
	public String edit(){
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public String remove(){
		selected.setStatus("deleted");
		ejb.edit(selected);
		return "Index.xhtml";
	}
	
	public List<Ged> getAll(){
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
