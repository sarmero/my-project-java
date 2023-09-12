/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Sudoku;

/**
 *
 * @author Sebastian
 */
public class PasoCuatro extends Herramientas {

    private Sudoku sudk;
    private  int vall;

    public PasoCuatro() {
        vector = new int[9];
        vall = 2;
        
    }

    private int[] numerosFaltantes(int fila, int columna) {

        int fil = fila, col = columna;

        for (int i = 0; i < 9; i++) {

            vector[i] = matrizAux[fil][col];

            fil++;
            if (i == 2 || i == 5) {
                col++;
                fil = fila;
            }

        }

        int aux[] = obtenerNumerosFaltantes();

        return aux;
    }

    private int[] obtenerVectoresPequeños(int fila, int columna, int ax[]) {

        int val;

        int fil = fila, col = columna;

        int aux[] = ax;

        boolean ban = false;
        int n = 0;

        if (matrizAux[fil][col] == 0) {
            for (int i = 0; i < aux.length; i++) {
                val = aux[i];

                ban = buscarFilaColumna(aux, fil, col, val);

                if (ban) {
                    for (int l = 0; l < aux.length; l++) {
                        if (aux[l] == val) {
                            aux[l] = 0;
                        }
                    }

                }

            }

            for (int i = 0; i < aux.length; i++) {
                if (aux[i] != 0) {
                    n++;

                }

            }

        }

        if (n != 2) {
            for (int i = 0; i < aux.length; i++) {
                aux[i] = 0;
            }

        }

        return aux;

    }

    private boolean verificarCeros() {
        boolean ban = false;
        int n = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrizAux[i][j] == 0) {

                    n++;
                    ban = true;
                    break;
                }
            }

        }

        return ban;
    }

    private boolean verificarErrores() {

        int n;

        boolean ban = false;

        for (int k = 0; k < 9; k++) {

            for (int i = 0; i < 9; i++) {
                n = 0;
                for (int j = 0; j < 9; j++) {
                    if (matrizAux[i][j] == (k + 1)) {
                        n++;

                        if (n == 2) {
                            ban = true;
                            break;
                        }
                    }

                }

            }

        }

        if (ban == false) {
            for (int k = 0; k < 9; k++) {

                for (int i = 0; i < 9; i++) {
                    n = 0;
                    for (int j = 0; j < 9; j++) {
                        if (matrizAux[j][i] == (k + 1)) {
                            n++;
                            if (n == 2) {
                                ban = true;
                                break;
                            }
                        }

                    }

                }
            }
        }

        return ban;
    }

    private int contarCeros() {
        int numq = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrizAux[i][j] == 0) {
                    numq++;
                }
            }
        }

        return numq;
    }

    private int[][] obtenerdatosMatriz(int matr[][]) {

        int mat[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                mat[j][i] = matr[j][i];
            }
        }

        return mat;
    }

    public void ejecuutarPasoCuatro(int mat[][]) {

        matrizAux = obtenerdatosMatriz(mat);

        int num1, num2;
        boolean ban;
        int n = 0;
        int w = 0;
        int matNumPos[][] = new int[3][60];
    

        int matriz[][];

        matriz = obtenerdatosMatriz(matrizAux);

        int aux[];

        int fil = 0, col = 0;

        int ax[];

        ban = verificarErrores();

        if (ban == false) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    if (matrizAux[i][j] == 0) {

                        ax = numerosFaltantes(fil, col);

                        aux = obtenerVectoresPequeños(i, j, ax);
                        
                        for (int k = 0; k < aux.length; k++) {
                            if (aux[k] != 0) {

                                n++;
                            }
                        }

                        if (n == 2) {
                            n = 0;
                            num1 = 0;
                            num2 = 0;
                            for (int k = 0; k < aux.length; k++) {
                                if (aux[k] != 0) {

                                    if (num1 == 0) {
                                        num1 = aux[k];
                                    } else {
                                        num2 = aux[k];
                                    }
                                }
                            }
                            matrizAux[i][j] = num1;
                            sudk = new Sudoku(matrizAux);
                            sudk.ejecutarPasos();
                            matrizAux = obtenerdatosMatriz(sudk.getMatriz());

                            ban = verificarErrores();

                            if (ban == false) {

                                ban = verificarCeros();

                                if (ban == true) {

                                    matNumPos[0][w] = i;
                                    matNumPos[1][w] = j;
                                    matNumPos[2][w] = num1;
                                    w++;

                                    matrizAux = obtenerdatosMatriz(matriz);

                                    sudk = new Sudoku(matrizAux);
                                    sudk.ejecutarPasos();
                                    matrizAux = obtenerdatosMatriz(sudk.getMatriz());

                                    ban = verificarErrores();

                                    if (ban == false) {

                                        matNumPos[0][w] = i;
                                        matNumPos[1][w] = j;
                                        matNumPos[2][w] = num1;
                                        w++;

                                        ban = verificarCeros();

                                        if (ban == true) {
                                            matrizAux = obtenerdatosMatriz(matriz);
                                        } else {
                                            vall = 0;//fin de algoritmo
                                            break;
                                        }

                                    } else {
                                        matrizAux = obtenerdatosMatriz(matriz);
                                        

                                    }
                                } else {
                                    vall = 0;//fin de algoritmo
                                    break;
                                }

                            } else {

                                matrizAux = obtenerdatosMatriz(matriz);

                                sudk = new Sudoku(matrizAux);
                                sudk.ejecutarPasos();
                                matrizAux = obtenerdatosMatriz(sudk.getMatriz());

                                ban = verificarErrores();

                                if (ban == false) {

                                    ban = verificarCeros();

                                    matNumPos[0][w] = i;
                                    matNumPos[1][w] = j;
                                    matNumPos[2][w] = num1;
                                    w++;

                                    if (ban == true) {

                                        matrizAux = obtenerdatosMatriz(matriz);

                                    } else {
                                        vall = 0;//fin de algoritmo
                                        break;
                                    }

                                } else {
                                    matrizAux = obtenerdatosMatriz(matriz);

                                }

                            }

                        }

                    }

                    if (j == 2 || j == 5) {
                        col += 3;
                    }
                }
                col = 0;

                if (i == 2 || i == 5) {
                    fil += 3;
                }

            }

        }

        if (vall != 0) {

            ban = verificarCeros();

            if (ban == true) {

                for (int i = 0; i < w; i++) {
                    matrizAux[matNumPos[0][i]][matNumPos[1][i]] = matNumPos[2][i];
                    sudk = new Sudoku(matrizAux);
                    sudk.ejecutarPasos();
                    matrizAux = obtenerdatosMatriz(sudk.getMatriz());

                    ban = verificarCeros();

                    if (ban == false || vall == 0) {
                        break;
                    }

                    matriz = obtenerdatosMatriz(matrizAux);
                    ejecuutarPasoCuatro(matriz);

                    ban = verificarCeros();

                    if (ban == false || vall == 0) {
                        break;
                    }else{
                        matrizAux = obtenerdatosMatriz(matriz);
                    }

                }
            }
        }

    }

}
