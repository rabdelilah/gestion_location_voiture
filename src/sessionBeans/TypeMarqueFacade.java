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

import entity.TypeMarque;

/**
 *
 * @author Admin
 */
@Stateless
public class TypeMarqueFacade extends AbstractFacade<TypeMarque> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeMarqueFacade() {
        super(TypeMarque.class);
    }
    @SuppressWarnings("unchecked")
   	public List<TypeMarque> getAllActif(){
       	return em.createQuery("select o from TypeMarque o where o.status is null or  o.status <> 'deleted'").getResultList();
    }
}
