/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author cesarminetti
 */
public class ClienteDAO {
    
    public void guardarCliente(Integer documento, String nombre, String apellido, String domicilio, String telefono) {
        
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        
    }
    
}
