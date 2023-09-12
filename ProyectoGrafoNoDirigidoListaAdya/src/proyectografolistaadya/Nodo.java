/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectografolistaadya;
public class Nodo
{
 
  private int dato;
  private Nodo Liga;
 
  //***********************************************
  // CONSTRUCTOR SIN PARAMETROS                   *
  //***********************************************
  public Nodo()
  {
	  dato = 0;
      Liga= null;
  }
  //***********************************************
  // CONSTRUCTOR QUE RECIBE EL DATO COMO PARAMETRO*
  //***********************************************
  public  Nodo( int dato)
  {
	  this.dato = dato;
  	  Liga= null;
  }
  //***********************************************
  // METODO QUE ASIGNA EL DATO DEL NODO          *
  //***********************************************
  public void asignarDato(int d)
  {
	 dato=d;
  }  
  //***********************************************
  // METODO QUE REGRESA EL DATO DEL NODO          *
  //***********************************************
  public int obtenerDato()
  {
	 return dato;
  }
  //***********************************************
  // METODO QUE REGRESA LA LIGA DEL NODO          *
  //***********************************************
  public Nodo obtenerLiga()
  {
  	return Liga;
  }
  //************************************************
  // METODO QUE ASIGNA UN NUEVO VALOR A  LIGAA     *
  //************************************************
  public void  asignarLiga(Nodo x)
  {
  	Liga=x;
  }
 
}