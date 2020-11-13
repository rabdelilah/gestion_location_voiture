package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.VehiculeFacade;
import entity.Utilisateur;
import entity.Vehicule;

@ManagedBean(name = "vehiculeController")
@SessionScoped
public class VehiculeController implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
    private VehiculeFacade ejb;
    @Inject Vehicule selected;
    @Inject Vehicule nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

	public Vehicule getSelected() {
		return selected;
	}

	public void setSelected(Vehicule selected) {
		this.selected = selected;
	}

	public Vehicule getNouveau() {
		return nouveau;
	}

	public void setNouveau(Vehicule nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new Vehicule();
		return "List.xhtml";
	}
	
	public String edit(){
		System.out.println("edit voiture : "+selected);
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public String remove(){
		System.out.println("supprimer "+selected);
		selected.setStatus("deleted");
		ejb.edit(selected);
		return "List.xhtml";
	}
	
	public List<Vehicule> getAll(){
		return ejb.getAllActif();
	}
	
	public List<String> getBoite_automatique(){
		return ejb.paramDesin("boite_automatique");
	}
	
	public List<String> getStatus(){
		return ejb.paramDesin("status");
	}
	
	public String toAdd(){
		return "Create.xhtml";
	}
	public String toEdit(){
		System.out.println("to edit :"+selected);
		return "Edit.xhtml";
	}
	public String toList(){
		return "List.xhtml";
	}
	public String toShow(){
		return "View.xhtml";
	}
}
