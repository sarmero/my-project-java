/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class SVC {
    private double monyEnvio;
    private int divisa;
    private ArrayList<Double> divisas;


    public SVC(double monyEnvio, int divisa) {
        this.monyEnvio = monyEnvio;
        this.divisa = divisa;
        divisas = new ArrayList();
    }

    public SVC() {
        this.monyEnvio = 1;
        this.divisa = 1;
        divisas = new ArrayList();
    }

    public void AgregarDivisas(double divisa){
        divisas.add(divisa);
    }
    
    public String CambioMony(){
        double n = monyEnvio/divisas.get(divisa);
        return String.valueOf(n);
    }

    public double getMonyEnvio() {
        return monyEnvio;
    }

    public void setMonyEnvio(double monyEnvio) {
        this.monyEnvio = monyEnvio;
    }

    public int getDivisa() {
        return divisa;
    }

    public void setDivisa(int divisa) {
        this.divisa = divisa;
    }
    
    
    
}
