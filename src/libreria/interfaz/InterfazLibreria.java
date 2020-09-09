package libreria.interfaz;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.entidades.Libro;
import libreria.dao.AutorDAO;
import libreria.dao.EditorialDAO;
import libreria.dao.LibroDAO;

public class InterfazLibreria {
    

    private EditorialDAO editorialDAO;
    private AutorDAO autorDAO;
    private LibroDAO libroDAO;
    
    private BufferedReader teclado;
    
    public InterfazLibreria() {
        this.editorialDAO = new EditorialDAO();
        this.autorDAO = new AutorDAO();
        this.libroDAO = new LibroDAO();
        this.teclado = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public String leerCadena(){
        String cadena = null;
        try {
            cadena = teclado.readLine();
        } catch (IOException ex) {
            Logger.getLogger(InterfazLibreria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    }
    
    
    public Integer leerNumero(){
        String cadena = "0";
        try {
            cadena = teclado.readLine();
        } catch (IOException ex) {
            Logger.getLogger(InterfazLibreria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Integer(cadena);
    }
    
    
    public void menu() throws Exception {
        System.out.println("Seleccione la opción:");
        System.out.println("=====================================");
        
        System.out.println(" 1- Crear Autor");
        System.out.println(" 2- Crear Editorial");
        System.out.println(" 3- Crear Libro");
        System.out.println(" 4- Agregar Ejemplares");
        
        System.out.println(" 5- Mostrar Libros");
        System.out.println(" 6- Mostrar Libros x Autor");
        System.out.println(" 7- Mostrar Libros x Titulo");
        System.out.println(" 8- Mostrar Libros x ISBN");

        System.out.println(" 9- Prestamo");
        System.out.println(" 10- Devolución");
        
        System.out.println(" 0- Salir");
        
                
        int opcion = leerNumero();
        switch(opcion){
            case 1: 
                autorServicio.crearAutor();
                break;
            case 2:
                crearEditorial();
                break;
            case 3:
                crearLibro();
                break;
            case 4:
                agregarEjemplar();
                break;
            case 5:      
                mostrarLibros();
                break;
            case 6:      
                mostrarLibrosDeAutor();
                break;
            case 7:      
                mostrarLibrosPorTitulo();
                break;
            case 8:      
                mostrarLibrosPorISBN();
                break;
            case 9:      
                prestamo();
                break;
            case 10:      
                devolucion();
                break;
            case 0:
                System.exit(-1);
                break;
        }
        
    }
    
    public void crearAutor(){
        System.out.println("Ingrese nombre del autor:");
        String nombre = leerCadena();
        autorDAO.guardar(nombre);
        
    }
    
    public void crearEditorial(){
        System.out.println("Ingrese nombre de la editorial:");
        String nombre = leerCadena();
        editorialDAO.guardar(nombre);
        
    }
    
    public void crearLibro(){
        System.out.println("Ingrese ISBN del libro:");
        Integer isbn = leerNumero();
        

        System.out.println("Ingrese titulo del libro:");
        String titulo = leerCadena();
        
        
        System.out.println("Ingrese el año de publicacion del libro:");
        Integer anio = leerNumero();
        

        System.out.println("Ingrese ID de autor:");
        String idAutor = leerCadena();
        
        
        System.out.println("Ingrese ID de editorial:");
        String idEditorial = leerCadena();
 
        System.out.println("Ingrese la cantidad de ejemplares:");
        Integer ejemplares = leerNumero();
 
        
        libroDAO.guardar(isbn, titulo, anio, idAutor, idEditorial, ejemplares);
    }
    
    public void agregarEjemplar(){
        System.out.println("Ingrese ISBN del libro:");
        Integer isbn = leerNumero();
 
        System.out.println("Ingrese la cantidad de ejemplares:");
        Integer ejemplares = leerNumero();

        libroDAO.actualizarEjemplares(isbn, ejemplares);
    }
    
    public void mostrarLibros(){
        List<Libro> libros = libroDAO.buscarLibros();
        imprimirLibros(libros);
    }


    public void mostrarLibrosDeAutor(){
 
        System.out.println("Ingrese el nombre del autor:");
        String autor = leerCadena();
        
        List<Libro> libros = libroDAO.buscarLibrosPorAutor(autor);
        imprimirLibros(libros);
    }
    
    public void mostrarLibrosPorISBN(){

    }

    public void mostrarLibrosPorTitulo(){

    }
    
    public void imprimirLibros(List<Libro> libros){
        for(Libro libro : libros){
            System.out.println("ISBN: " + libro.getIsbn() + " " + libro.getTitulo() + " " + libro.getAutor());
        }
    }
    
    public void prestamo(){
        
    }
    
    public void devolucion(){
        
    }
    
}
