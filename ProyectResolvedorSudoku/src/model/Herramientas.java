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
public class Herramientas {
    private int faltantes[];
    protected int vector[];
    protected int matrizAux[][];

    public Herramientas() {
        vector = new int[9];
    }
    
    public int[][] getMatrizAux() {
        return matrizAux;
    }
    
    protected boolean buscarFilaColumna(int aux[], int fil, int col, int val) {

        boolean ban = false,bn1 = false,bn2 = false;

        for (int k = 0; k < 9; k++) {
            
            
                if (matrizAux[k][col] == val) {

                    bn1 = true;

                }
            

            
                if (matrizAux[fil][k] == val) {
                    bn2 = true;

                }
            

        }
        
        if (bn2 || bn1){
            ban = true;
        }
        

        return ban;
    }

    protected boolean buscarMatriz(int val, int col, int fil) {
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

    protected boolean filaBuscarMatriz(int val, int col, int fil) {
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

    protected int[] obtenerNumerosFaltantes() {

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


        return faltantes;
    }
}
