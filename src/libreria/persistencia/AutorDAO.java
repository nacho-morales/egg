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

/**
 *
 * @author ignacio
 */
public class AutorDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    Scanner entrada = new Scanner(System.in);
    EntityManager em = emf.createEntityManager();

    public void GuardarAutor(Autor autor) throws Exception {
        try {
            if (autor == null) {
                throw new Exception("no se selecciono un AUTOR");
            }

            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    public Autor BuscarAutor() throws Exception {

        System.out.println("ingrese el id");

        Autor autor = em.find(Autor.class, entrada.nextInt());

        return autor;
    }

    public void ModificarAutor() throws Exception {
        try {
            System.out.println("ingrese el id");
            Autor autor = em.find(Autor.class, entrada.nextInt());
            if (autor == null) {
                throw new Exception("no se selecciono un autor");
            }

            System.out.println("----------Modificar Autor----------");
            System.out.println("Que desea modfiicar ?");
            System.out.println("1) Id");
            System.out.println("2) Nombre");
            System.out.println("3) Salir");

            Integer respuesta = entrada.nextInt();

            switch (respuesta) {

                case 1:
                    System.out.println("ingrese el nuevo id ");

                    autor.setId(entrada.nextInt());
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo nobmre ");
                    entrada.nextLine();
                    autor.setNombre(entrada.nextLine());
                    break;
                case 3:
                    break;

            }

            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarAutor() throws Exception {
        try {
            System.out.println("ingrese el id");
            Autor autor = em.find(Autor.class, entrada.nextInt());
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar un autor");
        }
    }
    
     public List<Autor> listarAutores() {
        return em.createQuery("SELECT a FROM Autor a").getResultList();
    }
}
