/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PasoCuatro;
import model.PasoDos;
import model.PasoTres;
import model.PasoUno;

/**
 *
 * @author Sebastian
 */
public class Sudoku {

    private int matriz[][];
    PasoUno pasUno;
    PasoDos pasDos;
    PasoTres pasTres;
    PasoCuatro pasCuatro;
    
    

    public Sudoku(int[][] matriz) {
       this.matriz = matriz;
        
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void ejecutarPasos() {

        ejecutarPasoUno();
        ejecutarPasoDos();
        ejecutarPasoTres();

    }

    private void ejecutarPasoUno() {
        boolean ban;

        ban = verificarErrores();

        if (ban == false) {
            int mat[][] = obtenerdatosMatriz();
            pasUno = new PasoUno();
            pasUno.ejecutarPasoUno(matriz);
            ban = compararMatrices(mat);

            matriz = pasUno.getMatrizAux();

            if (ban == true) {
                ejecutarPasos();
            }
        }
        

    }

    private int[][] obtenerdatosMatriz() {

        int mat[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                mat[j][i] = matriz[j][i];
            }
        }

        return mat;
    }
    
    

    private void ejecutarPasoDos() {
        boolean ban;

        ban = verificarErrores();

        if (ban == false) {
            int mat[][] = obtenerdatosMatriz();
            pasDos = new PasoDos();

            pasDos.obtenerPasoDos(matriz);

            ban = compararMatrices(mat);

            matriz = pasDos.getMatrizAux();

            if (ban) {
                ejecutarPasos();
            }
        }
        
    }

    private void ejecutarPasoTres() {
        boolean ban;

        ban = verificarErrores();

        if (ban == false) {
            int mat[][] = obtenerdatosMatriz();
            pasTres = new PasoTres();
            pasTres.ejecuutarPasoTres(matriz);

            ban = compararMatrices(mat);

            matriz = pasTres.getMatrizAux();

            if (ban) {
                ejecutarPasos();
            }
            
        }
        
    }

    
    
    

    public void ejecutarPasoFinal() {
        boolean ban;
        int mat[][] = obtenerdatosMatriz();
        pasCuatro = new PasoCuatro();
        pasCuatro.ejecuutarPasoCuatro(matriz);

        ban = compararMatrices(mat);

        matriz = pasCuatro.getMatrizAux();

    }

    public boolean compararMatrices(int mat[][]) {
        boolean ban = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (mat[j][i] != matriz[j][i]) {

                    ban = true;
                }
            }
        }

        return ban;
    }

    public int contarCeros() {
        int num = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matriz[i][j] == 0) {
                    num++;
                }
            }
        }

        return num;
    }
    
    

    public boolean verificarErrores() {

        int n = 0;

        boolean ban = false;

        for (int k = 0; k < 9; k++) {

            for (int i = 0; i < 9; i++) {
                n = 0;
                for (int j = 0; j < 9; j++) {
                    if (matriz[i][j] == (k + 1)) {
                        n++;

                        if (1 < n) {
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
                        if (matriz[j][i] == (k + 1)) {
                            n++;
                            if (1 < n) {
                                ban = true;
                                
                                break;
                            }
                        }

                    }

                }
            }
        }

        if (ban == false) {

            int fil,fl = 0, col,cl = 0;

            for (int i = 0; i < 9; i++) {

                for (int k = 0; k < 9; k++) {
                    fil = fl;
                    col = cl;
                    n = 0;
                    for (int j = 0; j < 9; j++) {

                        if (matriz[fil][col] == (k + 1)) {
                            n++;
                            if (1 < n) {
                                ban = true;
                                
                                break;
                            }
                        }

                        fil ++;
                        if (j == 2 || j == 5) {
                            col ++;
                            fil = fl;
                        }
                    }
                }
                
                cl += 3;
                if (i == 2 || i == 5) {
                    fl += 3;
                    cl = 0;
                }
            }

        }

        return ban;
    }
}
