package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.ContactFr;

@Stateless
public class ContactFrFacade extends AbstractFacade<ContactFr> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactFrFacade() {
        super(ContactFr.class);
    }
    @SuppressWarnings("unchecked")
   	public List<ContactFr> getAllActif(){
       	return em.createQuery("select o from ContactFr o where o.status is null or  o.status <> 'deleted'").getResultList();
    }


}
