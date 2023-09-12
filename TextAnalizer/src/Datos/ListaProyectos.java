/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import javax.swing.text.DefaultStyledDocument;

/**
 *
 * @author luis
 */

class nodoProyecto{
    int id;
    String textosinFormato;
    DefaultStyledDocument doc;
    nodoProyecto siguiente;
    public nodoProyecto( int id, String textoSinFormato,DefaultStyledDocument doc) {
    this.id=id;
    this.doc=doc;
    this.textosinFormato=textoSinFormato;
    }
    
}

public class ListaProyectos {
    private nodoProyecto cabeza;
    private nodoProyecto cola;
    private  int id;
    
    public void agregarProyecto( String textoSinFormato,DefaultStyledDocument doc){
        if(cabeza==null){
            cabeza=new nodoProyecto(id, textoSinFormato, doc);
            id++;
            cola=cabeza;
        }else{
            cola.siguiente=new nodoProyecto(id, textoSinFormato, doc);
            id++;
            cola=cola.siguiente;
        }    
    }
}


