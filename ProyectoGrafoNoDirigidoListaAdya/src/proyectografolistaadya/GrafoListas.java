/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectografolistaadya;
import java.awt.*;
public class GrafoListas
{
	//**************************************************
 	// ATRIBUTO QUE GUARDA LA REFERENCIA AL PRIMER NODO
 	// DE VARIAS LISTAS
 	//**************************************************
	private Nodo v[];
 	//**************************************************
 	// CONSTRUCTOR QUE RECIBE LA CANTIDAD DE VERTICES
 	// PARA CONSTRUIR EL VECTOR E INICIAR CADA POSICION
 	// EN NULL, O SEA TODAS LAS LISTAS INICIAN VACIAS
 	//**************************************************
	public GrafoListas(int t)
	{
		v = new Nodo[t];
		for (int i=0; i<t ; i++)
		{
			v[i]=null;
		}
	}
	//**************************************************
 	// CONSTRUCTOR QUE RECIBE UNA MATRIZ DE ADYACENCIA
 	// DONDE HAY UN UNO INDICA QUE EL VERTICE I ES 
 	// ADYACENTE AL VERTICE J
 	//**************************************************
	public GrafoListas(int mat[][])
	{
		v = new Nodo[mat.length];
		for (int i=0; i<mat.length ; i++)
		{
			v[i]=null;
		}
		for( int i = 0 ; i < mat.length ;i++)
		{
			for ( int j=0; j <mat[0].length ; j++)
			{
				if( mat[i][j]==1)
				{
					insertarNodo(i,j);
				}
			}
		}		
	}
	//**************************************************
 	// METODO QUE REGRES EL NUMERO DE VERTICES, QUE
 	// ES EL NUMERO DE POSICIONES DEL VECTOR
 	//**************************************************
	public int obtenerNVertices()
	{
	return v.length;	
	}
	//**************************************************
 	// METODO QUE INSERTA AL FINAL UN NUEVO NODO 
 	// CON EL DATO J  EN LA LISTA DE LA POSICION I
 	//**************************************************
	public void insertarNodo(int i,int j)
	{
		Nodo p,ant,q;
		if(i>=0 && i< v.length && j >=0 && j <v.length)
		{
		   p = v[i];
		   ant=null;
		   while(p !=null)
		   {
		   	 ant = p;
		   	 p= p.obtenerLiga();
		   }
		   q = new Nodo(j);
		   if(ant==null)
		   {
		   	 v[i]=q;
		   }
		   else
		   {
		   	ant.asignarLiga(q);
		   }
		}
	}	
 	//**************************************************
 	// METODO QUE PINTA EL GRAFO EN EL CONTEXTO GRAFICO
 	// RECIBIDO COMO PARAMETRO 
 	//**************************************************
	public void pintarGrafo(Graphics g ,int c, int f)
	{
	   	Nodo p;
	   	Color colorFondo= new Color(233,243,243);
		int f1=0,c1=0, anchoNodo, altoNodo,altoCelda, anchoCelda,antF,antC;
		altoCelda= 50;
		anchoCelda= 40;
		anchoNodo= 80;
		altoNodo = 40;
		//f = 50;
		//c = 50;
		//*********************************************
		// COLOCA EL NOMBRE DEL VECTOR
		//********************************************		   
		g.setColor(Color.blue);
		g.drawString("Vec                GRAFO NO DIRIGIDO REPRESENTADO COMO LISTAS LIGADAS DE ADYACENCIA",f+5,c-10);
		for(int i=0 ; i< v.length; i++)
		{
			p = v[i];
		//*********************************************
		// PINTA CADA CUADRO DEL VECTOR
		//********************************************		   
		g.setColor(colorFondo);// coloca el color de fondo
		g.fillRect(f,c,anchoCelda,altoCelda);// pinta el cuadro del fondo
		g.setColor(Color.red);// coloca el color para el borde
		g.drawRect(f,c,anchoCelda,altoCelda);//pinta el borde del cuadro
		if(p==null)// si no hay lista pinta null en el cuadro del vector
		{
			g.setColor(Color.blue);
		 	g.drawString("null",f+5,c+altoCelda/2);
		}
		// coloca el numero antes del cuadro del vector
		g.setColor(Color.blue);
		g.drawString(""+(i+1),f-20,c+altoCelda/2);
		f1 = f+ anchoCelda+ 20;
		c1 = c+(altoCelda-altoNodo)/2;
		antF= f+(anchoCelda)/2;
		antC= c+(altoCelda)/2;
		while( p != null)
		{
			//*********************************************
		 	// PARA PINTAR LAS LINEAS QUE UNEN LOS NODOS
		 	//********************************************
		 	pintarCirculo(g,antF, antC,4);
		 	flecha(g,Color.red,antF, antC, f1,c1+altoNodo /2 );
		 	antF=((int)(f1+anchoNodo*0.85));
		 	antC=((int)(c1+altoNodo*0.5));
		 	//*********************************************
		 	// PARA PINTAR EL NODO
		 	//********************************************
		 	g.setColor(colorFondo);
		 	g.fillRect(f1,c1,anchoNodo,altoNodo);
		 	g.setColor(Color.red);
		 	g.drawRect(f1,c1,anchoNodo,altoNodo);
		 	//*********************************************
		 	// PARA PINTAR LAS LINEAS QUE UNEN LOS NODOS
		 	//********************************************
		 	g.drawLine(((int)(f1+anchoNodo*0.6)), c1,  ((int)(f1+anchoNodo*0.6)),c1+altoNodo  );
		 	g.setColor(Color.blue);
		 	//*********************************************
		 	// PARA COLOCAR LOS DATOS DEL NODO
		 	//********************************************
		 	g.drawString(""+(p.obtenerDato()+1),((int)(f1+anchoNodo*0.2)),((int)(c1+altoCelda*0.4)));
		 	//*********************************************
		 	// SE PINTA NULL SI NO HAY MAS NODOS
		 	//********************************************
		 	if(p.obtenerLiga()==null)
		 	{
		 		g.drawString("null",((int)(f1+anchoNodo*0.7)),((int)(c1+altoCelda*0.4)));
		 	} 
                                                             f1 = f1+anchoNodo+20;
		   	p= p.obtenerLiga();	
		   	}
		   	c= c+altoCelda;
		   	
	   }	
	}
 	//**************************************************
 	// METODO QUE PINTA UN CIRCULO EN LA COORDENADA
 	// RECIBIDA CON EL RADIO RECIBIDO 
 	//**************************************************
	public void pintarCirculo(Graphics g, int x, int y, int radio)
	{	 
	 	  	g.setColor(Color.black);
	  	  	g.fillOval(x-radio/2,y-radio/2,radio,radio);
		  	g.setColor(Color.red);
	  	  	g.drawOval(x-radio/2,y-radio/2,radio,radio);
	}			
	//**************************************************
 	// METODO QUE PINTA UNA FLECHA DESDE LA COORDENADA
 	// INICIAL HASTA LA COORDENADA FINAL RECIBIDAS
 	//**************************************************			
	public void flecha(Graphics m, Color color,double a1, double b1,  double a2, double b2)
	{	int x1, x2, y1, y2;	//Coordenadas de la pantalla de gráficos
		x1=(int)a1;
		y1=(int)b1;
		x2=(int)a2;
		y2=(int)b2;
		m.setColor(color);
		m.drawLine(x1,y1,x2,y2);
		double ancho=4, largo=10;
		double dim=Math.sqrt((double)((x1-x2)*(x1-x2))+(double)((y1-y2)*(y1-y2)));
		if(dim>largo)
		{	double dx=(double)(x2-x1)/dim;
			double dy=(double)(y2-y1)/dim;
			double xa,xb,ya,yb;
			xa=x2-largo*dx-ancho*dy;
			ya=y2-largo*dy+ancho*dx;
			xb=x2-largo*dx+ancho*dy;
			yb=y2-largo*dy-ancho*dx;
			m.drawLine(x2,y2,(int)xa,(int)ya);
			m.drawLine(x2,y2,(int)xb,(int)yb);
		}
	}
}