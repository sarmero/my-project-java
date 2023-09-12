/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.annotation.Generated;
import jdk.nashorn.internal.objects.annotations.Getter;

/**
 *
 * @author USER
 */
public class Ecuacion {

    private ArrayList<Float> x;
    private String signo;
    private float resultado;

    public Ecuacion(ArrayList<Float> x, String signo, float resultado) {
        this.x = x;
        this.signo = signo;
        this.resultado = resultado;
    }

    public Ecuacion() {
        signo = "";
        resultado = 0;
        x = new ArrayList();
    }

   

    public ArrayList<Float> getX() {
        return x;
    }

    public void setX(ArrayList<Float> x) {
        this.x = x;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public String ecuacion() {
        String ecuacion = "";
        String Xn = "";
        for (int i = 0; i < x.size(); i++) {
            if (i > 0) {
                if (x.get(i) < 0) {
                    Xn = "-" + x.get(i) + "X"+i;
                } else {
                    Xn = "+" + x.get(i) + "X"+i;
                }
            }else{
                Xn = x.get(i) + "X"+i;
            }

            ecuacion = ecuacion + Xn;
        }

        return ecuacion;
    }
}
