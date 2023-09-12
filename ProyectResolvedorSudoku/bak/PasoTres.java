/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class PasoTres {

    private int faltantes[];
    private int vector[];
    private int matrizAux[][];

    public PasoTres() {
        vector = new int[9];
    }

    private boolean buscarMatriz(int val, int col, int fil) {
        boolean ban = false;

        int n;

        n = fil + 3;

        for (int i = fil; i < n; i++) {

            if (matrizAux[i][col] == val) {
                ban = true;
                break;
            }
        }

        return ban;
    }

    private boolean filaBuscarMatriz(int val, int col, int fil) {
        boolean ban = false;

        int n;

        n = col + 3;

        for (int i = col; i < n; i++) {

            if (matrizAux[fil][i] == val) {
                ban = true;
                break;
            }
        }

        return ban;
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

    private boolean verificarColumna(int val, int col, int fil, int O, int P, int M) {

        boolean ban;

        ban = buscarMatriz(val, col + O, fil + M);

        if (ban == false) {

            ban = buscarMatriz(val, col + P, fil + M);

            if (ban == false) {

                for (int j = 0; j < 9; j++) {
                    if (matrizAux[fil][j] == val) {
//                        System.out.println("fil = "+fil+" col = "+col+" j = "+j+" val = "+val);
                        ban = true;
                    }
                }

            }
        }

        return ban;

    }

    private boolean verificarFila(int val, int col, int fil, int O, int P, int M) {

        boolean ban;

        ban = filaBuscarMatriz(val, col + M, fil + O);

        if (ban == false) {

            ban = filaBuscarMatriz(val, col + M, fil + P);

            if (ban == false) {

                for (int j = 0; j < 9; j++) {
                    if (matrizAux[j][col] == val) {
//                        System.out.println("fil = "+fil+" col = "+col+" j = "+j+" val = "+val);
                        ban = true;
                    }
                }

            }
        }

        return ban;

    }

    public void obtenerPasoTres(int mat[][]) {
        matrizAux = mat;
        int val;
        int n = 0;
        

        int num;

        boolean ban;

        int fil, col = 0, O = 1, P = 2, M;

        for (int c = 0; c < 9; c++) {

            for (int i = 0; i < 9; i++) {
                vector[i] = matrizAux[i][col];
            }
            
            int r = 0;

            for (int i = 0; i < 9; i++) {
                if (vector[i] == 0) {
                    r = 1;
                }
            }

            if (r == 1) {

                int aux[] = obtenerNumerosFaltantes();

//            System.out.print("col = "+col+" { ");
//            for (int i = 0; i < aux.length; i++) {
//                System.out.print(aux[i]);
//            }
//            System.out.println(" }");
                for (int i = 0; i < aux.length; i++) {
                    val = aux[i];

                    M = 0;
                    fil = 0;

                    for (int f = 0; f < 9; f++) {

//                    System.out.println("fila = " + fil + " col = " + col + " val = " + val + " n = " + n );
                        if (matrizAux[fil][col] == 0) {
                            ban = verificarColumna(val, col, fil, O, P, M);

                            if (ban == true) {
                                n++;
                            }
                        }

                        fil++;
                        M--;
                        if (f == 2 || f == 5) {
                            M = 0;
                        }
                    }

                    M = 0;

                    num = aux.length - n;

                    if (num == 1) {
                        for (int k = 0; k < 9; k++) {
                            if (matrizAux[k][col] == 0) {
                                int PP = 0, OO = 0;

                                if (col == 0 || col == 3 || col == 6) {
                                    PP = 2;
                                    OO = 1;
                                }

                                if (col == 1 || col == 4 || col == 7) {
                                    PP = 1;
                                    OO = -1;
                                }

                                if (col == 2 || col == 5 || col == 8) {
                                    PP = -1;
                                    OO = -2;
                                }

//                            System.out.println("fila = " + k + " col = " + col + " O = " + OO + " P = " + PP + " M = " + M + " val =" + val);
                                ban = verificarColumna(val, col, k, OO, PP, M);
                                if (ban == false) {
//                                System.out.println("val = "+val);

                                    matrizAux[k][col] = val;
                                }

                            }

                            M--;
                            if (k == 2 || k == 5) {
                                M = 0;
                            }
                        }

                    }

                    n = 0;
                }

                P--;
                O--;
                col++;

                if (P == 0) {
                    P = -1;
                }

                if (O == 0) {
                    O = -1;
                }

                if (col == 3 || col == 6) {
                    P = 2;
                    O = 1;
                }
            }
        }

        obtenerPasoTresUno();

    }

    public void obtenerPasoTresUno() {

        int val;
        int n = 0;

        int num;

        boolean ban;

        int fil = 0, col = 0, O = 1, P = 2, M;

        for (int c = 0; c < 9; c++) {

            for (int i = 0; i < 9; i++) {
                vector[i] = matrizAux[fil][i];

            }
            int r = 0;

            for (int i = 0; i < 9; i++) {
                if (vector[i] == 0) {
                    r = 1;
                }
            }

            if (r == 1) {

                int aux[] = obtenerNumerosFaltantes();

////            System.out.print("fil = "+fil+" { ");
////            for (int i = 0; i < aux.length; i++) {
////                System.out.print(aux[i]);
////            }
////            System.out.println(" }");
                for (int i = 0; i < aux.length; i++) {
                    val = aux[i];

                    M = 0;
                    col = 0;

                    for (int f = 0; f < 9; f++) {

//                    System.out.println("fila = " + fil + " col = " + col + " O = " + O + " P = " + P + " M = " +M);
                        if (matrizAux[fil][col] == 0) {
                            ban = verificarFila(val, col, fil, O, P, M);

                            if (ban == true) {
                                n++;
                            }
                        }

                        col++;
                        M--;
                        if (f == 2 || f == 5) {
                            M = 0;
                        }
                    }

                    M = 0;

                    num = aux.length - n;

                    if (num == 1) {
                        for (int k = 0; k < 9; k++) {
                            if (matrizAux[fil][k] == 0) {
                                int PP = 0, OO = 0;

                                if (fil == 0 || fil == 3 || fil == 6) {
                                    PP = 2;
                                    OO = 1;
                                }

                                if (fil == 1 || fil == 4 || fil == 7) {
                                    PP = 1;
                                    OO = -1;
                                }

                                if (fil == 2 || fil == 5 || fil == 8) {
                                    PP = -1;
                                    OO = -2;
                                }

//                            System.out.println("fila = " + k + " col = " + col + " O = " + OO + " P = " + PP + " M = " + M + " val =" + val);
                                ban = verificarFila(val, k, fil, OO, PP, M);
                                if (ban == false) {
//                                System.out.println("val = "+val);

                                    matrizAux[fil][k] = val;
                                }

                            }

                            M--;
                            if (k == 2 || k == 5) {
                                M = 0;
                            }
                        }

                    }

                    n = 0;
                }

                P--;
                O--;
                fil++;

                if (P == 0) {
                    P = -1;
                }

                if (O == 0) {
                    O = -1;
                }

                if (fil == 3 || fil == 6) {
                    P = 2;
                    O = 1;
                }

            }
        }

    }

    public int[][] getMatrizAux() {
        return matrizAux;
    }

}
