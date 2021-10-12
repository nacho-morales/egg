/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Editorial;

/**
 *
 * @author ignacio
 */
public class EditorialServicio {
Scanner entrada = new Scanner(System.in);
    public Editorial crearEditorial() {
        Integer id = entrada.nextInt();
        String nombre = entrada.nextLine();
        boolean alta = true;
        return new Editorial(id, nombre, alta);
    }

}
