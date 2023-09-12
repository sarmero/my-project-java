/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ListaCredito;
import java.util.Scanner;
import model.Credito;

/**
 *
 * @author USER
 */
public class Menu {

    ListaCredito gestorListaCredito;
    Scanner numero, texto;

    public Menu() {
        gestorListaCredito = new ListaCredito();
        texto = new Scanner(System.in);
        numero = new Scanner(System.in);
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("###############################");
            System.out.println("--PROGRAMAS CREDITO BANCARIO: " + "\n");
            System.out.println("1. Registrar Credito");
            System.out.println("2. Mostrar Credicto");
            System.out.println("3. Salir");
            System.out.print("\nIngresar opcion: ");

            opcion = numero.nextInt();

            switch (opcion) {

                case 1:
                    registrarCredito();
                    break;
                case 2:
                    mostrarCredito();
                    break;
            }
        } while (opcion != 3);
    }

    private void registrarCredito() {
        String nombrecliente;
        int identificacion;
        int codigo = 0;
        int capitalCredito;
        int numeroCuota;
        double tasaInteres;
        boolean verificarCodigo = true;
        
        System.out.println("\n\n*** Registrar Credicto ***" + "\n");

        System.out.print("Nombre cliente: ");
        nombrecliente = texto.nextLine();

        System.out.print("Identificacion: ");
        identificacion = numero.nextInt();

        while (verificarCodigo == true) {

            System.out.print("Codigo del credito: ");
            codigo = numero.nextInt();
            
            verificarCodigo = gestorListaCredito.verificarCodigo(codigo);

            if (verificarCodigo == true) {
                System.out.println("**** El codigo ya existe por favor elija otro ***");
            }
        }

        System.out.print("Monto del credito: ");
        capitalCredito = numero.nextInt();

        System.out.print("Numero de cuotas: ");
        numeroCuota = numero.nextInt();

        System.out.print("Tasa de interes: ");
        tasaInteres = numero.nextDouble();

        Credito credito = new Credito(nombrecliente, identificacion, codigo, capitalCredito, numeroCuota, tasaInteres);

        gestorListaCredito.agregarCredito(credito);

        System.out.println("         ¡Credito agregado con exito!\n\n");

    }

    private void mostrarCredito() {
        String reporte;
        int codigo;
        
        System.out.println("\n\n*** Reporte Credicto ***" + "\n");

        System.out.print("Ingrese el codigo del credito: ");
        codigo = numero.nextInt();

        reporte = gestorListaCredito.obtenerCredito(codigo);
        
        if (!"".equals(reporte)) {
            System.out.println("\n\n"+reporte);
        }else{
            System.out.println("         ¡El codigo no existe!\n\n");
        }
    }

    
}
