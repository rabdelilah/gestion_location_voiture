package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Parametrage;

@Stateless
public class ParametrageFacade extends AbstractFacade<Parametrage> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParametrageFacade() {
        super(Parametrage.class);
    }
    @SuppressWarnings("unchecked")
   	public List<Parametrage> getAllActif(){
       	return em.createQuery("select o from Parametrage o where o.status is null or  o.status <> 'deleted'").getResultList();
    }
}

