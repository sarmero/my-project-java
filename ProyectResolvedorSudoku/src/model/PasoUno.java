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
public class PasoUno extends Herramientas {

    public void VerificarNumero(int mat[][], int fil, int col, int O,
            int P, int M, int N, int caso, int R, int Qb, int Qc, int OO, int PP, int MM,
            int NN, int caso2, int Rb, int Rc, int Q) {

        boolean ban, banFil2 = false, banFil3 = false;

        matrizAux = mat;

        int val, pos;

        if (matrizAux[fil][col] != 0) {

            val = matrizAux[fil][col];
            ban = buscarMatriz(val, col + O, fil + M);//b1

            if (ban == true) {

                ban = buscarMatriz(val, col + P, fil + N);//c2
                if (ban == false) {

                    ban = buscarMatrizFilas(val, R, Qc, caso);
                    banFil2 = buscarMatrizFilas(val, R, Qc + 1, caso);
                    banFil3 = buscarMatrizFilas(val, R, Qc + 2, caso);

                    pos = verificarCuadro(col + P, fil + N);
                    if (pos != 0) {
                        ban = true;
                    }

                    pos = verificarCuadro(col + P, fil + 1 + N);
                    if (pos != 0) {
                        banFil2 = true;
                    }

                    pos = verificarCuadro(col + P, fil + 2 + N);
                    if (pos != 0) {
                        banFil3 = true;
                    }

                    if (ban == true && banFil2 == true) {
                        llenarMatriz_dos(val, col + P, fil + 2 + N);
                    } else if (ban == true && banFil3 == true) {
                        llenarMatriz_dos(val, col + P, fil + 1 + N);
                    } else if (banFil2 == true && banFil3 == true) {
                        llenarMatriz_dos(val, col + P, fil + N);
                    }

                }
            } else {
                ban = buscarMatriz(val, col + P, fil + M);//b2
                if (ban == true) {
                    ban = buscarMatriz(val, col + O, fil + N);//c1
                    if (ban == false) {

                        ban = buscarMatrizFilas(val, R, Qc, caso);
                        banFil2 = buscarMatrizFilas(val, R, Qc + 1, caso);
                        banFil3 = buscarMatrizFilas(val, R, Qc + 2, caso);

                        pos = verificarCuadro(col + O, fil + N);
                        if (pos != 0) {
                            ban = true;
                        }

                        pos = verificarCuadro(col + O, fil + 1 + N);
                        if (pos != 0) {
                            banFil2 = true;
                        }

                        pos = verificarCuadro(col + O, fil + 2 + N);
                        if (pos != 0) {
                            banFil3 = true;
                        }

                        if (ban == true && banFil2 == true) {
                            llenarMatriz_dos(val, col + O, fil + 2 + N);
                        } else if (ban == true && banFil3 == true) {
                            llenarMatriz_dos(val, col + O, fil + 1 + N);
                        } else if (banFil2 == true && banFil3 == true) {
                            llenarMatriz_dos(val, col + O, fil + N);
                        }
                    }
                } else {

                    //c1 
                    ban = buscarMatriz(val, col + O, fil + N);//bscar en c1

                    if (ban == true) {
                        //b2

                        ban = buscarMatrizFilas(val, R, Qb, caso);
                        banFil2 = buscarMatrizFilas(val, R, Qb + 1, caso);
                        banFil3 = buscarMatrizFilas(val, R, Qb + 2, caso);

                        pos = verificarCuadro(col + P, fil + M);
                        if (pos != 0) {
                            ban = true;
                        }

                        pos = verificarCuadro(col + P, fil + 1 + M);
                        if (pos != 0) {
                            banFil2 = true;
                        }

                        pos = verificarCuadro(col + P, fil + 2 + M);
                        if (pos != 0) {
                            banFil3 = true;
                        }

                        if (ban == true && banFil2 == true) {
                            llenarMatriz_dos(val, col + P, fil + 2 + M);
                        } else if (ban == true && banFil3 == true) {
                            llenarMatriz_dos(val, col + P, fil + 1 + M);
                        } else if (banFil2 == true && banFil3 == true) {
                            llenarMatriz_dos(val, col + P, fil + M);
                        }

                    } else {
                        //c2 
                        ban = buscarMatriz(val, col + P, fil + N);//bscar en c2

                        if (ban == true) {
                            ban = buscarMatrizFilas(val, R, Qb, caso);
                            banFil2 = buscarMatrizFilas(val, R, Qb + 1, caso);
                            banFil3 = buscarMatrizFilas(val, R, Qb + 2, caso);

                            pos = verificarCuadro(col + O, fil + M);
                            if (pos != 0) {
                                ban = true;
                            }

                            pos = verificarCuadro(col + O, fil + 1 + M);
                            if (pos != 0) {
                                banFil2 = true;
                            }

                            pos = verificarCuadro(col + O, fil + 2 + M);
                            if (pos != 0) {
                                banFil3 = true;
                            }

                            if (ban == true && banFil2 == true) {
                                llenarMatriz_dos(val, col + O, fil + 2 + M);
                            } else if (ban == true && banFil3 == true) {
                                llenarMatriz_dos(val, col + O, fil + 1 + M);
                            } else if (banFil2 == true && banFil3 == true) {
                                llenarMatriz_dos(val, col + O, fil + M);
                            }

                            //fin de algoritmo
                        }
                    }
                }

            }

            ban = filaBuscarMatriz(val, col + MM, fil + OO);//b1

            if (ban == true) {

                ban = filaBuscarMatriz(val, col + NN, fil + PP);//c2
                if (ban == false) {

                    ban = buscarMatrizColumna(val, Rc, Q, caso2);
                    banFil2 = buscarMatrizColumna(val, Rc + 1, Q, caso2);
                    banFil3 = buscarMatrizColumna(val, Rc + 2, Q, caso2);

                    pos = verificarCuadro(col + NN, fil + PP);
                    if (pos != 0) {
                        ban = true;
                    }

                    pos = verificarCuadro(col + 1 + NN, fil + PP);
                    if (pos != 0) {
                        banFil2 = true;
                    }

                    pos = verificarCuadro(col + 2 + NN, fil + PP);
                    if (pos != 0) {
                        banFil3 = true;
                    }

                    if (ban == true && banFil2 == true) {
                        llenarMatriz_dos(val, col + 2 + NN, fil + PP);
                    } else if (ban == true && banFil3 == true) {
                        llenarMatriz_dos(val, col + 1 + NN, fil + PP);
                    } else if (banFil2 == true && banFil3 == true) {
                        llenarMatriz_dos(val, col + NN, fil + PP);
                    }

                }
            } else {
                ban = filaBuscarMatriz(val, col + MM, fil + PP);//b2
                if (ban == true) {
                    ban = filaBuscarMatriz(val, col + NN, fil + OO);//c1
                    if (ban == false) {

                        ban = buscarMatrizColumna(val, Rc, Q, caso2);
                        banFil2 = buscarMatrizColumna(val, Rc + 1, Q, caso2);
                        banFil3 = buscarMatrizColumna(val, Rc + 2, Q, caso2);

                        pos = verificarCuadro(col + NN, fil + OO);
                        if (pos != 0) {
                            ban = true;
                        }

                        pos = verificarCuadro(col + 1 + NN, fil + OO);
                        if (pos != 0) {
                            banFil2 = true;
                        }

                        pos = verificarCuadro(col + 2 + NN, fil + OO);
                        if (pos != 0) {
                            banFil3 = true;
                        }

                        if (ban == true && banFil2 == true) {
                            llenarMatriz_dos(val, col + 2 + NN, fil + OO);
                        } else if (ban == true && banFil3 == true) {
                            llenarMatriz_dos(val, col + 1 + NN, fil + OO);
                        } else if (banFil2 == true && banFil3 == true) {
                            llenarMatriz_dos(val, col + NN, fil + OO);
                        }
                    }
                } else {

                    //c1 
                    ban = filaBuscarMatriz(val, col + NN, fil + OO);//bscar en c1

                    if (ban == true) {
                        //b2

                        ban = buscarMatrizColumna(val, Rb, Q, caso2);
                        banFil2 = buscarMatrizColumna(val, Rb + 1, Q, caso2);
                        banFil3 = buscarMatrizColumna(val, Rb + 2, Q, caso2);

                        pos = verificarCuadro(col + MM, fil + PP);
                        if (pos != 0) {
                            ban = true;
                        }

                        pos = verificarCuadro(col + 1 + MM, fil + PP);
                        if (pos != 0) {
                            banFil2 = true;
                        }

                        pos = verificarCuadro(col + 2 + MM, fil + PP);
                        if (pos != 0) {
                            banFil3 = true;
                        }

                        if (ban == true && banFil2 == true) {
                            llenarMatriz_dos(val, col + 2 + MM, fil + PP);
                        } else if (ban == true && banFil3 == true) {
                            llenarMatriz_dos(val, col + 1 + MM, fil + PP);
                        } else if (banFil2 == true && banFil3 == true) {
                            llenarMatriz_dos(val, col + MM, fil + PP);
                        }

                    } else {
                        //c2 
                        ban = filaBuscarMatriz(val, col + NN, fil + PP);//bscar en c2

                        if (ban == true) {
                            ban = buscarMatrizColumna(val, Rb, Q, caso2);
                            banFil2 = buscarMatrizColumna(val, Rb + 1, Q, caso2);
                            banFil3 = buscarMatrizColumna(val, Rb + 2, Q, caso2);

                            pos = verificarCuadro(col + MM, fil + OO);
                            if (pos != 0) {
                                ban = true;
                            }

                            pos = verificarCuadro(col + 1 + MM, fil + OO);
                            if (pos != 0) {
                                banFil2 = true;
                            }

                            pos = verificarCuadro(col + 2 + MM, fil + OO);
                            if (pos != 0) {
                                banFil3 = true;
                            }

                            if (ban == true && banFil2 == true) {
                                llenarMatriz_dos(val, col + 2 + MM, fil + OO);
                            } else if (ban == true && banFil3 == true) {
                                llenarMatriz_dos(val, col + 1 + MM, fil + OO);
                            } else if (banFil2 == true && banFil3 == true) {
                                llenarMatriz_dos(val, col + MM, fil + OO);
                            }

                            //fin de algoritmo
                        }
                    }
                }

            }

        }
    }

    private int verificarCuadro(int col, int fil) {
        int ps = 0;

        if (matrizAux[fil][col] != 0) {
            ps = 1;

        }

        return ps;
    }

    private boolean buscarMatrizFilas(int val, int col, int fil, int caso) {
        boolean ban = false;

        for (int i = col; i < 9; i++) {

            if (caso == 2) {
                if (i == 3) {
                    i = 6;
                }
            }

            if (caso == 3) {
                if (i == 6) {
                    break;
                }
            }

            if (matrizAux[fil][i] == val) {
                ban = true;
                break;
            }
        }

        return ban;
    }

    private boolean buscarMatrizColumna(int val, int col, int fil, int caso) {
        boolean ban = false;

        for (int i = fil; i < 9; i++) {

            if (caso == 2) {
                if (i == 3) {
                    i = 6;
                }
            }

            if (caso == 3) {
                if (i == 6) {
                    break;
                }
            }

            if (matrizAux[i][col] == val) {
                ban = true;
                break;
            }
        }

        return ban;
    }

    public void ejecutarPasoUno(int mat[][]) {
        matrizAux = mat;
        int i, n, o, p, a, t, m, caso, r, qB, qC, w, v, oo, pp, mm, nn, caso2, rC, rB, q;
        t = 0;
        w = 3;
        v = 6;
        r = 3;
        qC = 6;
        qB = 3;

        caso2 = 1;

        rB = 3;
        q = 3;

        a = 3;
        for (int k = 0; k < 3; k++) {

            p = 2;
            o = 1;
            caso = 1;
            mm = 3;
            nn = 6;
            rC = 6;
            for (int j = 0; j < 9; j++) {

                m = w;
                n = v;
                oo = 1;
                pp = 2;

                for (i = t; i < a; i++) {

                    VerificarNumero(matrizAux, i, j, o, p, m, n, caso, r, qB, qC, oo, pp, mm, nn, caso2, r, rC, q);

                    m--;
                    n--;

                    oo--;
                    if (oo == 0) {
                        oo = -1;
                    }

                    pp--;
                    if (pp == 0) {
                        pp = -1;
                    }

                }

                mm--;
                if (mm == 0) {
                    mm = -3;
                }

                nn--;
                if (nn == 0) {
                    nn = -3;
                }

                o--;
                if (o == 0) {
                    o = -1;
                }

                p--;
                if (p == 0) {
                    p = -1;
                }

                if (j == 2 || j == 5) {
                    o = 1;
                    p = 2;
//                    caso = 1;

                    caso++;

                    if (r == 3) {
                        r = 0;
                        rB = 0;

                    }
                }

                if (j == 5) {
                    rC = 3;
                }
            }

            caso2++;
            w = -3;
            v = 3;
            qB = 0;
            q = 0;

            if (k == 1) {
                qC = 3;
                w = -6;
                v = -3;
            }

            r = 3;

            t += 3;

            a = t + 3;

        }

    }

    private void llenarMatriz_dos(int val, int col, int fil) {

        matrizAux[fil][col] = val;
    }
}
