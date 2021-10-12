/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ignacio
 */
public class Menu {

    Scanner entrada = new Scanner(System.in);
    MenuAutor ma = new MenuAutor();
    MenuCliente mc = new MenuCliente();
    MenuPrestamo mp = new MenuPrestamo();
    MenuLibro ml = new MenuLibro();
    MenuEditorial me = new MenuEditorial();
    public void menuPrincipal() throws Exception {
        Integer respuesta = 0;
        do {
            try {
                System.out.println("ELIJA UNA OPCIÓN");
                System.out.println("1. TRABAJAR SOBRE AUTOR");
                System.out.println("2. TRABAJAR SOBRE CLIENTE");
                System.out.println("3. TRABAJAR SOBRE LIBRO");
                System.out.println("4. TRABAJAR SOBRE EDITORIAL");
                System.out.println("5. TRABAJAR SOBRE PRESTAMO");
                System.out.println("6. SALIR");

                respuesta = entrada.nextInt();

                switch (respuesta) {
                    case 1:
                        ma.menuPrincipalAutor();
                        
                        break;
                    case 2:
                        mc.menuPrincipalCliente();
                        break;
                    case 3:
                        ml.menuPrincipalLibro();
                               
                        break;
                    case 4:
                        me.menuPrincipalEditorial();
                        
                        break;
                    case 5:
                        mp.menuPrincipalPrestamo();
                                break;
                    case 6:
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
