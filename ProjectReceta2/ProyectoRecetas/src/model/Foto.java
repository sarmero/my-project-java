/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Foto implements Serializable {

    private String ruta;
    private String detalle;
    private ArrayList<Object[]> referenciaReceta;
    private ArrayList<ProductoPedido> otProductos;
    private String fecha;
    private double medReferencia;

    public Foto() {
        ruta = "";
        detalle = "";
        referenciaReceta = new ArrayList<>();
        otProductos = new ArrayList<>();
        medReferencia = 0;
        fecha = "0/00/0000";
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMedReferencia() {
        return medReferencia;
    }

    public void setMedReferencia(double medReferencia) {
        this.medReferencia = medReferencia;
    }

    public ArrayList<ProductoPedido> getOtProductos() {
        return otProductos;
    }

    public void setOtProductos(ArrayList<ProductoPedido> otProductos) {
        this.otProductos = otProductos;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public ArrayList<Object[]> getReferenciaReceta() {
        return referenciaReceta;
    }

    public void setReferenciaReceta(ArrayList<Object[]> referenciaReceta) {
        this.referenciaReceta = referenciaReceta;
    }

    
}
