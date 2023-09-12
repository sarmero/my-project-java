/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.Opcion.fecha;
import static controller.Opcion.ordenarArrayFechaRev;
import java.io.Serializable;
import java.util.ArrayList;
import model.Despensa;

/**
 *
 * @author USER
 */
public class ListaDespensa implements Serializable {

    private static final long serialVersionUID = 0x1C7E32;
    private ArrayList<Despensa> listaEntrada;
    private ArrayList<Despensa> listaPerdida;
    private ArrayList<Object[]> listaProductosBajas;
    private ArrayList<Object[]> listaProductosEntrada;

    public ListaDespensa() {
        listaEntrada = new ArrayList<>();
        listaPerdida = new ArrayList<>();
        listaProductosBajas = new ArrayList<>();
        listaProductosEntrada = new ArrayList<>();
    }

    public ArrayList<Despensa> getListaPerdida() {
        return listaPerdida;
    }

    public void setListaPerdida(ArrayList<Despensa> listaPerdida) {
        this.listaPerdida = listaPerdida;
    }

    public ArrayList<Despensa> getListaEntrada() {
        return listaEntrada;
    }

    public void setListaEntrada(ArrayList<Despensa> listaEntrada) {
        this.listaEntrada = listaEntrada;
    }

    public Despensa entrada(int idx) {
        return listaEntrada.get(idx);
    }

    public Despensa perdida(int idx) {
        return listaPerdida.get(idx);
    }

    public void agregarAlmacen(Despensa almacen) {
        almacen.setFecha(fecha());
        listaEntrada.add(almacen);
        sumarProductos(listaProductosEntrada, despensa(almacen, true));
    }

    public void agregarBaja(Despensa almacen) {
        almacen.setFecha(fecha());
        listaPerdida.add(almacen);
        sumarProductos(listaProductosBajas, despensa(almacen, false));
    }

    public void editarEntrada(int idx, Despensa almacen) {
        editarDesProducto(idx, almacen, true);
        listaEntrada.set(idx, almacen);
    }

    public void eliminarEntrada(int idx) {
        eliminarDesProducto(idx, true);
        listaEntrada.get(idx);
    }

    public void eliminarAllEntrada() {
        listaEntrada.removeAll(listaEntrada);
        listaProductosEntrada = new ArrayList<>();
    }

    public void editarBaja(int idx, Despensa almacen) {
        editarDesProducto(idx, almacen, false);
        listaPerdida.set(idx, almacen);
    }

    public void eliminarBaja(int idx) {
        eliminarDesProducto(idx, false);
        listaPerdida.get(idx);
    }

    public void eliminarAllBaja() {
        listaPerdida.removeAll(listaEntrada);
        listaProductosBajas = new ArrayList<>();
    }

    public ArrayList<Object[]> obtenerListaDespensa(boolean ban, String fecha, int producto, ListaProducto listaProducto) {
        ArrayList<Object[]> list = new ArrayList<>();
        ArrayList<Despensa> despensa;
        if (ban) {
            despensa = listaEntrada;
        } else {
            despensa = listaPerdida;
        }

        if (fecha.equals("") && producto == 0) {
            for (int i = 0; i < despensa.size(); i++) {
                list.add(despensa(despensa.get(i).despensa()));
            }
            ordenarArrayFechaRev(list, 2);

        } else if (fecha.equals("") && producto != 0) {
            for (int i = 0; i < despensa.size(); i++) {
                if (despensa.get(i).getProducto().getNombre().equals(listaProducto.getListaProducto().get(producto - 1).getNombre())) {
                    list.add(despensa(despensa.get(i).despensa()));
                }
            }
            ordenarArrayFechaRev(list, 2);

        } else if (!fecha.equals("") && producto == 0) {
            for (int i = 0; i < despensa.size(); i++) {
                if (despensa.get(i).getFecha().equals(fecha)) {
                    list.add(despensa(despensa.get(i).despensa()));
                }

            }
        } else if (!fecha.equals("") && producto != 0) {
            for (int i = 0; i < despensa.size(); i++) {
                if (despensa.get(i).getProducto().getNombre().equals(listaProducto.getListaProducto().get(producto - 1).getNombre())
                        && despensa.get(i).getFecha().equals(fecha)) {
                    list.add(despensa(despensa.get(i).despensa()));
                }
            }
        }

        return list;
    }

    private Object[] despensa(Object[] despensa) {
        Object[] des = new Object[3];
        des[0] = despensa[0] + " (" + Opcion.formatoNumero((double) despensa[1]) + "g)";
        des[1] = Opcion.formatoNumero((double) despensa[2]);
        des[2] = despensa[3];
        return des;
    }

    public double obtenerDespensa(boolean ban, String nombre) {
        ArrayList<Despensa> despensa = ban ? listaEntrada : listaPerdida;
        double n = 0;

        for (int i = 0; i < despensa.size(); i++) {
            if (nombre.equals(despensa.get(i).getProducto().getNombre())) {
                n += ban ? despensa.get(i).getCantidad() * Double.valueOf(despensa.get(i).getProducto().getContenido() + "")
                        : despensa.get(i).getCantidad();
            }
        }

        return n;
    }

    public void precargarDespensa() {
        listaProductosBajas = new ArrayList<>();
        listaProductosEntrada = new ArrayList<>();

        for (int i = 0; i < listaEntrada.size(); i++) {
            sumarProductos(listaProductosEntrada, despensa(listaEntrada.get(i), true));
        }

        for (int i = 0; i < listaPerdida.size(); i++) {
            sumarProductos(listaProductosBajas, despensa(listaPerdida.get(i), false));
        }
    }

    private Object[] despensa(Despensa despensa, boolean ban) {
        Object[] des = new Object[2];
        des[0] = despensa.getProducto().getNombre();
        des[1] = ban ? despensa.getCantidad() * Double.valueOf(despensa.getProducto().getContenido() + "")
                : despensa.getCantidad();
        return des;
    }

    private void sumarProductos(ArrayList<Object[]> list, Object[] des) {
        boolean ban;

        ban = false;
        for (int l = 0; l < list.size(); l++) {
            if (list.get(l)[0].equals(des[0])) {
                list.get(l)[1] = (double) list.get(l)[1] + (double) des[1];
                ban = true;
                break;
            }
        }

        if (ban == false) {
            list.add(des);
        }

    }

    public double productosDespensa(boolean ban, String nombre) {
        ArrayList<Object[]> despensa = ban ? listaProductosEntrada : listaProductosBajas;
        for (int i = 0; i < despensa.size(); i++) {
            if (nombre.equals(despensa.get(i)[0])) {
                return (double) despensa.get(i)[1];
            }
        }

        return 0;
    }

    private void editarDesProducto(int idx, Despensa despensa, boolean ban) {
        ArrayList<Despensa> list = ban ? listaEntrada : listaPerdida;
        despensa.setCantidad(despensa.getCantidad() - list.get(idx).getCantidad());
        Object[] des = despensa(despensa, ban);
        sumarProductos(ban ? listaProductosEntrada : listaProductosBajas, des);
    }

    private void eliminarDesProducto(int idx, boolean ban) {
        ArrayList<Despensa> list = ban ? listaEntrada : listaPerdida;
        Despensa despensa = new Despensa();
        despensa.setCantidad(list.get(idx).getCantidad() * -1);
        despensa.setProducto(list.get(idx).getProducto());
        Object[] des = despensa(despensa, ban);
        sumarProductos(ban ? listaProductosEntrada : listaProductosBajas, des);
    }

}
