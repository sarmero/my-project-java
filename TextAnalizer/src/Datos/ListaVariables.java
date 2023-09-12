/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

class nodoVar{
    String nombreVar;
    String tipo;
    String ambito;
    String valor;
    nodoVar siguiente;
    
    public nodoVar(String nombreVar,String Tipo,String Ambito,String Valor) {
        this.nombreVar=nombreVar;
        this.tipo=Tipo;
        this.ambito=Ambito;
        this.valor=Valor;
    }
    
}

public class ListaVariables {
    nodoVar cabeza;
    nodoVar cola;
    
    public void insertarVar(String nombreVar,String Tipo,String Ambito,String Valor){
        if(cabeza==null){
            cabeza= new nodoVar(nombreVar,Tipo,Ambito,Valor);
            cola=cabeza;
        }else{
            cola.siguiente=new nodoVar(nombreVar,Tipo,Ambito,Valor);; 
            cola=cola.siguiente;
        }
    }   

    public boolean existeVar(String nombreVar,String Ambito){
        if(cabeza==null){
        return false;
        }else{
           nodoVar tmp=cabeza;
            while(tmp!=null){
                if(tmp.ambito.equals(Ambito) && tmp.nombreVar.equals(nombreVar)){
                    return true;
                }
                tmp=tmp.siguiente;
            }
            return false;
        } 
    }

    
    

}

