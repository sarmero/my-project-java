/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Matriz {

    int matriz[][];
    boolean estado[] = new boolean[]{false, false, false, false, false, false, false};
    int tamMatriz;
    String[] visita;
    int iteracion = 1;
    Scanner entrada = new Scanner(System.in);

    public void DFS(int ii) {
        System.out.print(visita[ii] + " - ");
        for (int j = 0; j < tamMatriz; j++) {
            if (matriz[ii][j] == 1 && estado[j] == false) {
                iteracion++;
                estado[j] = true;
                visita[j] = visita[j] + "(v" + iteracion + ")";
                DFS(j);
            }
        }
    }

    public boolean validarDatos(String text, int ragI, int ragF) {

        for (int i = 0; i < text.length(); i++) {
            if (!(text.charAt(i) >= ragI && text.charAt(i) <= ragF)) {
                return false;
            }
        }

        return true;
    }

    public void insertarMatrizAdyacencia() {
        entrada = new Scanner(System.in);
        String fila = "";
        String text;
        int tam = 0;
        int it = 0;

        while (tam == 0) {
            System.out.print("¿Tamaño de la matriz? -> ");
            text = entrada.nextLine();
            if (validarDatos(text, 48, 57) == true) {
                tam = Integer.valueOf(text);
            } else {
                System.out.println("**** ingrea un tamaño valido");
            }
        }

        matriz = new int[tam][tam];
        tamMatriz = tam;
        visita = new String[tam];
        char ch = 0;

        for (int i = 0; i < tam; i++) {
            while (it < tam) {
                System.out.print("¿Insertar fila " + (it + 1) + " -> ");
                fila = entrada.nextLine();
                if (validarDatos(fila, 48, 49) == true && fila.length() <= 7) {
                    insertarFila(fila, it);
                    it++;
                } else {
                    System.out.println("la fila ingresada no se reconoce como valida");
                }
            }
            ch = (char) (65+i);
            visita[i]=String.valueOf(ch);
        }
        
        visita[0]="A(v1)";

        System.out.println("Matriz de Adyacencia");
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void insertarFila(String fila, int pos) {
        for (int i = 0; i < fila.length(); i++) {
            matriz[pos][i] = Integer.valueOf(fila.charAt(i) + "");
        }
    }

    public static void main(String[] args) {
        Matriz mat = new Matriz();
        mat.insertarMatrizAdyacencia();
        mat.DFS(0);
    }
    
    //0110000
    //0001100
    //0000010
    //0000110
    //0000001
    //0000001
    //0000000

}
