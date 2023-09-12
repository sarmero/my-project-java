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
public class Receta implements Serializable {

    private String nombreReceta;
    private ArrayList<ProductoReceta> productos;
    private String preparacion;
    private String ruta;
    private String fecha;
    private boolean complemento;
    private double cantidad;
    private int codigo;

    public Receta() {
        nombreReceta = "";
        productos = new ArrayList<>();
        preparacion = "";
        ruta = "";
        fecha = "";
        complemento = false;
        cantidad = 0;
        codigo = 11;
    }

    public Object[] receta() {
        Object[] receta = new Object[9];
        receta[0] = nombreReceta;
        receta[1] = productos;
        receta[2] = preparacion;
        receta[3] = productos;
        receta[4] = ruta;
        receta[5] = complemento;
        receta[6] = cantidad;
        receta[7] = codigo;
        receta[8] = fecha;
        return receta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codReceta) {
        this.codigo = codReceta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isComplemento() {
        return complemento;
    }

    public void setComplemento(boolean complemento) {
        this.complemento = complemento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public ArrayList<ProductoReceta> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductoReceta> codProductos) {
        this.productos = codProductos;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

}
