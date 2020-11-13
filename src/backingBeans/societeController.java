package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import sessionBeans.societeFacade;
import entity.Societe;

@ManagedBean(name = "societeController")
@SessionScoped
public class societeController  implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB  societeFacade ejb;
    @Inject Societe selected;
    @Inject Societe nouveau;
    
	public Societe getSelected() {
		return selected;
	}

	public void setSelected(Societe selected) {
		this.selected = selected;
	}

	public Societe getNouveau() {
		return nouveau;
	}

	public void setNouveau(Societe nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		System.out.println("nouveau "+nouveau);
		ejb.create(nouveau);
		nouveau=new Societe();
		return "#";
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
	
	public List<Societe> getAll(){
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
