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
public class Producto implements Serializable {

    private String nombre;
    private double contenido;
    private double precio;
    private String fecha;
    private int codigo;
    private String ruta;
    private boolean vigente;

    public Producto() {
        nombre = "";
        contenido = 0;
        precio = 0;
        fecha = "";
        codigo = 11;
        ruta = "";
        vigente = true;
    }

    public Producto(String nombre, int contenido, int precio, String fecha, int codigo, String ruta) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.precio = precio;
        this.fecha = fecha;
        this.codigo = codigo;
        this.ruta = ruta;
    }

    public Object[] producto() {
        Object[] pro = new Object[6];
        pro[0] = nombre;
        pro[1] = contenido;
        pro[2] = precio;
        pro[3] = fecha;
        pro[4] = ruta;
        pro[5] = vigente;

        return pro;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getContenido() {
        return contenido;
    }

    public void setContenido(double contenido) {
        this.contenido = contenido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
