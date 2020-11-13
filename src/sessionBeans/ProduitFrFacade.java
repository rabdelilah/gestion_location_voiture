package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.ProduitFr;

@Stateless
public class ProduitFrFacade extends AbstractFacade<ProduitFr> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFrFacade() {
        super(ProduitFr.class);
    }
    @SuppressWarnings("unchecked")
   	public List<ProduitFr> getAllActif(){
       	return em.createQuery("select o from ProduitFr o where o.status is null or  o.status <> 'deleted'").getResultList();
    }


}
