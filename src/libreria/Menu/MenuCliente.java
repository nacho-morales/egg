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
import libreria.entidades.Cliente;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.ClienteDAO;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicios;

/**
 *
 * @author ignacio
 */
public class MenuCliente {

    Scanner entrada = new Scanner(System.in);
    ClienteServicios cs = new ClienteServicios();
    ClienteDAO clienteDAO = new ClienteDAO();

    public void menuPrincipalCliente() throws Exception {

        Integer respuesta = 0;
        do {
            try {
                System.out.println("ELIJA UNA OPCIÓN");
                System.out.println("1. CREAR CLIENTE");
                System.out.println("2. MODIFICAR CLIENTE");
                System.out.println("3. ELIMINAR CLIENTE");
                System.out.println("4. BUSCAR CLIENTE X ID");
                System.out.println("5. BUSCAR CLIENTE X DNI");
                System.out.println("6. MOSTRAR LISTA CLIENTE");
                System.out.println("7. SALIR");

                respuesta = entrada.nextInt();

                switch (respuesta) {
                    case 1:
                        Cliente cliente = cs.crearCliente();
                        clienteDAO.GuardarCliente(cliente);

                        break;
                    case 2:
                        clienteDAO.ModificarCliente();
                        break;
                    case 3:
                        clienteDAO.eliminarCliente();
                        break;
                    case 4:

                        Cliente cliente2 = clienteDAO.BuscarCliente();
                        System.out.println(cliente2.toString());
                        break;
                    case 5:
                        cs.buscarClienteXDni();
                        break;
                    case 6:
                        
                         List<Cliente> listaClientes = clienteDAO.listarClientes();;
                        for (int i = 0; i < listaClientes.size(); i++) {
                            System.out.println(listaClientes.get(i).toString());
                                   
                        }
                        break;
                        
                    case 7 :
                        System.out.println("*** SESIÓN FINALIZADA ***");
                        break;
                     
                    default:
                        System.out.println("LA OPCIÓN INGRESADA ES INVÁLIDA");
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                entrada.next();
            }
        } while (respuesta != 7);

    }
}
