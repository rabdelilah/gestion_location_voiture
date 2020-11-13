package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.ProduitFrFacade;
import entity.ProduitFr;
import entity.Utilisateur;
@ManagedBean(name = "produitFrController")
@SessionScoped
public class ProduitFrController implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB
    private ProduitFrFacade ejb;
    @Inject ProduitFr selected;
    @Inject ProduitFr nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public ProduitFr getSelected() {
		return selected;
	}

	public void setSelected(ProduitFr selected) {
		this.selected = selected;
	}

	public ProduitFr getNouveau() {
		return nouveau;
	}

	public void setNouveau(ProduitFr nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		System.out.println("nouveau "+nouveau);
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new ProduitFr();
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
	
	public List<ProduitFr> getAll(){
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
