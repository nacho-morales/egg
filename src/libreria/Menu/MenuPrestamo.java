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
import libreria.entidades.Prestamo;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.LibroDAO;
import libreria.persistencia.PrestamoDAO;
import libreria.servicios.AutorServicio;
import libreria.servicios.PrestamoServicios;

/**
 *
 * @author ignacio
 */
public class MenuPrestamo {
    
    Scanner entrada = new Scanner(System.in);
    PrestamoServicios ps = new PrestamoServicios();
    PrestamoDAO prestamoDAO = new PrestamoDAO();
    LibroDAO libroDAO = new LibroDAO();
    
    
public void menuPrincipalPrestamo() throws Exception {
    
Integer respuesta = 0;
        do {
            try {
                System.out.println("ELIJA UNA OPCIÓN");
                System.out.println("1. CREAR PRESTAMO");
                System.out.println("2. MODIFICAR PRESTAMO");
                System.out.println("3. DEVOLVER PRESTAMO");
                System.out.println("4. MOSTRAR PRESTAMO");
                System.out.println("5. MOSTRAR LISTA PRESTAMOS");                
                System.out.println("6. SALIR");

                respuesta = entrada.nextInt();

                switch (respuesta) {
                    case 1:
                        Prestamo prestamo = ps.crearPrestamo();
                        prestamoDAO.GuardarPrestamo(prestamo);
                        libroDAO.ModificarCantidadLibro(prestamo.getLibro());
                        break;
                    case 2:
                        prestamoDAO.ModificarPrestamo();
                        break;
                    case 3:
                        prestamoDAO.devolverPrestamo();
                        break;
                    case 4:
                        
                       Prestamo prestamo2 = prestamoDAO.BuscarPrestamo();
                        System.out.println(prestamo2.toString());
                        
                        break;
                    case 5:
                        
                        
                         List<Prestamo> listaPrestamo = prestamoDAO.listarPrestamos();
                        for (int i = 0; i < listaPrestamo.size(); i++) {
                            System.out.println(listaPrestamo.get(i).toString());
                                   
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
