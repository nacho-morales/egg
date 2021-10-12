/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import javax.persistence.OneToOne;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author ignacio
 */
public class LibroServicio {

    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();
    LibroDAO libroDAO = new LibroDAO();
    public Libro crearLibro() {

        Long isbn = 765l;
        String titulo = " Harry Potter";
        Integer anio = 2005;
        Integer ejemplares = 100;
        Integer ejemplaresPrestados = 10;
        Integer ejemplaresRestantes = ejemplares - ejemplaresPrestados;
        Boolean alta = true;

        Autor autor = as.crearAutor();

        Editorial editorial = es.crearEditorial();

        return new Libro(isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, alta, autor, editorial);
    }
 
    public void BuscarLibro () throws Exception {
        Libro libro;
        libro = libroDAO.BuscarLibro();
        
        System.out.println(libro.toString());
        
    }
    
}
