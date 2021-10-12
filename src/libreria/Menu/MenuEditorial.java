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
import libreria.entidades.Editorial;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.EditorialDAO;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;

/**
 *
 * @author ignacio
 */
public class MenuEditorial {
    
Scanner entrada = new Scanner(System.in);
    EditorialServicio es = new EditorialServicio();
    EditorialDAO editorialDAO = new EditorialDAO();
    
public void menuPrincipalEditorial() throws Exception {
    
Integer respuesta = 0;
        do {
            try {
                System.out.println("ELIJA UNA OPCIÓN");
                System.out.println("1. CREAR EDITORIAL");
                System.out.println("2. MODIFICAR EDITORIAL");
                System.out.println("3. ELIMINAR EDITORIAL");
                System.out.println("4. MOSTRAR EDITORIAL");
                System.out.println("5. MOSTRAR LISTA EDITORIAL");
                System.out.println("6. SALIR");

                respuesta = entrada.nextInt();

                switch (respuesta) {
                    case 1:
                        Editorial editorial = es.crearEditorial();
                        editorialDAO.GuardarEditorial(editorial);
                        
                        break;
                    case 2:
                        editorialDAO.ModificarEditorial();
                        break;
                    case 3:
                        editorialDAO.eliminarEditorial();
                        break;
                    case 4:
                        
                       Editorial editorial2 = editorialDAO.buscarEditorial();
                        System.out.println(editorial2.toString());
                        
                        break;
                    case 5:
                        List<Editorial> mostrarEditoriales = editorialDAO.listarEditoriales();
                        for (int i = 0 ; i < mostrarEditoriales.size();++i) {
                        System.out.println(mostrarEditoriales.get(i).toString());
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
                entrada.next();            }
        } while (respuesta != 6);
        
        
        
    }
}