/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uml.RegistroConsultas;

/**
 *
 * @author jdmar
 */
@Stateless
public class RegistroConsultasFacade extends AbstractFacade<RegistroConsultas> {

    @PersistenceContext(unitName = "Consultorio-SecretariaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroConsultasFacade() {
        super(RegistroConsultas.class);
    }
    
}
