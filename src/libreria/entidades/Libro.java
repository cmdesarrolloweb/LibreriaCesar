package libreria.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Libro {
    
    @Id
    private Integer isbn;
    
    @Column(nullable = false)
    private String titulo;
    private Integer anio; 
    private Integer prestados;
    
    @Column(nullable = false)
    private Integer ejemplares;
    
    @ManyToOne
    private Autor autor;
    
    @ManyToOne
    private Editorial editorial; 

    public Libro() {
    }

    public Libro(Integer isbn, String titulo, Integer anio, Integer prestados, Integer ejemplares, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.prestados = prestados;
        this.ejemplares = ejemplares;
        this.autor = autor;
        this.editorial = editorial;
    }
    
    public Integer getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getPrestados() {
        return prestados;
    }

    public void setPrestados(Integer prestados) {
        this.prestados = prestados;
    }
    
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the anio
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    /**
     * @return the autor
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * @return the editorial
     */
    public Editorial getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro ISBN: " + isbn + ". Titulo" + titulo
                + ". Autor: " + autor.getNombre() + ". Editorial: " + editorial.getNombre()
                + ". \nEjemplares: " + ejemplares + ". Prestaados: " + prestados;
    }
    
}
