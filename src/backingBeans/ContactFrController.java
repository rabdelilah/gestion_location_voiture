package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.ContactFrFacade;
import entity.ContactFr;
import entity.Utilisateur;
@ManagedBean(name = "contactFrController")
@SessionScoped
public class ContactFrController implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB
    private ContactFrFacade ejb;
    @Inject ContactFr selected;
    @Inject ContactFr nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public ContactFr getSelected() {
		return selected;
	}

	public void setSelected(ContactFr selected) {
		this.selected = selected;
	}

	public ContactFr getNouveau() {
		return nouveau;
	}

	public void setNouveau(ContactFr nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new ContactFr();
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
	
	public List<ContactFr> getAll(){
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
