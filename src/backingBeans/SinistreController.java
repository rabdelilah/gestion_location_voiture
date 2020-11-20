package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.SinistreFacade;
import entity.Sinistre;
import entity.Utilisateur;

@ManagedBean(name = "sinistreController")
@SessionScoped
public class SinistreController implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB private SinistreFacade ejb;
    @Inject Sinistre selected;
    @Inject Sinistre nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    List<Object> listContrat;
    
	public Sinistre getSelected() {
		return selected;
	}

	public void setSelected(Sinistre selected) {
		this.selected = selected;
	}

	public Sinistre getNouveau() {
		return nouveau;
	}

	public void setNouveau(Sinistre nouveau) {
		this.nouveau = nouveau;
	}

	public List<Object> getListContrat() {
		return listContrat;
	}

	public void setListContrat(List<Object> listContrat) {
		this.listContrat = listContrat;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new Sinistre();
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
	
	public List<Sinistre> getAll(){
		return ejb.getAllActif();
	}
	
	public void getContrat(){
		if(nouveau.getTypeContrat().equalsIgnoreCase("LCD")){
			listContrat=ejb.getListObject("select o from ContratLcd o");
		}else{
			listContrat=ejb.getListObject("select o from ContratLld o");
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
