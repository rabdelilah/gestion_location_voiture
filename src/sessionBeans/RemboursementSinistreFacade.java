package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.RemboursementSinistre;

@Stateless
public class RemboursementSinistreFacade extends AbstractFacade<RemboursementSinistre> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RemboursementSinistreFacade() {
        super(RemboursementSinistre.class);
    }
    @SuppressWarnings("unchecked")
   	public List<RemboursementSinistre> getAllActif(){
       	return em.createQuery("select o from RemboursementSinistre o where o.status is null or  o.status <> 'deleted'").getResultList();
    }

}
