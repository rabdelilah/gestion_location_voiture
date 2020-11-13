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

import entity.TypeGarantie;

/**
 *
 * @author hasnaa
 */
@Stateless
public class TypeGarantieFacade extends AbstractFacade<TypeGarantie> {

    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeGarantieFacade() {
        super(TypeGarantie.class);
    }
    @SuppressWarnings("unchecked")
   	public List<TypeGarantie> getAllActif(){
       	return em.createQuery("select o from TypeGarantie o where o.status is null or  o.status <> 'deleted'").getResultList();
    }
    
}
