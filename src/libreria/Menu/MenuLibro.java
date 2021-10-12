/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Libro;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.LibroDAO;
import libreria.servicios.AutorServicio;
import libreria.servicios.LibroServicio;

/**
 *
 * @author ignacio
 */
public class MenuLibro {
    
    Scanner entrada = new Scanner(System.in);
    LibroServicio ls = new LibroServicio();
    LibroDAO libroDAO = new LibroDAO();
    
public void menuPrincipalLibro() throws Exception {
    
Integer respuesta = 0;
        do {
            try {
                System.out.println("ELIJA UNA OPCIÓN");
                System.out.println("1. CREAR LIBRO");
                System.out.println("2. MODIFICAR LIBRO");
                System.out.println("3. ELIMINAR LIBRO");
                System.out.println("4. MOSTRAR LIBRO");
                System.out.println("5. MOSTRAR LISTA LIBRO");              
                System.out.println("6. SALIR");

                respuesta = entrada.nextInt();

                switch (respuesta) {
                    case 1:
                        Libro libro = ls.crearLibro();
                        libroDAO.GuardarLibro(libro);
                        
                        break;
                    case 2:
                        libroDAO.ModificarLibro();
                        break;
                    case 3:
                        libroDAO.eliminarLibro();
                        break;
                    case 4:
                        
                      Libro libro2 =  libroDAO.BuscarLibro();
                        System.out.println(libro2.toString());
                              
                        
                        break;
                    case 5:
                        
                         List<Libro> listaLibro = libroDAO.listarLibros();
                        for (int i = 0; i < listaLibro.size(); i++) {
                            System.out.println(listaLibro.get(i).toString());
                                   
                        }
                        break;
                    case 6 :
                        System.out.println("*** SESIÓN FINALIZADA ***");
                        break;
                    default:
                        System.out.println("LA OPCIÓN INGRESADA ES INVÁLIDA");
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                entrada.next();
            }
        } while (respuesta != 6);
        
        
        
    }
}

