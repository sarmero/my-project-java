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
public class Pedido implements Serializable {

    private Receta receta;
    private int codCliente;
    private double precioVenta;
    private double cantidad;
    private boolean estado;
    private ArrayList<ProductoPedido> otProductos;
    private String ruta;
    private String nota;
    private double valorGasto;
    private String fechaEntrega;
    private String fechaPedido;
    private int codigo;

    public Pedido() {
        receta = new Receta();
        codCliente = 0;
        precioVenta = 0;
        cantidad = 0;
        estado = false;
        otProductos = new ArrayList<>();
        ruta = "";
        nota = "";
        valorGasto = 0;
        fechaEntrega = "";
        fechaPedido = "";
        codigo = 0;
    }

    public Object[] Venta() {
        Object[] ven = new Object[12];

        ven[0] = receta.getNombreReceta();
        ven[1] = codCliente;
        ven[2] = precioVenta;
        ven[3] = cantidad;
        ven[4] = estado;
        ven[5] = otProductos;
        ven[6] = ruta;
        ven[7] = nota;
        ven[8] = valorGasto;
        ven[9] = fechaEntrega;
        ven[10] = fechaPedido;
        ven[11] = codigo;

        return ven;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

}
