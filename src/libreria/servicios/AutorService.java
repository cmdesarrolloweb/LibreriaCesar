/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.dao.AutorDAO;
import libreria.entidades.Autor;

/**
 *
 * @author cesarminetti
 */
public class AutorService {

    private AutorDAO autorDao = new AutorDAO();
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearAutor() throws Exception {

        System.out.println("Ingrese el nombre del Autor");
        String nombre = null;
        Autor autor = null;

        try {
            nombre = leer.next();

            if (nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del autor");
            } else {
                autor = new Autor();
                autor.setId(UUID.randomUUID().toString());
                autor.setNombre(nombre.trim());
            }

            if (autor == null) {
                throw new Exception("no se pudo guardar el autor. Verifique los datos ingresados.");
            } else {
                autorDao.guardar(autor);
            }
        } catch (Exception ex) {
            Logger.getLogger(AutorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Autor> listarAutores() throws Exception {
        try {
            ArrayList<Autor> autores = new ArrayList();
            autores = autorDao.listarAutores();

            if (autores.isEmpty()) {
                System.out.println("La consulta no devolvió ningún dato");
            } else {
                imprimirAutores((ArrayList<Autor>) autores);
            }

            return autores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Autor buscarAutorPorID(String idAutor) throws Exception {
        Autor autor = null;
        try {
            if (idAutor.trim().isEmpty()) {
                throw new Exception("Debe indicar un id de autor");
            } else {
                return autor = autorDao.buscarAutor(idAutor);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void modificarAutor(String id, String nombre) throws Exception {
        try {
            if (id == null) {
                throw new Exception("No se pudo identificar el ID para modificar el autor");
            }
            if (nombre == null) {
                throw new Exception("Debe indicar el Nombre del autor para poder modificarlo");
            } else {
                autorDao.modificarAutor(id, nombre);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarAutor(String id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("Debe indicar el ID del autor que quiere eliminar");
            } else {
                autorDao.eliminarAutor(id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void imprimirAutores(ArrayList<Autor> autores) {
        
        for (Autor autor : autores) {
            System.out.println(autor.toString());
        }
    }

}
