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
import libreria.persistencia.AutorDAO;
import libreria.servicios.AutorServicio;

/**
 *
 * @author ignacio
 */
public class MenuAutor {
    Scanner entrada = new Scanner(System.in);
    AutorServicio as = new AutorServicio();
    AutorDAO autorDAO = new AutorDAO();
    
public void menuPrincipalAutor() throws Exception {
    
Integer respuesta = 0;
        do {
            try {
                System.out.println("ELIJA UNA OPCIÓN");
                System.out.println("1. CREAR AUTOR");
                System.out.println("2. MODIFICAR AUTOR");
                System.out.println("3. ELIMINAR AUTOR");
                System.out.println("4. MOSTRAR AUTOR");
                System.out.println("5. MOSTRAR LISTA AUTORES");
                System.out.println("6. SALIR");

                respuesta = entrada.nextInt();

                switch (respuesta) {
                    case 1:
                        Autor autor = as.crearAutor();
                        autorDAO.GuardarAutor(autor);
                        
                        break;
                    case 2:
                        autorDAO.ModificarAutor();
                        break;
                    case 3:
                        autorDAO.eliminarAutor();
                        break;
                    case 4:
                        
                       Autor autor2 = autorDAO.BuscarAutor();
                        System.out.println(autor2.toString());
                        
                        break;
                    case 5:
                        List<Autor> listaAutores = autorDAO.listarAutores();
                        for (int i = 0; i < listaAutores.size(); i++) {
                            System.out.println(listaAutores.get(i).toString());
                                   
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
