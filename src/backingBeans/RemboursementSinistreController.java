package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.RemboursementSinistreFacade;
import entity.RemboursementSinistre;
import entity.Utilisateur;

@ManagedBean(name = "remboursementSinistreController")
@SessionScoped
public class RemboursementSinistreController implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB
    private RemboursementSinistreFacade ejb;
    @Inject RemboursementSinistre selected;
    @Inject RemboursementSinistre nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public RemboursementSinistre getSelected() {
		return selected;
	}

	public void setSelected(RemboursementSinistre selected) {
		this.selected = selected;
	}

	public RemboursementSinistre getNouveau() {
		return nouveau;
	}

	public void setNouveau(RemboursementSinistre nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		System.out.println("nouveau "+nouveau);
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new RemboursementSinistre();
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
	
	public List<RemboursementSinistre> getAll(){
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
