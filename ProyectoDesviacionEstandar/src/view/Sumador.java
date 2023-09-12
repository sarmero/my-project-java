/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aula_info
 */
public class Sumador extends Thread {

    ArrayList<Double> vec;
    double sum;
    int li, ls;
   

    public Sumador(ArrayList<Double> vec, int li, int ls) {
        this.vec = vec;
        this.li = li;
        this.ls = ls;
        
    }

    @Override
    public void run() {
        for (int i = li; i < ls; i++) {
            sum += Math.pow(vec.get(i), 2);
            //System.out.println(sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sumador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
