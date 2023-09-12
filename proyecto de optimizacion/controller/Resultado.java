/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Ecuacion;

/**
 *
 * @author USER
 */
public class Resultado {

    private Ecuacion funcion;
    private ArrayList<Ecuacion> restrinciones;
    private String texto;
    private int[] filaValidad;
    private boolean optimizar;
    private ArrayList<String> iteracion;
    private int dimx, dimy;
    private boolean bandera;

    public Resultado(ArrayList<Ecuacion> restrinciones, Ecuacion funcion, boolean optimizar) {
        this.restrinciones = restrinciones;
        this.funcion = funcion;
        texto = "";
        filVa();
        this.optimizar = optimizar;
        iteracion = new ArrayList();

    }

    private void filVa() {
        filaValidad = new int[restrinciones.size() + 1];
        for (int i = 0; i < restrinciones.size() + 1; i++) {
            filaValidad[i] = -1;
        }
    }

    private float[] convertirFilaPibote(float[] fila, int pos) {

        float n = 1 / fila[pos];
        float[] filaNueva = new float[fila.length];
        texto = texto + n + "\n";
        String fil = "";

        for (int i = 0; i < fila.length; i++) {
            filaNueva[i] = fila[i] * n;
            fil = fil + filaNueva[i] + "  ";
        }
        texto = texto + "   (" + fil + " )" + "\n\n";

        return filaNueva;

    }

    private float[] operarFilas(float[] filaPibote, int pos, float[] fila) {
        float[] filaNueva = new float[fila.length];
        String fil = "";

        float t = (fila[pos] * -1) / filaPibote[pos];
        texto = texto + t + "\n";

        for (int i = 0; i < fila.length; i++) {
            filaNueva[i] = t * filaPibote[i] + fila[i];
            fil = fil + filaNueva[i] + "  ";
        }
        texto = texto + "   (" + fil + " )" + "\n\n";

        return filaNueva;
    }

    public float[][] tablaSimplex() {
        int tam = restrinciones.size();
        int tam2 = dimx;
        float[][] matriz = new float[tam + 1][tam2];

        for (int i = 0; i < (tam + 2); i++) {
            matriz[0][i] = obtenerFilaFuncion()[i];
        }

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam2; j++) {
                matriz[i + 1][j] = obtenerRestrincion()[i][j];
            }
        }

        return matriz;
    }

    private float[][] obtenerRestrincion() {
        int tam = restrinciones.size();
        int tam2 = restrinciones.get(0).getX().size();
        float[][] fila = new float[tam][tam2 + (2 + tam)];

        for (int k = 0; k < tam; k++) {

            fila[k][0] = 0;

            for (int j = 0; j < tam2; j++) {
                fila[k][j + 1] = restrinciones.get(k).getX().get(j);
            }
            fila[k][tam2 + 1 + k] = 1;
            fila[k][tam2 + (2 + tam) - 1] = restrinciones.get(k).getResultado();

        }

        return fila;
    }

    private float[] obtenerFilaFuncion() {
        float[] fila1 = new float[funcion.getX().size() + restrinciones.size() + 1];

        fila1[0] = 1;

        for (int i = 0; i < restrinciones.get(0).getX().size(); i++) {
            fila1[i + 1] = funcion.getX().get(i) * -1;
        }

        return fila1;
    }

    private int obtenerFilaPibote(int columnaPibote, float[][] restrincion) {
        float[][] filas = restrincion;
        int tam = dimx - 1;
        float n = 0;
        boolean valido;

        if (bandera == true) {
            filVa();
        }

        int pos = 0;

        for (int j = 0; j < restrinciones.size(); j++) {
            if (filas[j][columnaPibote] > 0) {
                if ((filas[j][tam] / filas[j][columnaPibote]) < n || n == 0) {
                    valido = false;
                    for (int i = 0; i < filaValidad.length; i++) {
                        if (filaValidad[i] == (j)) {
                            valido = true;
                            break;
                        }
                    }
                    if (valido == false) {
                        n = filas[j][tam] / filas[j][columnaPibote];
                        pos = j;
                    }
                }
            }
        }

        filaValidad[pos] = pos;

        return pos;
    }

    private int obtenerColumnaPibote(float[] funcion) {
        float[] fun = funcion;
        float n = 0;

        int pos = 0;

        for (int i = 1; i < restrinciones.get(0).getX().size() + 1; i++) {

            if (fun[i] < n || n == 0) {
                n = fun[i];
                pos = i;
            }
        }

        return pos;
    }

    private float[][] cambiarfilas(float[][] tabla, float[] fila, int pos) {

        for (int i = 0; i < fila.length; i++) {
            tabla[pos][i] = fila[i];
        }

        return tabla;
    }

    private float[] obtenerFilasTabla(float[][] tabla, int tamaño, int pos) {
        float[] fila = new float[tamaño];

        for (int i = 0; i < fila.length; i++) {
            fila[i] = tabla[pos][i];

        }

        return fila;
    }

    public void obtenerResultados() {
        float[] auxiliar, resp = new float[restrinciones.size() + 1];
        if (validarRestrinciones() == true) {

            if (optimizar == true) {
                dimx = restrinciones.size() + 2 + restrinciones.get(0).getX().size();
                if (restrinciones.size() > 2) {
                    iterarFilas();
                } else {

                    for (int i = 0; i < 2; i++) {
                        auxiliar = maximizar();
                        if (puntoFatible(auxiliar) == true) {
                            if (auxiliar[0] > resp[0]) {
                                bandera = true;
                                resp = auxiliar;
                            }
                        }
                    }

                }

            } else {

                dimx = restrinciones.get(0).getX().size() + 1;
                if (restrinciones.size() > 2) {
                    iterarFilas();
                } else {

                    for (int i = 0; i < 2; i++) {
                        auxiliar = minimizar();
                        if (puntoFatible(auxiliar) == true) {
                            if (auxiliar[0] < resp[0] || resp[0] == 0) {
                                bandera = true;
                                resp = auxiliar;
                            }
                        }
                    }

                }
            }
        } else {
            if (optimizar == true) {
                texto = "\n\n* Este programa esta diseñado para las Zmax las restriciones deben ser <= ";
            } else {
                texto = "\n\n* Este programa esta diseñado para las Zmin las restriciones deben ser >= ";
            }
        }

    }

    private boolean validarRestrinciones() {

        for (int i = 0; i < restrinciones.size(); i++) {

            if (optimizar == true && !restrinciones.get(i).getSigno().equals("<=")) {
                return false;
            } else if (optimizar == false && !restrinciones.get(i).getSigno().equals(">=")) {
                return false;
            }

        }

        return true;
    }

    private float[] maximizar() {
        float[] respuesta = new float[restrinciones.get(0).getX().size() + 1];
        float[][] tabla = tablaSimplex();
        texto = texto + "\n" + "       Tabla Simplex" + "\n";
        mostrarMatriz(tabla, (restrinciones.size() + 1));
        int tam = dimx;
        tabla = obtenerTablaFinal(tabla, obtenerFilaFuncion(), obtenerRestrincion());

        for (int i = 0; i < respuesta.length; i++) {
            for (int j = 0; j < restrinciones.size() + 1; j++) {
                if (tabla[0][i] == 0 || i == 0) {
                    if (tabla[j][i] == 1) {
                        respuesta[i] = tabla[j][tam - 1];
                    }
                } else {
                    respuesta[i] = 0;
                    break;
                }
            }
        }

        texto = texto + "\n\t" + "Resultados " + "\n" + "\t" + "Z" + " = " + respuesta[0];
        for (int i = 1; i < respuesta.length; i++) {
            texto = texto + "       " + "X" + i + " = " + respuesta[i];
        }

        return respuesta;
    }

    private float[][] terminarTabla(float[][] tabla) {
        float[][] restrin;
        float[] fila;
        int tam = dimx;

        for (int j = 0; j <= (funcion.getX().size()); j++) {

            if (tabla[0][j] < 0) {
                fila = new float[tam];
                restrin = new float[restrinciones.size()][tam];
                for (int i = 0; i < restrinciones.size(); i++) {
                    fila = obtenerFilasTabla(tabla, tam, i + 1);
                    for (int k = 0; k < tam; k++) {
                        restrin[i][k] = fila[k];
                    }
                }
                tabla = obtenerTablaFinal(tabla, obtenerFilasTabla(tabla, tam, 0), restrin);

            }

        }

        return tabla;
    }

    private float[] iterarFilas() {
        String combinaciones = "";
        float[][] restrincion;
        int tam = dimx;
        float[] resp = new float[restrinciones.get(0).getX().size() + 1];
        float[] auxiliar = new float[tam];
        int num;
        restrincion = new float[restrinciones.size()][restrinciones.get(0).getX().size()];

        for (int i = 0; i < restrinciones.size(); i++) {
            for (int j = 0; j < restrinciones.get(0).getX().size(); j++) {
                restrincion[i][j] = restrinciones.get(i).getX().get(j);
            }
        }

        for (int i = 0; i < restrinciones.size(); i++) {
            combinaciones = combinaciones + i;
        }

        permute("", combinaciones);
        float[][] respuesta = new float[iteracion.size()][restrinciones.get(0).getX().size() + 1];

        for (int l = 0; l < iteracion.size(); l++) {

            filVa();
            texto = texto + "\n\n\n\n";
            for (int i = 0; i < 100; i++) {
                texto = texto + "-";
            }
            texto = texto + "\n\nIteraion #" + (l + 1) + "\n\n";

            for (int m = 0; m < iteracion.get(l).length(); m++) {
                num = Integer.valueOf(iteracion.get(l).charAt(m) + "");

                for (int i = 0; i < restrinciones.get(num).getX().size(); i++) {
                    restrinciones.get(m).getX().set(i, restrincion[num][i]);
                }
            }

            bandera = false;
            resp = new float[restrinciones.get(0).getX().size() + 1];
            auxiliar = new float[restrinciones.get(0).getX().size() + 1];

            if (optimizar == true) {

                for (int i = 0; i < 2; i++) {
                    auxiliar = maximizar();
                    if (puntoFatible(auxiliar) == true) {

                        if (auxiliar[0] > resp[0]) {
                            bandera = true;
                            resp = auxiliar;
                        }
                    }
                }

            } else {

                for (int i = 0; i < 2; i++) {
                    auxiliar = minimizar();
                    if (puntoFatible(auxiliar) == true) {

                        if (auxiliar[0] < resp[0] || resp[0] == 0) {
                            filVa();
                            bandera = true;
                            resp = auxiliar;
                        }
                    }
                }
            }

            for (int i = 0; i < resp.length; i++) {
                respuesta[l][i] = resp[i];
            }
        }

        int pos = 0;
        float res = 0;

        for (int j = 0; j < iteracion.size(); j++) {
            if (optimizar == true) {
                if (respuesta[j][0] > res) {
                    res = respuesta[j][0];
                    pos = j;
                }
            } else {
                if (respuesta[j][0] < res || res == 0) {
                    res = respuesta[j][0];
                    pos = j;
                }
            }

        }

        for (int i = 0; i < resp.length; i++) {
            resp[i] = respuesta[pos][i];
        }

        texto = texto + "\n\n\n\n";
        for (int i = 0; i < 100; i++) {
            texto = texto + "*";
        }

        texto = texto + "\n\t\t" + "Solucion " + "\n" + "\t" + "Z" + " = " + resp[0];
        for (int i = 1; i < resp.length; i++) {
            texto = texto + "       " + "X" + i + " = " + resp[i];
        }

        texto = texto + "\n";
        for (int i = 0; i < 100; i++) {
            texto = texto + "*";
        }

        texto = texto + "\n\n\n\n\t\tPosibles Soluciones\n\n";

        for (int i = 0; i < iteracion.size(); i++) {
            texto = texto + "Z = " + respuesta[i][0];
            for (int j = 1; j < funcion.getX().size() + 1; j++) {
                texto = texto + "         X" + (j) + " = " + respuesta[i][j];
            }
            texto = texto + "\n";
        }

        return resp;

    }

    private boolean puntoFatible(float[] auxiliar) {
        boolean ban = false;
        float fun = 0;

        for (int i = 0; i < funcion.getX().size(); i++) {
            if (auxiliar[i + 1] < 0) {
                return false;
            } else {
                fun = fun + auxiliar[i + 1] * funcion.getX().get(i);
            }

        }

        if (fun == auxiliar[0]) {
            ban = true;
        }

        return ban;
    }

    private void permute(String prefix, String s) {
        int N = s.length();

        if (N == 0) {
            iteracion.add(prefix);
//            System.out.println(" " + prefix);
        }

        for (int i = 0; i < N; i++) {
            permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, N));
        }
    }

    private void mostrarMatriz(float[][] tabla, int dim) {
        String tab = "\n";
        int tam = dimx;

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < tam; j++) {
                tab = tab + String.format("%.2f",  tabla[i][j]) + "      ";
            }
            tab = tab + "\n";
        }
        texto = texto + tab + "\n\n";

    }

    private float[][] obtenerTablaFinal(float[][] tab, float[] funcion, float[][] restrincion) {
        float[][] tabla = tab;
        dimx = restrinciones.size() + 2 + restrinciones.get(0).getX().size();

        int colPibote = obtenerColumnaPibote(funcion);
        int filPibote = obtenerFilaPibote(colPibote, restrincion) + 1;
        texto = texto + "Columna Pibote = " + (colPibote + 1) + "\n" + "Fila Pibote = " + (filPibote + 1) + "\n\n";
        tabla = operarTabla(tabla, colPibote, filPibote, 1, dimx);
        tabla = terminarTabla(tabla);

        return tabla;
    }

    private float[][] operarTabla(float[][] tab, int colPibote, int filPibote, int n, int tam) {
        float[][] tabla = tab;

        float[] filPib = new float[tam];

        texto = texto + "Fila " + (filPibote + 1) + " = Fila" + (filPibote + 1) + " * ";
        filPib = convertirFilaPibote(obtenerFilasTabla(tabla, filPib.length, filPibote), colPibote);

        tabla = cambiarfilas(tabla, filPib, filPibote);
        mostrarMatriz(tabla, (restrinciones.size() + n));

        for (int i = 0; i < (restrinciones.size() + n); i++) {
            if (i != filPibote) {
                texto = texto + "Fila " + (i + 1) + " = Fila" + (i + 1) + " + Fila" + (filPibote + 1) + " * ";
                tabla = cambiarfilas(tabla, operarFilas(filPib, colPibote, obtenerFilasTabla(tabla, filPib.length, i)), i);
            }
        }
        mostrarMatriz(tabla, (restrinciones.size() + n));

        return tabla;
    }

    public String operarM(String polinomio) {
        String ecua = "";
        int n = 0;
        float num = 0;
        String[] ecuac;

        for (int i = 0; i < polinomio.length(); i++) {
            ecua = ecua + polinomio.charAt(i);
            if (polinomio.charAt(i) == 'M') {
                n++;
            }

            if (n == 2) {

                ecuac = ecua.split("M");

                for (int j = 0; j < ecua.length(); j++) {
                    switch (ecua.charAt(j)) {
                        case '+':
                            num = Float.valueOf(ecuac[0] + "") + Float.valueOf(ecuac[1] + "");
                            break;
                        case '-':
                            num = Float.valueOf(ecuac[0] + "") + Float.valueOf(ecuac[1] + "");
                            break;

                        default:
                            break;
                    }
                }

                ecua = num + "M";
                n = 1;
            }

        }

        return ecua;

    }

    public Float operarCjZj(String cjzj, int numMayor) {
        String val = "", valM = "";
        float num = 0;

        boolean ban = false;

        for (int i = 0; i < cjzj.length(); i++) {
            if ((cjzj.charAt(i) == '+' || cjzj.charAt(i) == '-') && i != 0) {
                ban = true;
                break;
            }
        }

        if (ban == true) {
            for (int i = 0; i < cjzj.length(); i++) {

                if (cjzj.charAt(i) == '+') {
                    for (int j = (i + 1); j < cjzj.length(); j++) {
                        if (cjzj.charAt(j) == 'M') {
                            num = Float.valueOf(valM);
                            num = Float.valueOf(val) + num * numMayor;
                            break;
                        }
                        valM = valM + cjzj.charAt(j);
                    }

                } else if (cjzj.charAt(i) == '-' && i != 0) {
                    for (int j = (i + 1); j < cjzj.length(); j++) {
                        if (cjzj.charAt(j) == 'M') {
                            num = Float.valueOf(valM);
                            num = Float.valueOf(val) - num * numMayor;
                            break;
                        }
                        valM = valM + cjzj.charAt(j);
                    }
                }

                val = val + cjzj.charAt(i);
            }
        } else {

            for (int j = 0; j < cjzj.length(); j++) {
                if (cjzj.charAt(j) == 'M') {
                    num = Float.valueOf(valM);
                    num = num * numMayor;
                    break;
                }
                valM = valM + cjzj.charAt(j);
            }

        }

        return num;
    }

    private float[][] obtenerRestrincionesMin() {
        int tam = funcion.getX().size() + restrinciones.size() * 2;
        int tam2 = restrinciones.get(0).getX().size();
        float[][] res = new float[restrinciones.size()][tam + 1];
        int n = 0;

        for (int k = 0; k < restrinciones.size(); k++) {

            for (int j = 0; j < tam2; j++) {
                res[k][j] = restrinciones.get(k).getX().get(j);
            }
            res[k][tam2 + n + k] = -1;
            res[k][tam2 + n + 1 + k] = 1;
            res[k][tam] = restrinciones.get(k).getResultado();
            n++;
        }

        return res;
    }

    private String[] obtenerCj() {
        String[] cj = new String[funcion.getX().size() + 1 + restrinciones.size() * 2];

        for (int j = 0; j < funcion.getX().size(); j++) {
            cj[j] = funcion.getX().get(j) + "";
        }

        for (int i = funcion.getX().size(); i < cj.length; i++) {
            cj[i] = "0";
            if ((i + 1) == cj.length) {
                break;
            }
            cj[i + 1] = "M";
            i++;
        }

        return cj;
    }

    private float[] minimizar() {
        int tam = funcion.getX().size() + 1 + restrinciones.size() * 2;
        float[][] res = obtenerRestrincionesMin();
        String[] M = new String[restrinciones.size()];
        String[] cj = obtenerCj();
        int colPibote;
        int filPibote;
        boolean ban = false;
        dimx = tam;

        texto = texto + "\n\t" + "       Tabla Simplex" + "\n";

        for (int i = 0; i < cj.length - 1; i++) {
            texto = texto + cj[i] + "       ";
        }

        mostrarMatriz(res, (restrinciones.size()));

        for (int i = 0; i < restrinciones.size(); i++) {
            M[i] = "M";
        }

        for (int i = 0; i < restrinciones.size(); i++) {

            colPibote = obtenerColumnaPiboteMin(res, M, cj, ban);
            filPibote = obtenerFilaPibote(colPibote, res);
            texto = texto + "Columna Pibote = " + (colPibote + 1) + "\n" + "Fila Pibote = " + (filPibote + 1) + "\n\n";
            res = operarTabla(res, colPibote, filPibote, 0, tam);
            M[filPibote] = cj[colPibote];
            ban = true;
        }

        float[] respuesta = new float[funcion.getX().size() + 1];
        float num = 0;

        for (int i = 0; i < restrinciones.size(); i++) {
            for (int j = 0; j < funcion.getX().size(); j++) {
                if (M[i].equals(funcion.getX().get(j).toString())) {
                    respuesta[j + 1] = res[i][tam - 1];
                    num = num + res[i][tam - 1] * Float.valueOf(M[i]);
                }
            }
        }
        respuesta[0] = num;

        texto = texto + "\n\t" + "Resultados " + "\n" + "\t" + "Z" + " = " + respuesta[0];
        for (int i = 1; i < respuesta.length; i++) {
            texto = texto + "       " + "X" + i + " = " + respuesta[i];
        }

        return respuesta;
    }

    public int obtenerColumnaPiboteMin(float[][] restrincion, String[] M, String[] ccj, boolean ban) {
        int tam = funcion.getX().size() + 1 + restrinciones.size() * 2;
        float[][] res = restrincion;
        String n = "";
        String[] cj = new String[ccj.length];
        String[] cjZj = new String[tam];
        String[] zj = new String[tam];
        float[] mayor = new float[tam];
        double num = 0;
        float numMayor;
        int pos = 0;

        for (int i = 0; i < cj.length; i++) {
            cj[i] = ccj[i];
        }

        for (int i = 0; i < tam; i++) {
            n = "";
            for (int j = 0; j < M.length; j++) {
                if ("M".equals(M[j])) {

                    n = n + res[j][i] + M[j];

                    if (j < M.length - 1) {
                        if (res[j + 1][i] >= 0 && M[j + 1].equals("M")) {

                            n = n + "+";
                        }
                    }
                } else {
                    num = num + Float.valueOf(M[j]) * res[j][i];
                }
            }

            zj[i] = operarM(n);

            if (ban == true) {
                if (!cj[i].equals("M")) {
                    cj[i] = (Float.valueOf(cj[i]) + (num * -1)) + "";

                    if (zj[i].charAt(0) != '-') {
                        cjZj[i] = cj[i] + "-" + zj[i];
                    } else {
                        cjZj[i] = cj[i] + zj[i];
                    }

                    if (cj[i].equals("0.0")) {
                        cjZj[i] = zj[i].replace("-", "");
                    }

                } else {

                    if (zj[i].charAt(0) == '-') {
                        zj[i] = zj[i].replace("-", "");
                    }

                    zj[i] = operarM("1" + cj[i] + zj[i]);

                    if (num == 0 && zj[i].equals("0.0M")) {
                        cjZj[i] = "0.0M";
                    } else {
                        if (zj[i].charAt(0) == '-') {
                            cjZj[i] = (-1 * num) + zj[i];
                        } else {
                            cjZj[i] = (-1 * num) + "+" + zj[i];
                        }

                    }

                }

            } else if (zj[i].charAt(0) != '-') {
                if (!cj[i].equals("M") && !cj[i].equals("0")) {
                    cjZj[i] = cj[i] + "-" + zj[i];
                } else if (cj[i].equals("M")) {
                    cjZj[i] = operarM("1" + cj[i] + zj[i]);
                } else if (cj[i].equals("0")) {
                    cjZj[i] = zj[i] + "";
                }

            } else {
                if (!cj[i].equals("M") && !cj[i].equals("0")) {
                    cjZj[i] = cj[i] + zj[i];
                } else if (cj[i].equals("M")) {
                    cjZj[i] = operarM("1" + cj[i] + zj[i]);
                } else if (cj[i].equals("0")) {
                    cjZj[i] = zj[i];
                }

            }

            mayor[i] = operarCjZj(cjZj[i], 1000000);
            num = 0;

        }

        for (int i = 0; i < mayor.length - 1; i++) {
            numMayor = mayor[i];
            if (numMayor < num) {
                num = numMayor;
                pos = i;
            }
        }

        return pos;
    }

    public String getTexto() {
        return texto;
    }

}
