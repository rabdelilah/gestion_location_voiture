package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.ReservationFacade;
import entity.Reservation;
import entity.Utilisateur;

@ManagedBean(name = "reservationController")
@SessionScoped
public class ReservationController implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
    private ReservationFacade ejb;
    @Inject Reservation selected;
    @Inject Reservation nouveau;
    
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	
	public Reservation getSelected() {
		return selected;
	}

	public void setSelected(Reservation selected) {
		this.selected = selected;
	}

	public Reservation getNouveau() {
		return nouveau;
	}

	public void setNouveau(Reservation nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new Reservation();
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
	
	public List<Reservation> getAll(){
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
