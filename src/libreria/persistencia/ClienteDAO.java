/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;

/**
 *
 * @author ignacio
 */
public class ClienteDAO {
    
    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();
    Scanner entrada = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");

    EntityManager em = emf.createEntityManager();

    public void GuardarCliente(Cliente cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("no se selecciono un cliente");
            }

            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }
    
    public Cliente BuscarCliente() throws Exception {
        System.out.println("ingrese el id");

        Cliente cliente = em.find(Cliente.class, entrada.nextInt());

                
        return cliente;
    }
    
    public void ModificarCliente() throws Exception {
        try {
            System.out.println("ingrese el id");
            Cliente cliente = em.find(Cliente.class, entrada.nextInt());
            if (cliente == null) {
                throw new Exception("no se selecciono un cliente");
            }

            System.out.println("----------Modificar Cliente----------");
            System.out.println("Que desea modfiicar ?");
            System.out.println("1) Id");
            System.out.println("2) Documento");
            System.out.println("4) Nombre");
            System.out.println("5) Apellido");
            System.out.println("6) Telefono");
            System.out.println("7) Salir");
            
            Integer respuesta = entrada.nextInt();

            switch (respuesta) {

                case 1:
                    System.out.println("ingrese el nuevo id ");

                    cliente.setId(entrada.nextInt());
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo documento ");
                      entrada.nextLine();
                    cliente.setDocumento(entrada.nextLong());
                    break;
                case 3 : 
                     System.out.println("Ingrese el nuevo nombre ");
                    entrada.nextLine();
                    cliente.setNombre(entrada.nextLine());
                     break;
                case 4 :
                     System.out.println("Ingrese el nuevo apellido ");
                    entrada.nextLine();
                    cliente.setApellido(entrada.nextLine());
                     break;
                case 5 :
                     System.out.println("Ingrese el nuevo telefono ");
                    entrada.nextLine();
                    cliente.setTelefono(entrada.nextLine());
                     break;
                case 6:
                    break;

            }

            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarCliente() throws Exception {
        try {
            System.out.println("ingrese el id");
            Cliente cliente = em.find(Cliente.class, entrada.nextInt());
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar un Cliente");
        }
    }
    
     public List<Cliente> listarClientes(){
        return em.createQuery("SELECT c FROM Cliente c").getResultList();
    }
     
     public Cliente buscarClienteXDni(Long dni) {
         return (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.documento = :dni").setParameter("dni",dni).getSingleResult();
     }
}

