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
public class ProductoPedido implements Serializable {

    private static final long serialVersionUID = 0x2A7E3CF;

    private int codProducto;
    private double cantidad;
    private double precio;

    public ProductoPedido() {
    }

    public Object[] productoPedido() {
        Object[] pro = new Object[3];
        pro[0] = codProducto;
        pro[0] = cantidad;
        pro[0] = precio;
        
        return pro;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
