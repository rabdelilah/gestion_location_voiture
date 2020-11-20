package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.utilisateurFacade;
import entity.Utilisateur;

@ManagedBean(name = "utilisateurController")
@SessionScoped
public class utilisateurController  implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB  utilisateurFacade ejb;
    @Inject Utilisateur selected;
    @Inject Utilisateur nouveau;
    
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public Utilisateur getSelected() {
		return selected;
	}

	public void setSelected(Utilisateur selected) {
		this.selected = selected;
	}

	public Utilisateur getNouveau() {
		return nouveau;
	}

	public void setNouveau(Utilisateur nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		ejb.create(nouveau);
		nouveau=new Utilisateur();
		return "#";
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
	
	public List<Utilisateur> getAll(){
		return ejb.getAllActif();
	}
	
	public String connecte(){
		Utilisateur u=ejb.getUser(selected.getLogin());
		if(u!=null && u.getPwd().equalsIgnoreCase(selected.getPwd())){
			session.setAttribute("user", u);
			selected.setSociete(u.getSociete());
			return "index.xhtml";
		}
		return "login";
	}
	public String deconnecter() {
		session.setAttribute("user", null);
		return "index";
	}

	public void verif(ComponentSystemEvent event) {
		if (session.getAttribute("user") == null) {
			try {
				FacesContext
						.getCurrentInstance()
						.getExternalContext()
						.redirect("/glv_sp/faces/login.xhtml");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
