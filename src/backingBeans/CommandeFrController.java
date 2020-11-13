package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import sessionBeans.CommandeFrFacade;
import sessionBeans.DetailCmdFrFacade;
import entity.CommandeFr;
import entity.DetailCmdFr;
import entity.Utilisateur;

@ManagedBean(name = "commandeFrController")
@SessionScoped
public class CommandeFrController implements Serializable{

	private static final long serialVersionUID = 1L;
    @EJB private CommandeFrFacade ejb;
    @EJB DetailCmdFrFacade ejbLignes;
    @Inject CommandeFr selected;
    @Inject CommandeFr nouveau;
    @Inject CommandeFr entete;
    @Inject DetailCmdFr nouveauLigne;
    @Inject DetailCmdFr selectedLigne;
    private boolean flagValider;
    
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
	public CommandeFr getSelected() {
		return selected;
	}

	public void setSelected(CommandeFr selected) {
		this.selected = selected;
	}

	public CommandeFr getNouveau() {
		nouveau.setNumCmd(getNumCommande());
		return nouveau;
	}

	public void setNouveau(CommandeFr nouveau) {
		this.nouveau = nouveau;
	}

	public CommandeFr getEntete() {
		return entete;
	}

	public void setEntete(CommandeFr entete) {
		this.entete = entete;
	}

	public DetailCmdFr getNouveauLigne() {
		return nouveauLigne;
	}

	public void setNouveauLigne(DetailCmdFr nouveauLigne) {
		this.nouveauLigne = nouveauLigne;
	}

	public DetailCmdFr getSelectedLigne() {
		return selectedLigne;
	}

	public void setSelectedLigne(DetailCmdFr selectedLigne) {
		this.selectedLigne = selectedLigne;
	}

	public boolean isFlagValider() {
		return flagValider;
	}

	public void setFlagValider(boolean flagValider) {
		this.flagValider = flagValider;
	}

	public void add(){
		System.out.println("nouveau "+nouveau);
		nouveau.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejb.create(nouveau);
		try{entete=(CommandeFr) nouveau.clone();}catch(Exception e){e.printStackTrace();}
		flagValider=true;
		//nouveau=new CommandeFr();
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
	
	public List<CommandeFr> getAll(){
		return ejb.getAllActif();
	}
	public List<DetailCmdFr> getAllByEntete(){
		return ejbLignes.getAllByEntete(entete);
	}
	public String toEditLigne(){
		return "Create.xhtml";
	}
	public String toEditLigneEdit(){
		return "Edit.xhtml";
	}
	public String toAdd(){
		entete=new CommandeFr();
		nouveau=new CommandeFr();
		flagValider=false;
		return "Create.xhtml";
	}
	public String toEdit(){
		flagValider=true;
		return "Edit.xhtml";
	}
	public String toList(){
		return "List.xhtml";
	}
	public String toShow(){
		return "View.xhtml";
	}
	
	public String addLigne(){
		nouveauLigne.setCommandeFr(entete);
		nouveauLigne.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejbLignes.create(nouveauLigne);
		nouveauLigne=new DetailCmdFr();
		return "Create.xhtml";
	}
	public String editLigne(){
		System.out.println("edit "+nouveauLigne);
		ejbLignes.edit(nouveauLigne);
		nouveauLigne=new DetailCmdFr();
		return "Create.xhtml";
	}
	public String addLigneEdit(){
		nouveauLigne.setCommandeFr(entete);
		nouveauLigne.setIdSociete(((Utilisateur)session.getAttribute("user")).getSociete().getId());
		ejbLignes.create(nouveauLigne);
		nouveauLigne=new DetailCmdFr();
		return "Edit.xhtml";
	}
	public String editLigneEdit(){
		System.out.println("edit "+nouveauLigne);
		ejbLignes.edit(nouveauLigne);
		nouveauLigne=new DetailCmdFr();
		return "Edit.xhtml";
	}
	public String getNumCommande(){
		String radical=ejb.paramDesin("numCmd_auto").get(0)+ejb.count();
		return radical;
	}
	public void changePu(){
		try {
			nouveauLigne.setPrixUnitaire(nouveauLigne.getArticle().getPrixUnitaire());
		} catch (Exception e) {
			nouveauLigne.setPrixUnitaire(0);
		}
	}
}
