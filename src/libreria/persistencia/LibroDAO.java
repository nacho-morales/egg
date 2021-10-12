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
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;

/**
 *
 * @author ignacio
 */
public class LibroDAO {

    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();
    Scanner entrada = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");

    EntityManager em = emf.createEntityManager();

    public void GuardarLibro(Libro libro) throws Exception {
        try {
            if (libro == null) {
                throw new Exception("no se selecciono un libro");
            }

            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    public Libro BuscarLibro() throws Exception {
        System.out.println("ingrese el id");

        Libro libro = em.find(Libro.class, entrada.nextLong());

                
        return libro;
    }

    public void ModificarLibro() throws Exception  {
        try {
            System.out.println("ingrese el id");
            Libro libro = em.find(Libro.class, entrada.nextLong());
            if (libro == null) {
                throw new Exception("no se selecciono un libro");
            }

            System.out.println("----------Modificar Libro----------");
            System.out.println("Que desea modfiicar ?");
            System.out.println("1) Isbn");
            System.out.println("2) Titulo");
            System.out.println("3) Anio");
            System.out.println("4) Ejemplares prestados");
            System.out.println("5) Ejemplares restantes");
            System.out.println("6)Autor");
            System.out.println("7)Editorial");
            System.out.println("8)Salir"
                    + "");

            Integer respuesta = entrada.nextInt();

            switch (respuesta) {

                case 1:
                    System.out.println("ingrese el nuevo isbn ");

                    libro.setIsbn(entrada.nextLong());
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo titulo ");

                    libro.setTitulo(entrada.nextLine());
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo anio ");

                    libro.setAnio(entrada.nextInt());
                    break;
                case 4:
                    System.out.println("Ingrese los ejemplares prestaods ");

                    libro.setEjemplaresPrestados(entrada.nextInt());
                    break;
                case 5:
                    System.out.println("Ingrese los ejemplares restantes ");

                    libro.setEjemplaresRestantes(entrada.nextInt());
                    break;
                case 6:
                    System.out.println("Ingrese el nuevo autor ");

                    libro.setAutor(as.crearAutor());
                    break;
                case 7:
                    System.out.println("Ingrese la nuevo editorial ");

                    libro.setEditorial(es.crearEditorial());
                    break;
                case 8:

                    break;
            }

            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error sistema");
        }

    }

    public void eliminarLibro() throws Exception {
        try {
            System.out.println("ingrese el id");
            Libro libro = em.find(Libro.class, entrada.nextLong());
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar un libro");
        }
    }
    
     public List<Libro> listarLibros(){
        return em.createQuery("SELECT l FROM Libro l").getResultList();
    }
     
     public void ModificarCantidadLibro(Libro libro) throws Exception{
         
         try {
             System.out.println("Se ha modificado la cantidad de ejemplares del libro");
             libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
             libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
                  
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error sistema");
        }

    }
     
     
     public void ModificarCantidadLibroxDevolucion(Libro libro) throws Exception{
         
         try {
             System.out.println("Se ha modificado la cantidad de ejemplares del libro");
             libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() - 1);
             libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() +1 );
                  
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error sistema");
        }

    }
     
}
