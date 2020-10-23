/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uml.AlergiasMedicamentos;

/**
 *
 * @author jdmar
 */
@Stateless
public class AlergiasMedicamentosFacade extends AbstractFacade<AlergiasMedicamentos> {

    @PersistenceContext(unitName = "Consultorio-SecretariaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlergiasMedicamentosFacade() {
        super(AlergiasMedicamentos.class);
    }
    
}
