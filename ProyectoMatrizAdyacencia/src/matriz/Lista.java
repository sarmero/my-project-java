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
public class Lista {

    int[][] nodos;
    boolean estado[] = new boolean[]{false, false, false, false, false, false, false};
    int tamMatriz;
    String[] nomNodo;
    int iteracion = 1;
    Scanner entrada, entrada2 = new Scanner(System.in);

    public void insertarListaAdyacencia() {
        entrada = new Scanner(System.in);
        entrada2 = new Scanner(System.in);
        String text;
        int tam = 0;
        int it = 0;
        int sel = 0;
        String vec[];

        while (tam == 0) {
            System.out.print("¿Ingrese el numero de nodos? -> ");
            text = entrada.nextLine();
            if (validarDatos(text, 48, 57) == true) {
                tam = Integer.valueOf(text);
            } else {
                System.out.println("**** ingrea un tamaño valido");
            }
        }

        nodos = new int[tam][];
        nomNodo = new String[tam];
        vec = new String[tam];

        char ch;
        for (int i = 0; i < tam; i++) {
            ch = (char) (65 + i);
            nomNodo[i] = String.valueOf(ch);
        }

        for (int i = 0; i < nodos.length; i++) {
            tam = -1;

            for (int j = 0; j < nodos.length; j++) {
                vec[j] = nomNodo[j];
            }
            System.out.println("");
            while (tam == -1) {
                System.out.print("¿Ingrese el tamaño de la lista del nodo " + nomNodo[i] + " -> ");
                text = entrada.nextLine();
                if (validarDatos(text, 48, 57) == true) {
                    tam = Integer.valueOf(text);
                } else {
                    System.out.println("**** ingrea un tamaño valido");
                }
            }

            nodos[i] = new int[tam];
            it = 0;
            

            while (it < tam) {
                System.out.println(listaNodos(vec));
                System.out.print("¿Elija el nodo de la lista " + nomNodo[i] + " -> ");
                sel = entrada2.nextInt();
                if (sel < nodos.length && !vec[sel].equals("")) {
                    nodos[i][it] = sel;
                    vec[sel] = "";
                    it++;
                } else {
                    System.out.println("El numero ingresado no se reconoce como valido");
                }
            }

        }

        System.out.println("lista de Adyacencia");
        for (int i = 0; i < nodos.length; i++) {
            System.out.print(nomNodo[i]+" -> ");
            for (int j = 0; j < nodos[i].length; j++) {
                System.out.print(nomNodo[nodos[i][j]] + " ");
            }
            System.out.println("");
        }

    }

    public String listaNodos(String[] vec) {
        String list = "";

        for (int i = 0; i < vec.length; i++) {
            if (!vec[i].equals("")) {
                list = list + i + ": " + vec[i] + "\t";
            }
        }

        return list;
    }

    public boolean validarDatos(String text, int ragI, int ragF) {

        for (int i = 0; i < text.length(); i++) {
            if (!(text.charAt(i) >= ragI && text.charAt(i) <= ragF)) {
                return false;
            }
        }

        return true;
    }

    public void BFS(int ii) {
        

        for (int j = 0; j < nodos[ii].length; j++) {
            if (estado[nodos[ii][j]] == false) {
                estado[nodos[ii][j]] = true;
                nomNodo[nodos[ii][j]] = nomNodo[nodos[ii][j]] + "(v" + iteracion + ")";
                System.out.print(nomNodo[nodos[ii][j]] + " - ");
            }
        }
        iteracion++;
        for (int i = 0; i < nodos[ii].length; i++) {
            BFS(nodos[ii][i]);
        }

    }

    public void prueba() {
        nodos = new int[7][];
        nodos[0] = new int[]{1, 2};
        nodos[1] = new int[]{3, 4};
        nodos[2] = new int[]{5};
        nodos[3] = new int[]{4, 5};
        nodos[4] = new int[]{6};
        nodos[5] = new int[]{6};
        nodos[6] = new int[]{};

        char ch;
        nomNodo = new String[7];
        for (int i = 0; i < 7; i++) {
            ch = (char) (65 + i);
            nomNodo[i] = String.valueOf(ch);
        }

        System.out.println("lista de Adyacencia");
        for (int i = 0; i < nodos.length; i++) {
            System.out.print(nomNodo[i]+" -> ");
            for (int j = 0; j < nodos[i].length; j++) {
                System.out.print(nomNodo[nodos[i][j]] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Lista list = new Lista();
        list.insertarListaAdyacencia();
//        list.prueba();
        list.BFS(0);
    }

}
