package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.ContratLldFacade;
import entity.ContratLld;
import entity.Utilisateur;

@ManagedBean(name = "contratLldController")
@SessionScoped
public class ContratLldController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
    private ContratLldFacade ejb;
    @Inject ContratLld selected;
    @Inject ContratLld nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public ContratLld getSelected() {
		return selected;
	}

	public void setSelected(ContratLld selected) {
		this.selected = selected;
	}

	public ContratLld getNouveau() {
		return nouveau;
	}

	public void setNouveau(ContratLld nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		System.out.println("nouveau "+nouveau);
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new ContratLld();
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
	
	public List<ContratLld> getAll(){
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
