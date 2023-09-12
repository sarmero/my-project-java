/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author USER
 */
public class Hangar {
    private  String nombreHang;
    private String nombreAerolinea;
    private  Avion avion;

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    
    public String getNombreHang() {
        return nombreHang;
    }

    public void setNombreHang(String nombreHang) {
        this.nombreHang = nombreHang;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    
    
}
