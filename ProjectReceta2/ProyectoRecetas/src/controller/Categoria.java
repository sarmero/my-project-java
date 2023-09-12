/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import model.Receta;

/**
 *
 * @author USER
 */
public class Categoria implements Serializable {

    private static final long serialVersionUID = 0x1C8E3A;
    private String categoria;
    private ArrayList<Receta> listaReceta;

    

    public Categoria() {
        categoria = "";
        listaReceta = new ArrayList<>();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Receta> getListaReceta() {
        return listaReceta;
    }

    public void setListaReceta(ArrayList<Receta> listaReceta) {
        this.listaReceta = listaReceta;
    }

    public void agregarReceta(Receta rece) {
        listaReceta.add(rece);
        listaReceta.sort((Receta o1, Receta o2) -> o1.getNombreReceta().compareTo(o2.getNombreReceta()));
    }

    public String[] listaReceta() {
        String[] text = new String[listaReceta.size()];

        for (int i = 0; i < listaReceta.size(); i++) {
            text[i] = listaReceta.get(i).getNombreReceta();
        }

        return text;
    }

    public ArrayList<String> listaRecetas() {
        ArrayList<String>  text = new ArrayList<>();
        for (int i = 0; i < listaReceta.size(); i++) {
            text.add(listaReceta.get(i).getNombreReceta());
        }
        return text;
    }
    
    public void eliminarReceta(int idx) {
        listaReceta.remove(idx);
    }
    
    public void eliminarRecetaAll(){
        listaReceta.removeAll(listaReceta);
    }

    public void eliminarProducto(int idxReceta, int idxProducto) {
        listaReceta.get(idxReceta).getProductos().remove(idxProducto);
    }

    public Object[] receta(int idx) {
        return listaReceta.get(idx).receta();
    }

    public void editarReceta(int idx, Receta receta) {
        listaReceta.set(idx, receta);
        listaReceta.sort((Receta o1, Receta o2) -> o1.getNombreReceta().compareTo(o2.getNombreReceta()));
    }

    public Receta receta(String nombre) {
        for (int i = 0; i < listaReceta.size(); i++) {
            if (listaReceta.get(i).getNombreReceta().equals(nombre)) {
                return listaReceta.get(i);
            }
        }
        return null;
    }
    
    public Object[] nombreReceta(){
         Object[] rec = new Object[listaReceta.size()];
        for (int i = 0; i < listaReceta.size(); i++) {
            rec[i] = listaReceta.get(i).getNombreReceta();
        }
        return rec;
    }
    
     public Receta obtenerReceta(int codigo) {
        for (int i = 0; i < listaReceta.size(); i++) {
            
            if (listaReceta.get(i).getCodigo() == codigo) {
                return listaReceta.get(i);
            }
        }
        return null;
    }

}
