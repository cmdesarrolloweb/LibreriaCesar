package libreria.dao;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

public class EditorialDAO {

    public void guardar(String nombre) {

        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();

        Editorial editorial = new Editorial();
        editorial.setId(UUID.randomUUID().toString());
        editorial.setNombre(nombre);

        em.persist(editorial);
        em.getTransaction().commit();
    }

    public List<Editorial> buscarEditoriales() {
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        return em.createQuery("SELECT a FROM Editorial a ORDER BY a.nombre ").getResultList();
    }

    public void modificar(String id, String nombre) {
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();

        Editorial editorial = em.find(Editorial.class, id);
        editorial.setNombre(nombre);

        em.merge(editorial);

        em.getTransaction().commit();
    }

    public void eliminar(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();
        
        Editorial editorial = em.find(Editorial.class, id);
        em.remove(editorial);
        
        em.getTransaction().commit();
    }

}
