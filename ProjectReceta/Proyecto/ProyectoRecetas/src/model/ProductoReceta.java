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
public class ProductoReceta implements Serializable{
    
    private static final long serialVersionUID = 0x1C7E3CF;
    
    private int codProducto;
    private double cantidad;

    public ProductoReceta() {
        codProducto = 0;
        cantidad = 0;
    }

    public ProductoReceta(int codProducto, double cantidad) {
        this.codProducto = codProducto;
        this.cantidad = cantidad;
    }

    
    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
