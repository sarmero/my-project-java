/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.Opcion.codigo;
import static controller.Opcion.fecha;
import static controller.Opcion.formatContabilidad;
import static controller.Opcion.formatoNumero;
import static controller.Opcion.ordenarArrayString;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.ProductoReceta;
import model.Receta;

/**
 *
 * @author USER
 */
public class ListaCategoria implements Serializable {

    private static final long serialVersionUID = 0x1C8E35A;
    private ArrayList<Categoria> listaCategoria;
    private ArrayList<Object[]> recetaPedido;
    private ListaProducto listaProducto;

    public ListaCategoria() {
        listaCategoria = new ArrayList<>();
        recetaPedido = new ArrayList<>();
    }

    public ArrayList<Object[]> getRecetaPedido() {
        return recetaPedido;
    }

    public ArrayList<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(ArrayList<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public void listaProducto(ListaProducto listaProducto) {
        this.listaProducto = listaProducto;
    }

    public void agregarCategoria(Categoria categoria) {
        listaCategoria.add(categoria);
        listaCategoria.sort((Categoria o1, Categoria o2) -> o1.getCategoria().compareTo(o2.getCategoria()));
    }

    public ArrayList<Object[]> obtenerRecetaProductos(int indCocina, int indReceta, double medida) {

        if (indCocina > -1 && indReceta > -1) {
            if (listaCategoria.get(indCocina).getListaReceta().size() > 0) {
                Receta receta = listaCategoria.get(indCocina).getListaReceta().get(indReceta);
                return recetaProductos(receta, medida);
            }
        }

        return null;
    }

    public ArrayList<Object[]> recetaProductos(Receta receta, double medida) {
        ArrayList<Object[]> pro = new ArrayList();
        Object[] rece = new Object[3];
        for (int i = 0; i < receta.getProductos().size(); i++) {
            rece = listaProducto.producto(receta.getProductos().get(i));
            if (rece != null) {
                rece[1] = formatoNumero((double) rece[1] * medida);
                rece[2] = formatContabilidad((double) rece[2] * medida);
                pro.add(rece);
            }

        }

        return pro;
    }

    public ArrayList<Object[]> obtenerReceta(int indCocina) {
        ArrayList<Object[]> pro = new ArrayList();
        Object[] rece;
        Receta receta;
        if (listaCategoria.size() > 0 && indCocina >= 0) {
            for (int i = 0; i < listaCategoria.get(indCocina).getListaReceta().size(); i++) {
                rece = new Object[4];
                receta = listaCategoria.get(indCocina).getListaReceta().get(i);
                rece[0] = receta.getNombreReceta();
                rece[1] = formatoNumero(receta.getCantidad());
                rece[2] = formatContabilidad(obtenerCostoReceta(receta) * receta.getCantidad());
                rece[3] = receta.getFecha();
                pro.add(rece);
            }
        }
        return pro;
    }

    public double obtenerCostoReceta(Receta receta) {
        Object[] rece;
        double valor = 0;
        for (int i = 0; i < receta.getProductos().size(); i++) {
            rece = listaProducto.producto(receta.getProductos().get(i));
            if (rece != null) {
                valor += (double) rece[2];
            }
        }

        return valor;
    }

    public Receta obtenerRecet(int idxCategoria, int idxReceta) {
        return listaCategoria.get(idxCategoria).getListaReceta().get(idxReceta);
    }

    public Receta obtenerReceta(String nombre) {
        for (int i = 0; i < listaCategoria.size(); i++) {
            if (listaCategoria.get(i).receta(nombre) != null) {
                return listaCategoria.get(i).receta(nombre);
            }
        }
        
        return null;
    }

    public Object[] obtenerRecetaObject(String nombre) {
        for (int i = 0; i < listaCategoria.size(); i++) {
            if (listaCategoria.get(i).receta(nombre) != null) {
                return listaCategoria.get(i).receta(nombre).receta();
            }
        }
        return null;
    }

    public Object[] obtenerReceta(int idxCategoria, int idxReceta) {
        return listaCategoria.get(idxCategoria).receta(idxReceta);
    }

    public Object[] nombreCategoria() {
        Object[] cat = new Object[listaCategoria.size()];
        for (int i = 0; i < listaCategoria.size(); i++) {
            cat[i] = listaCategoria.get(i).getCategoria();
        }
        return cat;
    }

    public Object[] nombreReceta(String categoria) {
        for (int i = 0; i < listaCategoria.size(); i++) {
            if (listaCategoria.get(i).getCategoria().equals(categoria)) {
                return listaCategoria.get(i).nombreReceta();
            }
        }

        return null;
    }

    public void importarReceta(String categoria, Receta receta) {
        for (int i = 0; i < listaCategoria.size(); i++) {
            if (listaCategoria.get(i).getCategoria().equals(categoria)) {
                agregarReceta(i, receta);
                break;
            }
        }
    }

    public String obtenerPreparacion(int indCocina, int indReceta) {
        if (indCocina > -1 && indReceta > -1) {
            if (listaCategoria.get(indCocina).getListaReceta().size() > 0) {
                Receta receta = listaCategoria.get(indCocina).getListaReceta().get(indReceta);
                return receta.getPreparacion();
            }
        }

        return "";
    }

    public void listaBoxReceta(JComboBox cbxLista, int ind) {
        if (ind > -1) {
            if (listaCategoria.get(ind).getListaReceta().size() > 0) {

                for (String listaReceta : listaCategoria.get(ind).listaReceta()) {
                    cbxLista.addItem(listaReceta);
                }
            }
        }
    }

    public void listaBoxRecetaAll(JComboBox cbxLista) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < listaCategoria.size(); i++) {
            for (int j = 0; j < listaCategoria.get(i).getListaReceta().size(); j++) {
                list.add(listaCategoria.get(i).getListaReceta().get(j).getNombreReceta());
            }
        }

        ordenarArrayString(list);

        list.stream().forEach(rec -> {
            cbxLista.addItem(rec);
        });
    }

    public void listaBoxCategoria(JComboBox cbxLista) {
        listaCategoria.stream().forEach(list -> {
            cbxLista.addItem(list.getCategoria());
        });
    }

    public void listaBoxOtProductos(JComboBox cbxLista) {

        for (int i = 0; i < listaCategoria.size(); i++) {
            for (int j = 0; j < listaCategoria.get(i).getListaReceta().size(); j++) {
                if (listaCategoria.get(i).getListaReceta().get(j).isComplemento() == true) {
                    cbxLista.addItem(listaCategoria.get(i).getListaReceta().get(j).getNombreReceta());
                }
            }
        }

       listaProducto.listaBoxProductos(cbxLista);
    }

    public void agregarReceta(int idx, Receta receta) {
        receta.setFecha(fecha());
        if (receta.getCodigo() == 11) {
            receta.setCodigo(codigo(listacodigo()));
            receta.setFecha(fecha());
        }

        listaCategoria.get(idx).agregarReceta(receta);
        recetaPedido.add(recetaPedi(receta));
    }

    private ArrayList<Integer> listacodigo() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < listaCategoria.size(); i++) {
            for (int j = 0; j < listaCategoria.get(i).getListaReceta().size(); j++) {
                list.add(listaCategoria.get(i).getListaReceta().get(j).getCodigo());
            }
        }

        return list;
    }

    public void editarReceta(Receta receta, int idxCategoria, int idxReceta) {
        receta.setFecha(fecha());
        listaCategoria.get(idxCategoria).editarReceta(idxReceta, receta);
        for (int i = 0; i < recetaPedido.size(); i++) {
            if ((int) recetaPedido.get(i)[0] == receta.getCodigo()) {
                recetaPedido.set(i, recetaPedi(receta));
            }
        }
    }

    public Receta buscarReceta(String nombre) {
        for (int i = 0; i < listaCategoria.size(); i++) {
            return listaCategoria.get(i).receta(nombre);
        }
        return null;
    }

    public Receta obtenerRecet(int codigo) {
        Receta receta;
        for (int i = 0; i < listaCategoria.size(); i++) {
            receta = listaCategoria.get(i).obtenerReceta(codigo);
            if (receta != null) {
                return receta;
            }
        }

        return null;
    }

    public void eliminarReceta(int idxCategoria, int idxReceta) {
        listaCategoria.get(idxCategoria).eliminarReceta(idxReceta);
        Receta receta = obtenerRecet(idxCategoria, idxReceta);

        for (int i = 0; i < recetaPedido.size(); i++) {
            if ((int) recetaPedido.get(i)[0] == receta.getCodigo()) {
                recetaPedido.remove(i);
                break;
            }
        }
    }

    public void eliminarRecetaAll(int idxCategoria) {
        listaCategoria.get(idxCategoria).eliminarRecetaAll();
        recetaPedido.removeAll(recetaPedido);
    }

    public void eliminarProductoReceta(int idxCategoria, int idxReceta, int idxProducto) {
        listaCategoria.get(idxCategoria).eliminarProducto(idxReceta, idxProducto);

        Receta receta = obtenerRecet(idxCategoria, idxReceta);
        for (int i = 0; i < recetaPedido.size(); i++) {
            if ((int) recetaPedido.get(i)[0] == receta.getCodigo()) {
                recetaPedido.set(i, recetaPedi(receta));
            }
        }

    }

    public void moverReceta(int idxCat, int idxRec, String newCat) {
        Receta rec = obtenerRecet(idxCat, idxRec);
        for (int i = 0; i < listaCategoria.size(); i++) {
            if (listaCategoria.get(i).getCategoria().equals(newCat)) {
                listaCategoria.get(i).agregarReceta(rec);
                break;
            }
        }

        eliminarReceta(idxCat, idxRec);

    }

    public void cambiarNombreCategoria(String oldCat, String newCat) {
        for (int i = 0; i < listaCategoria.size(); i++) {
            if (listaCategoria.get(i).getCategoria().equals(oldCat)) {
                listaCategoria.get(i).setCategoria(newCat);
                break;
            }
        }
        listaCategoria.sort((Categoria o1, Categoria o2) -> o1.getCategoria().compareTo(o2.getCategoria()));
    }

    public ArrayList<String> listaRecetas() {
        ArrayList<String> list = new ArrayList<>();
        for (int j = 0; j < listaCategoria.size(); j++) {
            for (int i = 0; i < listaCategoria.get(j).getListaReceta().size(); i++) {
                list.add(listaCategoria.get(j).getListaReceta().get(i).getNombreReceta());
            }
        }

        return list;
    }

    public String obtenerRecetaNombre(int codigo) {
        for (int j = 0; j < listaCategoria.size(); j++) {
            for (int i = 0; i < listaCategoria.get(j).getListaReceta().size(); i++) {
                if (listaCategoria.get(j).getListaReceta().get(i).getCodigo() == codigo) {
                    return listaCategoria.get(j).getListaReceta().get(i).getNombreReceta();
                }
            }
        }
        return null;
    }

    public int obtenerCodigoReceta(String nomProdducto) {
        for (int j = 0; j < listaCategoria.size(); j++) {
            for (int i = 0; i < listaCategoria.get(j).getListaReceta().size(); i++) {
                if (listaCategoria.get(j).getListaReceta().get(i).getNombreReceta().equals(nomProdducto)) {
                    return listaCategoria.get(j).getListaReceta().get(i).getCodigo();
                }
            }
        }
        return -1;
    }

    public Object[] productosReceta(int codigo) {
        for (int i = 0; i < recetaPedido.size(); i++) {
            if ((int) recetaPedido.get(i)[0] == codigo) {
                return recetaPedido.get(i);
            }
        }

        return null;
    }

    public void precargarReceta() {
        recetaPedido = new ArrayList<>();
        Receta receta;
        for (int j = 0; j < listaCategoria.size(); j++) {
            for (int i = 0; i < listaCategoria.get(j).getListaReceta().size(); i++) {
                receta = listaCategoria.get(j).getListaReceta().get(i);
                recetaPedido.add(recetaPedi(receta));
            }
        }
    }

    private Object[] recetaPedi(Receta receta) {
        Object[] rece = new Object[2];
        rece[0] = receta.getCodigo();
        ArrayList<Object[]> list = listProductoReceta(receta.getProductos());
        rece[1] = list;
        return rece;
    }

    private ArrayList<Object[]> listProductoReceta(ArrayList<ProductoReceta> pro) {
        ArrayList<Object[]> list = new ArrayList<>();
        Object[] rec;
        for (int k = 0; k < pro.size(); k++) {
            rec = new Object[3];
            rec[0] = listaProducto.obtenerProductoNombre(pro.get(k).getCodProducto());
            rec[1] = pro.get(k).getCantidad();
            rec[2] = "";
            list.add(rec);
        }

        return list;
    }

}
