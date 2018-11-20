/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ejbs;

import app.entities.Propositions;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alaa
 */
@Stateless
public class PropositionsFacade extends AbstractFacade<Propositions> {

    @PersistenceContext(unitName = "electronixFinalAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropositionsFacade() {
        super(Propositions.class);
    }
    
}
