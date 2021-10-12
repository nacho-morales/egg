/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDAO;

/**
 *
 * @author ignacio
 */
public class ClienteServicios {
Scanner entrada = new Scanner(System.in);
ClienteDAO clienteDAO = new ClienteDAO();

public Cliente crearCliente(){
    
    System.out.println("ingrese el id del cliente");
    Integer id = entrada.nextInt();
    System.out.println("ingrese el documento del cliente");
    long documento = entrada.nextLong();
    System.out.println("ingrese el nombre del cliente");
    entrada.nextLine();
    String nombre = entrada.nextLine();
    System.out.println("ingrese el apellido del cliente");
    String apellido = entrada.nextLine();
    System.out.println("ingrese el telefono del cliente");
    String telefono = entrada.nextLine();

return new Cliente (id,documento,nombre,apellido,telefono);
}

public Cliente buscarClienteXDni () {
    System.out.println(" Ingrese su documento ");
    long dni = entrada.nextLong();
    
    Cliente cliente = clienteDAO.buscarClienteXDni(dni);
    
    
    System.out.println(cliente.toString());
    
    return cliente;
}
}
