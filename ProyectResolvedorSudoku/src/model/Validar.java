/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Sebastian
 */
public class Validar {

    private void validarsoloLetra(JTextField campo) {

        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int k = (int) e.getKeyChar();
                if (Character.isDigit(c) || k == 64) {
                    e.consume();
                    System.out.println("car " + c);

                }

            }

        });

    }
    
    public void limitarCaracteres(JTextField campo,int cantidad) {

        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int tam = campo.getText().length();
                if (cantidad <= tam ) {
                    e.consume();
                    System.out.println(" lim num " + c);
                    

                }

            }

        });

    }
    
    public void validarNumeros(JTextField campo) {
        
        
        
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) ) {
                    e.consume();
                    System.out.println("num " + c);

                }

            }

        });
        
        

    }

}
