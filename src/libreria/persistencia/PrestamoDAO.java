/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicios;
import libreria.servicios.EditorialServicio;

/**
 *
 * @author ignacio
 */
public class PrestamoDAO {

    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();
    ClienteServicios cs = new ClienteServicios();
    LibroDAO libroDAO = new LibroDAO();
    Scanner entrada = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");

    EntityManager em = emf.createEntityManager();

    public void GuardarPrestamo(Prestamo prestamo) throws Exception {
        try {
            if (prestamo == null) {
                throw new Exception("no se selecciono un prestamo");
            }

            em.getTransaction().begin();
            em.persist(prestamo);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    public Prestamo BuscarPrestamo() throws Exception {
        System.out.println("ingrese el id");

        Prestamo prestamo = em.find(Prestamo.class, entrada.nextInt());
        
        return prestamo;
    }

    public void ModificarPrestamo() throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("ingrese el id");
            Prestamo prestamo = em.find(Prestamo.class, entrada.nextInt());
            if (prestamo == null) {
                throw new Exception("no se selecciono un prestamo");
            }

            System.out.println("----------Modificar Prestamo----------");
            System.out.println("Que desea modfiicar ?");
            System.out.println("1) ID");
            System.out.println("2) Fecha prestamo");
            System.out.println("3) Fecha devolucion");
            System.out.println("4) Libro ");
            System.out.println("5) Cliente ");
            System.out.println("6)Salir"
                    + "");

            Integer respuesta = entrada.nextInt();

            switch (respuesta) {

                case 1:
                    System.out.println("ingrese el nuevo id ");

                    prestamo.setId(entrada.nextInt());
                    break;
                case 2:
                    System.out.println("Ingrese la nueva fecha de prestamo ");
                    String fechauno = entrada.nextLine();
                    Date fechaPrestamo = formato.parse(fechauno);
                    prestamo.setFechaPrestamo(fechaPrestamo);
                    break;
                case 3:
                    System.out.println("Ingrese la nueva fecha de devolucion ");
                    String fechados = entrada.nextLine();
                    Date fechaDevolucion = formato.parse(fechados);
                    prestamo.setFechaDevolucion(fechaDevolucion);
                    break;
                case 4:
                    System.out.println("Ingrese el libro ");

                    prestamo.setLibro(libroDAO.BuscarLibro());
                    break;
                case 5:
                    System.out.println("Ingrese el cliente ");
                    
                    prestamo.setCliente(cs.buscarClienteXDni());
                    break;
                
                case 6:

                    break;
            }

            em.getTransaction().begin();
            em.merge(prestamo);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error sistema");
        }

    }
    
    public void devolverPrestamo() throws Exception {
        try {
            
            Cliente cliente = cs.buscarClienteXDni();
            
           Integer id = cliente.getId();
            System.out.println("sep");
            Prestamo prestamo = (Prestamo) em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente = :cliente").setParameter("cliente",cliente).getSingleResult();
            libroDAO.ModificarCantidadLibroxDevolucion(prestamo.getLibro());
            em.getTransaction().begin();
            em.remove(prestamo);
            em.getTransaction().commit();
            
            System.out.println("Se ha devuelto el libr y por ende eliminado el prestamo");
        } catch (Exception e) {
            throw new Exception("Error al devolver un prestamo");
        }
    }
    
     public List<Prestamo> listarPrestamos(){
        return em.createQuery("SELECT p FROM Prestamo p").getResultList();
    }
}

