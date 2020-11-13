package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.CommandeFr;

@Stateless
public class CommandeFrFacade extends AbstractFacade<CommandeFr> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFrFacade() {
        super(CommandeFr.class);
    }
    @SuppressWarnings("unchecked")
   	public List<CommandeFr> getAllActif(){
       	return em.createQuery("select o from CommandeFr o where o.status is null or  o.status <> 'deleted'").getResultList();
    }
    
}
