package backingBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.ContratLcdFacade;
import entity.ContratLcd;
import entity.Utilisateur;

@ManagedBean(name = "contratLcdController")
@SessionScoped
public class ContratLcdController {

	 	@EJB
	    private ContratLcdFacade ejb;
	    @Inject ContratLcd selected;
	    @Inject ContratLcd nouveau;
	    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		public ContratLcd getSelected() {
			return selected;
		}

		public void setSelected(ContratLcd selected) {
			this.selected = selected;
		}

		public ContratLcd getNouveau() {
			return nouveau;
		}

		public void setNouveau(ContratLcd nouveau) {
			this.nouveau = nouveau;
		}

		public String add(){
			nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
			ejb.create(nouveau);
			nouveau=new ContratLcd();
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
		
		public List<ContratLcd> getAll(){
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
