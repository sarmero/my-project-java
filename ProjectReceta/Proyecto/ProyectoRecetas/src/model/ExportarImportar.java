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
public class ExportarImportar implements Serializable {
    
    private static final long serialVersionUID = 0x1C8F3CF;
    
    Receta receta;
    ArrayList<Producto> productos;

    public ExportarImportar() {
        receta = new Receta();
        productos = new ArrayList<>();
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    
    
}
