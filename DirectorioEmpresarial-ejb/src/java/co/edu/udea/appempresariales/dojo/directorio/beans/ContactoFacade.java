/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.appempresariales.dojo.directorio.beans;

import co.edu.udea.appempresariales.dojo.directorio.entities.Contacto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author juanf.molina
 */
@Stateless
public class ContactoFacade extends AbstractFacade<Contacto> {
    @PersistenceContext(unitName = "DirectorioEmpresarial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactoFacade() {
        super(Contacto.class);
    }
    
}
