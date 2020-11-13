package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Article;

@Stateless
public class ArticleFacade  extends AbstractFacade<Article> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }
    @SuppressWarnings("unchecked")
   	public List<Article> getAllActif(){
       	return em.createQuery("select o from Article o where o.status is null or  o.status <> 'deleted'").getResultList();
    }

}
