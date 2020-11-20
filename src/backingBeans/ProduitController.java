package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.ProduitFacade;
import entity.Produit;
import entity.Utilisateur;
@ManagedBean(name = "produitController")
@SessionScoped
public class ProduitController implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB
    private ProduitFacade ejb;
    @Inject Produit selected;
    @Inject Produit nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public Produit getSelected() {
		return selected;
	}

	public void setSelected(Produit selected) {
		this.selected = selected;
	}

	public Produit getNouveau() {
		return nouveau;
	}

	public void setNouveau(Produit nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new Produit();
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
	
	public List<Produit> getAll(){
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
