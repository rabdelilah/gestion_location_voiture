package backingBeans;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.TypeGarantieFacade;
import entity.TypeGarantie;
import entity.Utilisateur;

@ManagedBean(name="typeGarantieController")
@SessionScoped
public class TypeGarantieController implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
    private TypeGarantieFacade ejb;
    @Inject TypeGarantie selected;
    @Inject TypeGarantie nouveau;
    
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public TypeGarantie getSelected() {
		return selected;
	}

	public void setSelected(TypeGarantie selected) {
		this.selected = selected;
	}

	public TypeGarantie getNouveau() {
		return nouveau;
	}

	public void setNouveau(TypeGarantie nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		System.out.println("nouveau "+nouveau);
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new TypeGarantie();
		return "List.xhtml";
	}
	
	public String edit(){
		System.out.println("edit "+selected);
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public String remove(){
		System.out.println("remove : "+selected);
		selected.setStatus("deleted");
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public List<TypeGarantie> getAll(){
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
