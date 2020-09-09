/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.dao.LibroDAO;
import libreria.entidades.Autor;
import libreria.entidades.Libro;

/**
 *
 * @author cesarminetti
 */
public class LibroService {

    private LibroDAO libroDao = new LibroDAO();
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearLibro() throws Exception {
        try {
            System.out.println("Ingrese el ISBN del libro");
            Integer isbn = leer.nextInt();

            if (isbn == null) {
                throw new Exception("Debe ingresar un ISBN");
            }
            
            System.out.println("Ingrese el título del libro");
            String titulo = leer.next();

            if (titulo == null) {
                throw new Exception("Debe ingresar un título");
            }
            
            System.out.println("Ingrese el año de publicación del libro");
            Integer anio = leer.nextInt();

            if (anio == null) {
                throw new Exception("Debe ingresar un año");
            }
            
            System.out.println("Ingrese el ID de autor");
            String idAutor = leer.next();

            if (idAutor == null) {
                throw new Exception("Debe ingresar un ID de autor");
            }
            
            System.out.println("Ingrese el ID de editorial");
            String idEditorial = leer.next();

            if (idEditorial == null) {
                throw new Exception("Debe ingresar el ID de editorial");
            }
            
            System.out.println("Ingrese la cantidad de ejemplares");
            Integer ejemplares = leer.nextInt();

            if (ejemplares == null) {
                throw new Exception("Debe ingresar la cantidad de ejemplares");
            }
            
            Libro libro = new Libro();
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setEjemplares(ejemplares);
            libro.setPrestados(0);
            libro.setAnio(anio);
            
            AutorService autorService = new AutorService();
            Autor autor = autorService.buscarAutor(idAutor);
            libro.setAutor(autor);
            
        }
    }

}
