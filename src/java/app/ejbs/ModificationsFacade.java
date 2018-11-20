/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ejbs;

import app.entities.Modifications;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alaa
 */
@Stateless
public class ModificationsFacade extends AbstractFacade<Modifications> {

    @PersistenceContext(unitName = "electronixFinalAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModificationsFacade() {
        super(Modifications.class);
    }
    
}
