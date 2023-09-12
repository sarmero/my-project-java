/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Aerolinea implements Serializable {

    private Avion[] avion;
    private String nombreAero;

    public Avion[] getAvion() {
        return avion;
    }

    public void setAvion(Avion[] avion) {
        this.avion = avion;
    }

    public String getNombreAero() {
        return nombreAero;
    }

    public void setNombreAero(String nombreAero) {
        this.nombreAero = nombreAero;
    }

}
