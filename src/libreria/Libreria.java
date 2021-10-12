/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.List;
import libreria.Menu.Menu;
import libreria.entidades.Autor;
import libreria.entidades.Cliente;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.ClienteDAO;
import libreria.persistencia.EditorialDAO;
import libreria.persistencia.LibroDAO;
import libreria.persistencia.PrestamoDAO;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicios;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import libreria.servicios.PrestamoServicios;

/**
 *
 * @author ignacio
 */
public class Libreria {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        
        Menu menu = new Menu();
        menu.menuPrincipal();
        // TODO code application logic here

//        AutorServicio as = new AutorServicio();
//        EditorialServicio es = new EditorialServicio();
//        LibroServicio ls = new LibroServicio();
//       ClienteServicios cs = new ClienteServicios();
//       ClienteDAO clienteDAO = new ClienteDAO();
//        LibroDAO libroDAO = new LibroDAO();
//       AutorDAO autorDAO = new AutorDAO();
//       EditorialDAO editorialDAO = new EditorialDAO();
//        PrestamoServicios ps = new PrestamoServicios();
//        PrestamoDAO prestamoDAO = new PrestamoDAO();
        
        
        
//        Prestamo prestamo = ps.crearPrestamo();
//        
//      prestamoDAO.GuardarPrestamo(prestamo);

//ml.menuPrincipalLibro();
//        Cliente cliente = cs.crearCliente();
//        
//        clienteDAO.GuardarCliente(cliente);
        //Autor autor1 = new Autor(5, "gombrich ", true);
        // Editorial editorial1 = new Editorial(5, "Editorial 5 ", true);
        //Libro libro1 = new Libro(11212l, "breve historia del mundo ", 2014, 200, 30, 170    , true, autor1, editorial1);
        //System.out.println("antes del dao");
        //autorDAO.GuardarAutor(autor1);
        //editorialDAO.GuardarEditorial(editorial1);
        //libroDAO.GuardarLibro(libro1);
        //System.out.println("final");
        //autorDAO.BuscarAutor();
        //libroDAO.BuscarLibro();
        //editorialDAO.buscarEditorial();
        //autorDAO.ModificarAutor();
        //libroDAO.ModificarLibro();
        //editorialDAO.ModificarEditorial();
        //autorDAO.eliminarAutor();
        //libroDAO.eliminarLibro();
        //editorialDAO.eliminarEditorial();
//        List<Libro> auxlibro = libroDAO.listarLibros();
//        System.out.println("*** LISTA DE Libros ***");
//        System.out.printf("%-15s%-15s%-10s%-25s%-25s%-10s%-20s%-15s%-15s\n", "ISBN", "TITULO", "ANIO", "EJEMPLARES", "EJEMPLARES PRESTADOS", "EJEMPLARES RESTANTES", "ALTA", "AUTOR", "EDITORIAL");
//        for (Libro libritos : auxlibro) {
//            System.out.println(libritos);
//
//        }
//    
//    List<Autor> auxautor = autorDAO.listarAutores();
//        System.out.println("*** LISTA DE Autores ***");
//        System.out.printf("%-15s%-15s%-15s\n", "id", "NOMBRE", "ALTA");
//        for (Autor autores : auxautor) {
//            System.out.println(autores);
//
//        }
//    
//List<Editorial> auxeditoriales = editorialDAO.listarEditoriales();
//        System.out.println("*** LISTA DE productos ***");
//        System.out.printf("%-15s%-15s%-15s\n", "id", "nombre", "alta" );
//        for (Editorial editorialess : auxeditoriales) {
//            System.out.println(editorialess);
//
//        }
//    }
    }
}
