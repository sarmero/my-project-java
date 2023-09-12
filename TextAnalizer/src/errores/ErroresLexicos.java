/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

/**
 *
 * @author luis
 */

class nodoLex{
    int id;
    String lexema;
    String columna;
    String fila;
    String descripcion;
    nodoLex siguiente;
    
    public nodoLex( int Id, String lexema,String columna,String fila,String descrip){
        this.id=Id;
        this.lexema=lexema;
        this.columna=columna;
        this.fila=fila;
        this.descripcion=descrip;
    }
}

public class ErroresLexicos {
    
   private nodoLex cabeza;
   private nodoLex cola;
   int id;
   public void insertarError(String lexema,String columna,String fila,String descrip){
        if(cabeza==null){
            cabeza= new nodoLex(id, lexema, columna, fila,descrip);
            id++;
            cola=cabeza;
        }else{
            cola.siguiente=new nodoLex(id, lexema, columna, fila,descrip); 
            id++;
            cola=cola.siguiente;
        }
    }
   
   public void imprimirErrores(){
       
       if(cabeza!=null){
            nodoLex tmp;
            tmp=cabeza;
            while(tmp!=null){
                System.out.println("id: "+tmp.id+"\nLexema: "+tmp.lexema+"\nColumna: "+tmp.columna+"\nFila: "+tmp.fila+"\nDescripcion: "+tmp.descripcion+"\n");
                tmp=tmp.siguiente;
            }
        }else{
            System.out.println("Lista de errores lexicos vacia");
        }
   
   }
   
    public void vaciarErrLex(){
        if(cabeza!=null){
            nodoLex tmp=cabeza;
            nodoLex aux;
            while(tmp!=null){
                aux=tmp;
                tmp=tmp.siguiente;
                aux=null;
            }
            cabeza=null;
            cola=null;
            id=0;
        }
    }
    
}
