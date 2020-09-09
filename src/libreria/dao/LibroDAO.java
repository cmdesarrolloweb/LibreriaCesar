package libreria.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroDAO {

    public void guardar(Integer isbn, String titulo, Integer anio, String idAutor, String idEditorial, Integer ejemplares) {

        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();

        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setPrestados(0);
        libro.setAnio(anio);

        Autor autor = em.find(Autor.class, idAutor);
        libro.setAutor(autor);
        
        Editorial editorial = em.find(Editorial.class, idEditorial);
        libro.setEditorial(editorial);
        
        em.persist(libro);
        em.getTransaction().commit();
    }
    
    
    public void actualizarEjemplares(Integer isbn, Integer ejemplares) {

        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();
        em.getTransaction().begin();

        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setEjemplares(ejemplares);
        
        em.persist(libro);
        em.getTransaction().commit();
    }
    
    public List<Libro> buscarLibros(){
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();  
        List<Libro> libros = em.createQuery("SELECT c FROM Libro c ORDER BY c.titulo").getResultList();
        return libros;
    }
    
    public List<Libro> buscarLibros(Integer isbn){
        return null;
    }
    
    public List<Libro> buscarLibros(String titulo){
        return null;
    }

    public List<Libro> buscarLibrosPorAutor(String autor){
        EntityManager em = Persistence.createEntityManagerFactory("LIbreriaPU").createEntityManager();  
        
        List<Libro> libros = em.createQuery("SELECT c FROM Libro c WHERE c.autor.nombre LIKE :nombre ORDER BY c.titulo")
                .setParameter("nombre", "%" + autor + "%")
                .getResultList();
        
        return libros;
    }
    
}