package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.DossierSinistre;

@Stateless
public class DossierSinistreFacade extends AbstractFacade<DossierSinistre> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DossierSinistreFacade() {
        super(DossierSinistre.class);
    }
    @SuppressWarnings("unchecked")
   	public List<DossierSinistre> getAllActif(){
       	return em.createQuery("select o from DossierSinistre o where o.status is null or  o.status <> 'deleted'").getResultList();
    }


}
