package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.ArticleFacade;
import entity.Article;
import entity.Utilisateur;

@ManagedBean(name = "articleController")
@SessionScoped
public class ArticleController implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB
    private ArticleFacade ejb;
    @Inject Article selected;
    @Inject Article nouveau;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public Article getSelected() {
		return selected;
	}

	public void setSelected(Article selected) {
		this.selected = selected;
	}

	public Article getNouveau() {
		return nouveau;
	}

	public void setNouveau(Article nouveau) {
		this.nouveau = nouveau;
	}

	public String add(){
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		nouveau=new Article();
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
	
	public List<Article> getAll(){
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
