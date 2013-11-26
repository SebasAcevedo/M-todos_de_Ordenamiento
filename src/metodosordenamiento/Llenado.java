/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metodosordenamiento;

import java.util.Random;

/**
 *
 * @author Hogar
 */
public class Llenado {
    public void set(int vaector[]){
        Random r  = new Random();
        int Limite = 20;
        for(int i=0; i<vaector.length; i++){
            vaector[i] = r.nextInt(Limite+1);
            System.out.println("Posicion "+(i+1)+": "+vaector[i]);
        }        
    }
}
