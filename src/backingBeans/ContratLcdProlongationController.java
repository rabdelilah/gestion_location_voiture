package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.ContratLcdProlongationFacade;
import entity.ContratLcdProlongation;
import entity.Utilisateur;

@ManagedBean(name = "contratLcdProlongationController")
@SessionScoped
public class ContratLcdProlongationController  implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
    private ContratLcdProlongationFacade ejb;
    @Inject ContratLcdProlongation selected;
    @Inject ContratLcdProlongation nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public ContratLcdProlongation getSelected() {
		return selected;
	}

	public void setSelected(ContratLcdProlongation selected) {
		this.selected = selected;
	}

	public ContratLcdProlongation getNouveau() {
		return nouveau;
	}

	public void setNouveau(ContratLcdProlongation nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		System.out.println("nouveau "+nouveau);
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new ContratLcdProlongation();
		return "List.xhtml";
	}
	
	public String edit(){
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public String remove(){
		ejb.remove(selected);
		return "List.xhtml";
	}
	
	public List<ContratLcdProlongation> getAll(){
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
