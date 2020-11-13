package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.CommandeFr;
import entity.DetailCmdFr;

@Stateless
public class DetailCmdFrFacade extends AbstractFacade<DetailCmdFr> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetailCmdFrFacade() {
        super(DetailCmdFr.class);
    }
    @SuppressWarnings("unchecked")
   	public List<DetailCmdFr> getAllActif(){
       	return em.createQuery("select o from DetailCmdFr o where o.status is null or  o.status <> 'deleted'").getResultList();
    }

    @SuppressWarnings("unchecked")
   	public List<DetailCmdFr> getAllByEntete(CommandeFr c){
       	return em.createQuery("select o from DetailCmdFr o where (o.status is null or  o.status <> 'deleted') and o.commandeFr="+c.getId()).getResultList();
    }
}
