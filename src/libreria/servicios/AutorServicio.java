/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Autor;

/**
 *
 * @author ignacio
 */
public class AutorServicio {
 Scanner entrada = new Scanner(System.in);
    public Autor crearAutor() {
        System.out.println("ingrese el id");
        Integer id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("ingrese el nombre");
        String nombre= entrada.nextLine();
        Boolean alta = true;
        
        return new Autor(id,nombre,alta);
    }
    
    
}
