/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sebastian
 */
public class PasoTres extends Herramientas{
    
    
    private int matriz[][];
    
    
    protected boolean buscarCeros(){
        boolean ban = false;
        
        for (int i = 0; i < 9; i++) {
            if (vector[i] == 0) {
                ban = true;
                break;
            }
        }
        
        return ban;
    }
    
    
    private void obtenerVectoresPequeños(int fila, int columna) {

        int val;

        int fil = fila, col = columna;

        for (int i = 0; i < 9; i++) {

            vector[i] = matrizAux[fil][col];
            fil++;
            if (i == 2 || i == 5) {
                col++;
                fil = fila;
            }

        }


        if (buscarCeros()) {

            int aux[] = obtenerNumerosFaltantes();

            matriz = new int[aux.length][aux.length];

            for (int i = 0; i < aux.length; i++) {
                for (int j = 0; j < aux.length; j++) {
                    matriz[i][j] = aux[j];
                }

            }

            fil = fila;
            col = columna;

            int n = 0;
           boolean ban ;

            for (int j = 0; j < 9; j++) {

                if (matrizAux[fil][col] == 0) {

                    for (int i = 0; i < aux.length; i++) {
                        val = aux[i];

                        ban = buscarFilaColumna(aux, fil, col, val);
                        

                        if (ban) {
                            for (int l = 0; l < aux.length; l++) {
                                if (matriz[n][l] == val) {
                                    matriz[n][l] = 0;
                                }
                            }

                        }

                        

                    }

                    int nn = 0, nume = 0;
                    for (int i = 0; i < aux.length; i++) {
                        if (matriz[n][i] == 0) {
                            nn++;
                        } else {
                            nume = matriz[n][i];
                        }

                    }

                    if (aux.length - nn == 1) {
  
                        matrizAux[fil][col] = nume;

                        for (int i = 0; i < aux.length; i++) {
                            if (aux[i] == nume) {
                                aux[i] = 0;
                            }

                        }
                        for (int l = 0; l < aux.length; l++) {
                            if (matriz[n][l] == nume) {
                                matriz[n][l] = 0;
                            }
                        }

                    }

                    n++;
                }

                fil++;
                if (j == 2 || j == 5) {
                    col++;
                    fil = fila;
                }

            }
            verificarFaltantes(aux, fila, columna);
        }

    }

    private void ponerNumero(int fila, int columna, int n) {

        int fil = fila, col = columna;
        boolean ban1 = false, ban2 = false;

        for (int w = 0; w < 9; w++) {
            if (matrizAux[fil][col] == 0) {

                for (int l = 0; l < 9; l++) {

                    if (matrizAux[l][col] == n) {
                        ban1 = true;

                    }

                    if (matrizAux[fil][l] == n) {
                        ban2 = true;

                    }

                }

                if (ban2 == false && ban1 == false) {
                    matrizAux[fil][col] = n;
                }

                ban1 = false;
                ban2 = false;

            }

            fil++;
            if (w == 2 || w == 5) {
                col++;
                fil = fila;
            }
        }

    }

    private void verificarFaltantes(int aux[], int fila, int columna) {
        int n = 0;

        for (int k = 0; k < aux.length; k++) {

            if (aux[k] != 0) {
                for (int i = 0; i < aux.length; i++) {
                    for (int j = 0; j < aux.length; j++) {

                        if (matriz[i][j] == aux[k]) {
                            n++;
                        }
                    }
                }

                if (n == 1) {
                    ponerNumero(fila, columna, aux[k]);
                }

                n = 0;
            }

        }

    }

    public void ejecuutarPasoTres(int mat[][]) {
        matrizAux = mat;
        int fil = 0, col = 0;

        for (int i = 0; i < 9; i++) {
            obtenerVectoresPequeños(fil, col);

            col += 3;
            if (i == 2 || i == 5) {
                fil += 3;
                col = 0;
            }
        }

    }
}
