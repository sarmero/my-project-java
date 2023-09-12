/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.Opcion.codigo;
import static controller.Opcion.fecha;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Producto;
import model.ProductoReceta;

/**
 *
 * @author USER
 */
public class ListaProducto implements Serializable {

    private static final long serialVersionUID = 0x1C7E3A;
    private ArrayList<Producto> listaProducto;

    public ListaProducto() {
        listaProducto = new ArrayList<>();
    }

    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public void agregarProducto(Producto producto) {
        if (producto.getCodigo() == 11) {
            producto.setCodigo(codigo(listacodigo()));
            producto.setFecha(fecha());
        }

        listaProducto.add(producto);
        listaProducto.sort((Producto o1, Producto o2) -> o1.getNombre().compareTo(o2.getNombre()));
    }

    private ArrayList<Integer> listacodigo() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < listaProducto.size(); i++) {
            list.add(listaProducto.get(i).getCodigo());
        }

        return list;
    }

    public int codigoProducto(String nomProdducto) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getNombre().equals(nomProdducto)) {
                return listaProducto.get(i).getCodigo();
            }
        }
        return 0;
    }

    public String obtenerProductoNombre(int codigo) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getCodigo() == codigo) {
                return listaProducto.get(i).getNombre();
            }
        }
        return null;
    }

    public Producto obtenerProducto(int codigo) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getCodigo() == codigo) {
                return listaProducto.get(i);
            }
        }
        return null;
    }

    public int obtenerIndiceProducto(String nomProdducto) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getNombre().equals(nomProdducto)) {
                return i;
            }
        }
        return -1;
    }

    public Object[] obtenerproducto(String nomProdducto) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getNombre().equals(nomProdducto)) {
                return listaProducto.get(i).producto();
            }
        }

        return null;
    }

    public int obtenerCodigoProducto(String nomProdducto) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getNombre().equals(nomProdducto)) {
                return listaProducto.get(i).getCodigo();
            }
        }
        return -1;
    }

    public void editarProducto(Producto producto) {
        producto.setFecha(fecha());
        for (int i = 0; i < listaProducto.size(); i++) {
            if (producto.getCodigo() == listaProducto.get(i).getCodigo()) {
                listaProducto.set(i, producto);
            }
        }
        listaProducto.sort((Producto o1, Producto o2) -> o1.getNombre().compareTo(o2.getNombre()));
    }

    public void eliminarProducto(String nombre) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getNombre().equals(nombre)) {
                listaProducto.get(i).setVigente(false);
                break;
            }
        }
    }

    public void eliminarAllProducto() {
        for (int i = 0; i < listaProducto.size(); i++) {
            listaProducto.get(i).setVigente(false);
        }
    }

    public Object[] obtenerproducto(int idx) {
        return listaProducto.get(idx).producto();
    }

    public Object[] producto(ProductoReceta prod) {
        Object[] producto = new Object[3];

        for (int j = 0; j < listaProducto.size(); j++) {
            if (prod.getCodProducto() == listaProducto.get(j).getCodigo()) {
                producto[0] = listaProducto.get(j).getNombre();
                producto[1] = prod.getCantidad();
                producto[2] = listaProducto.get(j).getPrecio()
                        * prod.getCantidad() / ((double) listaProducto.get(j).getContenido());
                return producto;
            }
        }

        return null;
    }

    public void listaBoxProductos(JComboBox cbxLista) {
        listaProducto.stream().forEach(list -> {
            if (list.isVigente() != false) {
                cbxLista.addItem(list.getNombre());
            }
        });
    }

    public int cantidadProducto() {
        int n = 0;
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).isVigente() != false) {
                n++;
            }
        }

        return n;
    }

    public void listaBoxProductosMedida(JComboBox cbxLista) {
        listaProducto.stream().forEach(list -> {
            if (list.isVigente() != false) {
                cbxLista.addItem(list.getNombre() + "  (" + Opcion.formatoNumero(list.getContenido()) + "g)");
            }
        });
    }

    public Producto buscarProducto(String nombre) {
        int idx;

        idx = obtenerIndiceProducto(nombre);
        if (idx != -1) {
            return listaProducto.get(idx);
        }
        return null;
    }

    public String obtenerCostoProducto(String nombre, double medida) {
        for (int i = 0; i < listaProducto.size(); i++) {
            if (nombre.equals(listaProducto.get(i).getNombre())) {
                return (listaProducto.get(i).getPrecio() * medida / listaProducto.get(i).getContenido()) + "";
            }
        }

        return "";
    }

    public ArrayList<String> listaProductos() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).isVigente() != false) {
                list.add(listaProducto.get(i).getNombre());
            }
        }

        return list;
    }

}
