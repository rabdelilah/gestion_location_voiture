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

import entity.ContratLcdProlongation;

/**
 *
 * @author Admin
 */
@Stateless
public class ContratLcdProlongationFacade extends AbstractFacade<ContratLcdProlongation> {
    @PersistenceContext(unitName = "glvPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratLcdProlongationFacade() {
        super(ContratLcdProlongation.class);
    }
    @SuppressWarnings("unchecked")
   	public List<ContratLcdProlongation> getAllActif(){
       	return em.createQuery("select o from ContratLcdProlongation o where o.status is null or  o.status <> 'deleted'").getResultList();
    }
}
