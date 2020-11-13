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

import entity.CompagnieAssurance;

/**
 *
 * @author hasnaa
 */
@Stateless
public class CompagnieAssuranceFacade extends AbstractFacade<CompagnieAssurance> {

    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompagnieAssuranceFacade() {
        super(CompagnieAssurance.class);
    }
    @SuppressWarnings("unchecked")
   	public List<CompagnieAssurance> getAllActif(){
       	return em.createQuery("select o from CompagnieAssurance o where o.status is null or  o.status <> 'deleted'").getResultList();
    }
}
