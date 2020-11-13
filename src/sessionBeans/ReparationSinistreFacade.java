package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.ReparationSinistre;

@Stateless
public class ReparationSinistreFacade extends AbstractFacade<ReparationSinistre> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReparationSinistreFacade() {
        super(ReparationSinistre.class);
    }
    @SuppressWarnings("unchecked")
   	public List<ReparationSinistre> getAllActif(){
       	return em.createQuery("select o from ReparationSinistre o where o.status is null or  o.status <> 'deleted'").getResultList();
    }


}
