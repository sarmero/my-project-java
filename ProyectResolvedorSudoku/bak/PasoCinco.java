/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class PasoCinco {

    private int faltantes[];
    private int vector[];
    private int matrizAux[][];

    private int jj, ii, vall, num;

    public PasoCinco() {
        vector = new int[9];
        jj = 0;
        ii = 0;
        vall = 81;
        num = 0;
    }

    private int obtenrTamaño() {
        int n = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == 0) {
                n++;
            }
        }

        return n;
    }

    private int[] obtenerNumerosFaltantes() {

        int n = obtenrTamaño();
        faltantes = new int[n];
        boolean ban = false;

        n = 0;

        for (int j = 0; j < vector.length; j++) {

            for (int i = 0; i < vector.length; i++) {

                if (vector[i] == (j + 1)) {
                    ban = true;
                }
            }

            if (ban == false) {
                faltantes[n] = (j + 1);
                n++;

            }
            ban = false;
        }
//        System.out.println("\n");

        return faltantes;
    }

    private int[] numerosFaltantes(int fila, int columna) {

        int fil = fila, col = columna;

        for (int i = 0; i < 9; i++) {

            vector[i] = matrizAux[fil][col];
//            System.out.println("col = "+col+" fil = "+fil+" vla = "+ matrizAux[fil][col]);

            fil++;
            if (i == 2 || i == 5) {
                col++;
                fil = fila;
            }

        }

        int aux[] = obtenerNumerosFaltantes();

//        System.out.print("col = " + columna + " fil = " + fila + " { ");
//        for (int i = 0; i < aux.length; i++) {
//            System.out.print(aux[i]);
//        }
//        System.out.println(" }");
        return aux;
    }

    private int[] obtenerVectoresPequeños(int fila, int columna, int ax[]) {

        int val;

        int fil = fila, col = columna;

        int aux[] = ax;

        boolean ban1 = false, ban2 = false;
        int n = 0;

        if (matrizAux[fil][col] == 0) {
            for (int i = 0; i < aux.length; i++) {
                val = aux[i];

                for (int k = 0; k < 9; k++) {

                    if (matrizAux[k][col] == val) {

                        ban1 = true;

                    }

                    if (matrizAux[fil][k] == val) {
                        ban2 = true;

                    }

                }

                if (ban2 || ban1) {
                    for (int l = 0; l < aux.length; l++) {
                        if (aux[l] == val) {
                            aux[l] = 0;
                        }
                    }

                }

                ban1 = false;
                ban2 = false;

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
//                    System.out.println("fila = " + i + " col = " + j );
                    n++;
                    ban = true;
                    break;
                }
            }

        }
//        System.out.println(n);

        return ban;
    }

    private boolean verificarErrores() {

        int n = 0;

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

//        System.out.println(n);
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
//        System.out.println(numq);

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

    private int[][] obtenerdatosMatriz() {

        int mat[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                mat[j][i] = matrizAux[j][i];
            }
        }

        return mat;
    }

    public void ejecuutarPasoCinco(int mat[][]) {

        matrizAux = obtenerdatosMatriz(mat);

        int num1 = 0, num2 = 0;
        boolean ban;
        int n = 0;
        int cont = 0;

//        System.out.println("+++++++++++++++++++++++++++");
//        verificarCeros();
        int matriz[][];

//        imprimirMatriz();
        matriz = obtenerdatosMatriz(matrizAux);

        ban = compararMatrices(matriz);

        if (ban == true) {
            System.out.println("diferentes");
        }

        int aux[];

        int fil = 0, col = 0;

        int ax[];

        ban = verificarErrores();

        if (ban == false) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    if (matrizAux[i][j] == 0) {

                        System.out.println("col = " + col + " fil = " + fil + " i = " + i + " j = " + j);

                        ax = numerosFaltantes(fil, col);

                        aux = obtenerVectoresPequeños(i, j, ax);
                        System.out.println("ax " + ax.length);
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

                            System.out.println("fila = " + i + " col = " + j + " num1 = " + num1 + " num2 = " + num2);
                            matrizAux[i][j] = num1;
                            ejecutarPasos();

                            ban = verificarErrores();

                            if (ban == false) {

//                            System.out.println("paso ");
                                ban = verificarCeros();

                                if (ban == true) {
                                    cont = contarCeros();

                                    if (cont < vall) {
                                        vall = cont;
                                        ii = i;
                                        jj = j;
                                        num = num1;
                                    }

                                    matrizAux = obtenerdatosMatriz(matriz);

                                    matrizAux[i][j] = num2;

                                    ejecutarPasos();

                                    ban = verificarErrores();

                                    if (ban == false) {
                                        ban = verificarCeros();

                                        cont = contarCeros();
                                        if (cont < vall) {
                                            vall = cont;
                                            ii = i;
                                            jj = j;
                                            num = num2;
                                        }

                                        if (ban == true) {

                                            matrizAux = obtenerdatosMatriz(matriz);

                                        }
                                    } else {
                                        matrizAux = obtenerdatosMatriz(matriz);

                                    }
                                }

                            } else {
                                matrizAux = obtenerdatosMatriz(matriz);

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
            
//            vall = 0;

        }

        if (vall != 0) {

            ban = verificarCeros();

            if (ban == true) {

//                System.out.println("jj = " + jj + " ii = " + ii + " num = " + num + " vall = " + vall);

                matrizAux[ii][jj] = num;
//                    System.out.println(matrizAux[ii][jj]);
                ejecutarPasos();

                matriz = obtenerdatosMatriz(matrizAux);

                jj = 0;
                ii = 0;
//                vall = 81;
                num = 0;

                ejecuutarPasoCinco(matriz);
            } else {
//                System.out.println("no hay");
            }
        }
        System.out.println("termino");

    }

    private void imprimirMatriz() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrizAux[i][j]);

                if (j == 2 || j == 5) {
                    System.out.print("-");
                }

            }

            System.out.println("\n");
        }
        System.out.println(" ");
    }

    private void ejecutarPasos() {

        ejecutarPasoDos();
        ejecutarPasoTres();
        ejecutarPasoCuatro();

    }

    private void ejecutarPasoDos() {
        boolean ban;
        int mat[][] = obtenerdatosMatriz();
        PasoNumeroDos pasoDos = new PasoNumeroDos();
        pasoDos.ejecutarPasDos(matrizAux);
        ban = compararMatrices(mat);

        matrizAux = pasoDos.getMatrizAux();

        if (ban == true) {
            ejecutarPasoDos();
        }

    }

    private void ejecutarPasoTres() {
        boolean ban;
        int mat[][] = obtenerdatosMatriz();
        PasoTres pasoNumeroTres = new PasoTres();

        pasoNumeroTres.obtenerPasoTres(matrizAux);

        ban = compararMatrices(mat);

        matrizAux = pasoNumeroTres.getMatrizAux();

        if (ban) {
            ejecutarPasos();
        }

    }

    private void ejecutarPasoCuatro() {
        boolean ban;
        int mat[][] = obtenerdatosMatriz();
        PasoCuatro pasoNumeroCuatro = new PasoCuatro();
        pasoNumeroCuatro.ejecuutarPasoCuatro(matrizAux);

        ban = compararMatrices(mat);

        matrizAux = pasoNumeroCuatro.getMatrizAux();

        if (ban) {
            ejecutarPasos();
        }

    }

    private boolean compararMatrices(int mat[][]) {
        boolean ban = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

//                System.out.println(j+""+i+"  matris 1 "+mat[j][i]+"  matris 2 "+ matriz[j][i]);
                if (mat[j][i] != matrizAux[j][i]) {

                    ban = true;
                }
            }
        }

        return ban;
    }

    public int[][] getMatrizAux() {
        return matrizAux;
    }

}
