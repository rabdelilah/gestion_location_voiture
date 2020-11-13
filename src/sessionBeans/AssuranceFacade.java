/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;

import entity.Assurance;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hasnaa
 */
@Stateless
public class AssuranceFacade extends AbstractFacade<Assurance> {

    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AssuranceFacade() {
        super(Assurance.class);
    }
    @SuppressWarnings("unchecked")
	public List<Assurance> getAllActif(){
    	return em.createQuery("select o from Assurance o where o.status is null or  o.status <> 'deleted'").getResultList();
    }
}
