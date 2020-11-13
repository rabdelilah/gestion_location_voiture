package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Produit;

@Stateless
public class ProduitFacade extends AbstractFacade<Produit> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }
    @SuppressWarnings("unchecked")
   	public List<Produit> getAllActif(){
       	return em.createQuery("select o from Produit o where o.status is null or  o.status <> 'deleted'").getResultList();
    }

}
