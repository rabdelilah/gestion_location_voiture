package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.DossierSinistreFacade;
import entity.DossierSinistre;
import entity.Utilisateur;

@ManagedBean(name = "dossierSinistreController")
@SessionScoped
public class DossierSinistreController implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB
    private DossierSinistreFacade ejb;
    @Inject DossierSinistre selected;
    @Inject DossierSinistre nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public DossierSinistre getSelected() {
		return selected;
	}

	public void setSelected(DossierSinistre selected) {
		this.selected = selected;
	}

	public DossierSinistre getNouveau() {
		return nouveau;
	}

	public void setNouveau(DossierSinistre nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new DossierSinistre();
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
	
	public List<DossierSinistre> getAll(){
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
