package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.DetailCmdFrFacade;
import entity.DetailCmdFr;
import entity.Utilisateur;

@ManagedBean(name = "detailCmdFrController")
@SessionScoped
public class DetailCmdFrController implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB
    private DetailCmdFrFacade ejb;
    @Inject DetailCmdFr selected;
    @Inject DetailCmdFr nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public DetailCmdFr getSelected() {
		return selected;
	}

	public void setSelected(DetailCmdFr selected) {
		this.selected = selected;
	}

	public DetailCmdFr getNouveau() {
		return nouveau;
	}

	public void setNouveau(DetailCmdFr nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new DetailCmdFr();
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
	
	public String removeLigne(){
		selected.setStatus("deleted");
		ejb.edit(selected);
		selected=new DetailCmdFr();
		return "Create.xhtml";
	}
	public String removeLigneEdit(){
		selected.setStatus("deleted");
		ejb.edit(selected);
		selected=new DetailCmdFr();
		return "Edit.xhtml";
	}
	public List<DetailCmdFr> getAll(){
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
