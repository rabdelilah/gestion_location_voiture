package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Sinistre;

@Stateless
public class SinistreFacade  extends AbstractFacade<Sinistre> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SinistreFacade() {
        super(Sinistre.class);
    }
    @SuppressWarnings("unchecked")
   	public List<Sinistre> getAllActif(){
       	return em.createQuery("select o from Sinistre o where o.status is null or  o.status <> 'deleted'").getResultList();
    }

}
