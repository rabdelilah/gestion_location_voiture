/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Societe;

/**
 *
 * @author Admin
 */
@Stateless
public class societeFacade extends AbstractFacade<Societe> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public societeFacade() {
        super(Societe.class);
    }
    @SuppressWarnings("unchecked")
   	public List<Societe> getAllActif(){
       	return em.createQuery("select o from Societe o where o.status is null or  o.status <> 'deleted'").getResultList();
    }
    
}
