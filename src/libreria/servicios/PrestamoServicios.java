/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.ClienteDAO;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author ignacio
 */
public class PrestamoServicios {

    Scanner entrada = new Scanner(System.in);
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    LibroDAO libroDAO = new LibroDAO();
    ClienteDAO clienteDAO = new ClienteDAO();

    public Prestamo crearPrestamo() throws ParseException, Exception {
        Boolean hay = false;;
        Libro libro;
        Boolean fechacorrecta = false;
        java.util.Date fechahoy = new Date();
        Date fechaPrestamo = null;
        System.out.println("Ingrese el id del prestamo");
        Integer id = entrada.nextInt();
        do {
            System.out.println("Ingrese la fecha del inicio del prestamo en fomrato dd/MM/yyyy ");
            entrada.nextLine();
            String fechauno = entrada.nextLine();
            fechaPrestamo = formato.parse(fechauno);
            if (fechaPrestamo.before(fechahoy)) {
                System.out.println("esa fecha ya paso");
                fechacorrecta = false;
            } else {
                fechacorrecta = true;
            }
        } while (fechacorrecta != true);

        System.out.println("Ingrese la fecha de devolucion");
        String fechados = entrada.nextLine();
        Date fechaDevolucion = formato.parse(fechados);

        System.out.println(" Ingrese el id del libro que desea ");
        do {
            libro = libroDAO.BuscarLibro();

            if (libro.getEjemplaresRestantes() == 0) {
                System.out.println(" Elija otro libro, no quedan ejemaplres de ese ");
                hay = false;
            } else
            { 
                hay = true;
            }
        } while (hay != true);
        System.out.println(" Ingrese el numero de documento de ud ");

        long dni = entrada.nextLong();
        Cliente cliente = clienteDAO.buscarClienteXDni(dni);

        return new Prestamo(id, fechaPrestamo, fechaDevolucion, libro, cliente);
    }

}
