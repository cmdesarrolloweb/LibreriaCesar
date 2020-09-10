package libreria.interfaz;

import java.util.Scanner;
import libreria.entidades.Cliente;

import libreria.entidades.Libro;

import libreria.servicios.AutorService;
import libreria.servicios.ClienteService;
import libreria.servicios.EditorialService;
import libreria.servicios.LibroService;

public class InterfazLibreria {

    private EditorialService editorialServicio;
    private AutorService autorService;
    private LibroService libroService;
    private ClienteService clienteService;
    private PrestamoService prestamoService;

//    private BufferedReader teclado;
//
//    public InterfazLibreria() {
//        this.editorialServicio = new EditorialService();
//        this.autorServicio = new AutorService();
//        this.libroServicio = new LibroService();
//        this.prestamoServicio = new PrestamoService();
//    }
    public void menu() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
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

        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                autorServicio.crearAutor();
                break;
            case 2:
                editorialServicio.crearEditorial();
                break;
            case 3:
                libroServicio.crearLibro();
                break;
            case 4:
                libroServicio.actualizarEjemplares();
                break;
            case 5:
                libroServicio.listarLibros();
                break;
            case 6:
                libroServicio.mostrarLibrosDeAutor();
                break;
            case 7:
                libroServicio.mostrarLibrosPorTitulo();
                break;
            case 8:
                libroServicio.mostrarLibrosPorISBN();
                break;
            case 9:
                Libro libro = libroServicio.perstarLibro();
                Cliente cliente = clienteServicio.buscarCliente();

                if (cliente == null) {
                    cliente = clienteServicio.crearCliente();
                }
                prestamoServicio.crearPrestamo(libro, cliente);
                break;
            case 10:
                
                break;
            case 11:
                clienteServicio.crearCliente();
            case 0:
                System.exit(-1);
                break;
        }

    }

}
