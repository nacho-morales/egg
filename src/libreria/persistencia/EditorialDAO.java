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
import org.eclipse.persistence.sdo.helper.extension.SDOUtil;

/**
 *
 * @author ignacio
 */
public class EditorialDAO {

    Scanner entrada = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");

    EntityManager em = emf.createEntityManager();

    public void GuardarEditorial(Editorial editorial) throws Exception {
        try {
            if (editorial == null) {
                throw new Exception("no se selecciono un editorial");
            }

            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    public void ModificarEditorial() throws Exception {
        try {
            System.out.println("ingrese el id");
            Editorial editorial = em.find(Editorial.class, entrada.nextInt());
            if (editorial == null) {
                throw new Exception("no se selecciono un editorial");
            }

            System.out.println("----------Modificar Editorial----------");
            System.out.println("Que desea modfiicar ?");
            System.out.println("1) Id");
            System.out.println("2) Nombre");
            System.out.println("3) Salir");

            Integer respuesta = entrada.nextInt();

            switch (respuesta) {

                case 1:
                    System.out.println("ingrese el nuevo id ");

                    editorial.setId(entrada.nextInt());
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo nobmre ");

                    entrada.nextLine();

                    editorial.setNombre(entrada.nextLine());
                    break;
                case 3:
                    break;

            }

            em.getTransaction().begin();
            em.merge(editorial);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    public Editorial buscarEditorial() {
        System.out.println(" Ingrese el id");
                
        Integer numero = entrada.nextInt();
        Editorial editorial = em.find(Editorial.class, numero);

        
        return editorial;
    }

    public void eliminarEditorial() throws Exception {
        try {
            System.out.println("ingrese el id");
            Editorial editorial = em.find(Editorial.class, entrada.nextInt());
            em.getTransaction().begin();
            em.remove(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar una editorial");
        }
    }

    public List<Editorial> listarEditoriales() {
        return em.createQuery("SELECT e FROM Editorial e").getResultList();
    }

}
