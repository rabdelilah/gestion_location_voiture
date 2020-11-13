package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Fournisseur;

@Stateless
public class FournisseurFacade  extends AbstractFacade<Fournisseur> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FournisseurFacade() {
        super(Fournisseur.class);
    }
    @SuppressWarnings("unchecked")
   	public List<Fournisseur> getAllActif(){
       	return em.createQuery("select o from Fournisseur o where o.status is null or  o.status <> 'deleted'").getResultList();
    }


}
