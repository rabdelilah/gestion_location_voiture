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

import entity.Ged;

/**
 *
 * @author Admin
 */
@Stateless
public class GedFacade extends AbstractFacade<Ged> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GedFacade() {
        super(Ged.class);
    }
    @SuppressWarnings("unchecked")
   	public List<Ged> getAllActif(){
       	return em.createQuery("select o from Ged o where o.status is null or  o.status <> 'deleted'").getResultList();
    }
}
