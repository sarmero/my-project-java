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
public class Despensa implements Serializable{
    private Producto producto;
    private double cantidad;
    private String fecha;

    public Despensa() {
        producto = new Producto();
        cantidad = 0;
        fecha = "";
    }

    public Object[] despensa(){
        Object[] alm = new Object[4];
        alm[0]=producto.getNombre();
        alm[1]=producto.getContenido();
        alm[2]=cantidad;
        alm[3]=fecha;
        
        return alm;
    }
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
