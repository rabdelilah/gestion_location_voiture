package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.ParametrageFacade;
import entity.Parametrage;
import entity.Utilisateur;


@ManagedBean(name = "parametrageController")
@SessionScoped
public class ParametrageController implements Serializable{
	private static final long serialVersionUID = 1L;
    @EJB
    private ParametrageFacade ejb;
    @Inject Parametrage selected;
    @Inject Parametrage nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public Parametrage getSelected() {
		return selected;
	}

	public void setSelected(Parametrage selected) {
		this.selected = selected;
	}

	public Parametrage getNouveau() {
		return nouveau;
	}

	public void setNouveau(Parametrage nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new Parametrage();
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
	
	public List<Parametrage> getAll(){
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
