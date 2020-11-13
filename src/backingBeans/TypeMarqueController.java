package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.TypeMarqueFacade;
import entity.TypeMarque;
import entity.Utilisateur;

@ManagedBean(name = "typeMarqueController")
@SessionScoped
public class TypeMarqueController implements Serializable{

	private static final long serialVersionUID = 1L;
	 	@EJB    TypeMarqueFacade ejb;
	    @Inject TypeMarque selected;
	    @Inject TypeMarque nouveau;
	    private String destAdd;
	    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	    
		public TypeMarque getSelected() {
			return selected;
		}

		public void setSelected(TypeMarque selected) {
			this.selected = selected;
		}

		public TypeMarque getNouveau() {
			return nouveau;
		}

		public void setNouveau(TypeMarque nouveau) {
			this.nouveau = nouveau;
		}
		
		public String getDestAdd() {
			return destAdd;
		}

		public void setDestAdd(String destAdd) {
			this.destAdd = destAdd;
		}

		public String add(){
			System.out.println("nouveau "+nouveau);
			nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
			ejb.create(nouveau);
			nouveau=new TypeMarque();
			System.out.println("redirection "+destAdd);
			return destAdd;
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
		
		public List<TypeMarque> getAll(){
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
