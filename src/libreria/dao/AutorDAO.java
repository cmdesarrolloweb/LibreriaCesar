package libreria.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

public class AutorDAO {

    public void guardar(Autor autor) {

        try {
            EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
            //begin(crea conexion a la base de datos)
            //persist(Guardar datos - Alta)
            //remove(Remover datos - Baja)
            //merge(Actualizar datos - Modificación)
            //commit(cierra conexión con la base de datos)
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public ArrayList<Autor> listarAutores() throws Exception {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
            return (ArrayList<Autor>) em.createQuery("Select a From Autor a Order By a.nombre ").getResultList();
        } catch (Exception e) {
            throw new Exception("La consulta no devuelve datos");
        }
    }

    public Autor buscarAutor(String idAutor) throws Exception {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
            Autor autor = em.find(Autor.class, idAutor);
            return autor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void modificarAutor(String id, String nombre) throws Exception {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
            em.getTransaction().begin();

            Autor autor = em.find(Autor.class, id);
            autor.setNombre(nombre);

            em.merge(autor);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    public void eliminarAutor(String id) throws Exception {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
            em.getTransaction().begin();

            Autor autor = em.find(Autor.class, id);
            em.remove(autor);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

}
