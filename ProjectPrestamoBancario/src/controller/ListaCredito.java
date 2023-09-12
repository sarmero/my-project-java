/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Credito;

/**
 *
 * @author USER
 */
public class ListaCredito {

    ArrayList<Credito> listaCredito;

    public ListaCredito() {
        listaCredito = new ArrayList<>();
    }

    public void agregarCredito(Credito credito) {
        listaCredito.add(credito);
    }

    public boolean verificarCodigo(int codigo) {
        boolean ban = false;
        for (int i = 0; i < listaCredito.size(); i++) {
            if (listaCredito.get(i).getCodigo() == codigo) {
                ban = true;
            }
        }

        return ban;
    }

    public void mostrarCredito(int identificacion) {

    }

    public String obtenerCredito(int codigo) {

        double va;
        double tazaInteres;
        int numMeses;
        double valorCuoata = 0;
        double val;
        double abono = 0;
        double interes = 0;
        double credito;
        double sumValFinal = 0, sumInteres = 0, sumCredito = 0;
        String reporte = "";

        for (int i = 0; i < listaCredito.size(); i++) {
            if (listaCredito.get(i).getCodigo() == codigo) {
                va = listaCredito.get(i).getCapitalCredito();
                credito = va;
                tazaInteres = listaCredito.get(i).getTazaInteres();
                numMeses = listaCredito.get(i).getNumeroCuota();

                val = Math.pow((1 + tazaInteres), numMeses);
                valorCuoata = va * ((tazaInteres * val) / (val - 1));

                reporte = "Cliente: " + listaCredito.get(i).getCliente() + "\n"
                        + "Credito: " + listaCredito.get(i).getCapitalCredito() + "\n"
                        + "Numero de cuoata: " + listaCredito.get(i).getNumeroCuota() + "\n"
                        + "Valor de la cuota: " + String.format("%.2f",valorCuoata) + "\n\n"
                        + "--------------------------------------------------------------------------\n\n";

                reporte += String.format("%s %10s %25s %10s %20s", "Periodo", "Credito", "Valor Cuota Mensual", "Interes", "Abono al capital") + "\n";
                reporte += String.format("%5d %15.2f %16.2f %17.2f %15.2f", 0, credito, 0, interes, abono) + "\n";

                for (int n = 1; n <= numMeses; n++) {
                    valorCuoata = va * ((tazaInteres * val) / (val - 1));
                    interes = credito * tazaInteres;
                    abono = valorCuoata - interes;
                    reporte += String.format("%5d %15.2f %16.2f %17.2f %15.2f", n, credito, valorCuoata, interes, abono) + "\n";
                    credito = credito - abono;

                    sumCredito += abono;
                    sumInteres += interes;
                    sumValFinal += valorCuoata;
                }

                reporte += "--------------------------------------------------------------------------\n\n";
                reporte += "Valor final: " + String.format("%.2f",sumValFinal) + "\n"
                        + "Interes total: " + String.format("%.2f",sumInteres) + "\n"
                        + "Credicto: " + String.format("%.2f",sumCredito) + "\n";

            }
        }

        return reporte;

    }

}
