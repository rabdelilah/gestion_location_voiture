package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.OffreLldFacade;
import entity.OffreLld;
import entity.Utilisateur;

@ManagedBean(name = "offreLldController")
@SessionScoped
public class OffreLldController implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	    private OffreLldFacade ejb;
	    @Inject OffreLld selected;
	    @Inject OffreLld nouveau;
	    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	   
		public OffreLld getSelected() {
			return selected;
		}

		public void setSelected(OffreLld selected) {
			this.selected = selected;
		}

		public OffreLld getNouveau() {
			return nouveau;
		}

		public void setNouveau(OffreLld nouveau) {
			this.nouveau = nouveau;
		}

		public String add(){
			 nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
			ejb.create(nouveau);
			nouveau=new OffreLld();
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
		public List<OffreLld> getAll(){
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
