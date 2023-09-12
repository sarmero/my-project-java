/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controller.ListaAerolinea;
import controller.Aeropuerto;
import controller.ArchivoAeropuerto;
//import controller.ArchivoAeropuerto;
import controller.ListaAeropuerto;
import controller.ListaHangar;
import controller.ListaVueloReserva;
import controller.ListaVuelos;
import java.util.ArrayList;
import java.util.Scanner;
import model.Aerolinea;
import model.Avion;
import model.Cliente;
import model.Hangar;
import model.ReservaVuelos;
import model.Vuelo;

/**
 *
 * @author USER
 */
public class Principal {

    private Aeropuerto aeropuerto;
    private Vuelo vuelo;
    private Hangar hangar;
    private Aerolinea aerolinea;
    private ReservaVuelos reseVuelo;
    Scanner numero, texto;
    private ListaAerolinea listAerolinea;
    private ListaHangar listHangar;
    private ListaVuelos listVuelo;
    private ListaVueloReserva listReseVuelos;
    private ArchivoAeropuerto archAerolinea;
    private ArchivoAeropuerto archHangar;
    private ArchivoAeropuerto archVuelos;
    Avion[] aviones;

    public Principal() {
        aeropuerto = new Aeropuerto();
        vuelo = new Vuelo();
        hangar = new Hangar();
        aerolinea = new Aerolinea();
        numero = new Scanner(System.in);
        texto = new Scanner(System.in);
        listAerolinea = new ListaAerolinea();
        listHangar = new ListaHangar();
        listVuelo = new ListaVuelos();
        listReseVuelos = new ListaVueloReserva();
        archAerolinea = new ArchivoAeropuerto("Aerolinea.dat");
        archHangar = new ArchivoAeropuerto("Hangar.dat");
        archVuelos = new ArchivoAeropuerto("Vuelos.dat");
        
        

        archAerolinea.leer();
//        archHangar.leer();
        System.out.println(archAerolinea.getListaNumero().size());
        listAerolinea.setListaAeropuerto(archAerolinea.getListaNumero());
//        listHangar.setListaAeropuerto(archHangar.getListaNumero());
    }

    public void RegistrarAerolineaPrueba() {
        Avion avion;
        int n = 20;
        aviones = new Avion[6];
        aerolinea = new Aerolinea();
        aerolinea.setNombreAero("Avianca");
        for (int i = 0; i < 6; i++) {
            avion = new Avion();
            avion.setNombreAvion("THK-3" + i);
            avion.setCapacidad(n);
            aviones[i] = avion;
            n = n + 10;
        }
        aerolinea.setAvion(aviones);

        listAerolinea.AddAeropuerto(aerolinea);

        n = 20;
        aviones = new Avion[3];
        aerolinea = new Aerolinea();
        aerolinea.setNombreAero("Satena");
        for (int i = 0; i < 3; i++) {
            avion = new Avion();
            avion.setNombreAvion("PHK-3" + i);
            avion.setCapacidad(n);
            aviones[i] = avion;
            n = n + 10;
        }
        aerolinea.setAvion(aviones);
        listAerolinea.AddAeropuerto(aerolinea);

        n = 20;
        aviones = new Avion[4];
        aerolinea = new Aerolinea();
        aerolinea.setNombreAero("Easyfly");
        for (int i = 0; i < 4; i++) {
            avion = new Avion();
            avion.setNombreAvion("GKJ-3" + i);
            avion.setCapacidad(n);
            aviones[i] = avion;
            n = n + 10;
        }
        aerolinea.setAvion(aviones);
        listAerolinea.AddAeropuerto(aerolinea);
    }

    public void RegistrarAerolinea() {
        int numAero, capacidad;
        String nombre, avi;
        System.out.print("Nombre Aerolinea: ");
        nombre = texto.nextLine();
        System.out.print("Numero de Aviones: ");
        numAero = numero.nextInt();
        System.out.println("********** Aviones ******");

        Avion avion;
        aviones = new Avion[numAero];
        aerolinea = new Aerolinea();

        for (int i = 0; i < numAero; i++) {
            avion = new Avion();
            System.out.print((i + 1) + "º Avion :");
            avi = texto.nextLine();
            System.out.print("Capacidad: ");
            capacidad = numero.nextInt();

            avion.setNombreAvion(avi);
            avion.setCapacidad(capacidad);
            aviones[i] = avion;
        }

        aerolinea.setNombreAero(nombre);
        aerolinea.setAvion(aviones);

        listAerolinea.AddAeropuerto(aerolinea);

//        System.out.println(String.format("%-15s%-15s%-15s%-15s\n", "Fecha", "Hora", "Destino", "Cantidad"));
    }

    public void MostrarAerolineas() {
//        System.out.println(listAerolinea.getListaAeropuerto().size());
        for (int i = 0; i < listAerolinea.getListaAeropuerto().size(); i++) {
            aerolinea = (Aerolinea) listAerolinea.getListaAeropuerto().get(i);
            System.out.println(aerolinea.getNombreAero());

            aviones = aerolinea.getAvion();
            for (int j = 0; j < aviones.length; j++) {
                System.out.println(aviones[j].getNombreAvion() + "  " + aviones[j].getCapacidad());
            }

        }
    }

    public void RegistrarHangaresPrueba() {

        for (int i = 0; i < 12; i++) {
            hangar = new Hangar();
            hangar.setNombreHang("AM8" + i);
            hangar.setAvion(null);
            listHangar.AddAeropuerto(hangar);
        }

    }

    public void RegistrarHangares() {

        String nombre;
        System.out.print("Nombre Hangar: ");
        nombre = texto.nextLine();

        hangar = new Hangar();

        hangar.setNombreHang(nombre);
        hangar.setAvion(null);

        listHangar.AddAeropuerto(hangar);

    }

    public void AsignarHangar() {
        int opcion;
        String[] avionDisponible;
        String nomAerolinea;
        int n = 0;
        boolean ban;
        Avion avion = null;

        System.out.println("Elija la Aerolinea");
        for (int i = 0; i < listAerolinea.getListaAeropuerto().size(); i++) {
            aerolinea = (Aerolinea) listAerolinea.getListaAeropuerto().get(i);
            System.out.println((i + 1) + " " + aerolinea.getNombreAero());

        }

        opcion = numero.nextInt();

        aerolinea = (Aerolinea) listAerolinea.getListaAeropuerto().get(opcion - 1);
        nomAerolinea = aerolinea.getNombreAero();
        aviones = aerolinea.getAvion();
        avionDisponible = new String[aviones.length];

        System.out.println("Elija el Avion que desea guardar");
        System.out.println(aerolinea.getAvion().length);

        for (int i = 0; i < aerolinea.getAvion().length; i++) {
            ban = false;
            for (int j = 0; j < listHangar.getListaAeropuerto().size(); j++) {
                hangar = (Hangar) listHangar.getListaAeropuerto().get(j);

                if (hangar.getAvion() != null) {
                    if (hangar.getAvion().getNombreAvion().equals(aviones[i].getNombreAvion())) {
                        ban = true;
                    }

                }
            }

            if (ban == false) {

                avionDisponible[n] = aviones[i].getNombreAvion();
                n++;
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " " + avionDisponible[i]);
        }

        opcion = numero.nextInt();

        for (int i = 0; i < aviones.length; i++) {
            if (avionDisponible[opcion - 1].equals(aviones[i].getNombreAvion())) {
                avion = aviones[i];
            }
        }

        System.out.println("Lista de Hangares Disponibles");
        for (int i = 0; i < listHangar.getListaAeropuerto().size(); i++) {
            hangar = (Hangar) listHangar.getListaAeropuerto().get(i);
            if (hangar.getAvion() == null) {
                System.out.println((i + 1) + " " + hangar.getNombreHang());
            }
        }

        opcion = numero.nextInt();

        hangar = (Hangar) listHangar.getListaAeropuerto().get(opcion - 1);
        hangar.setAvion(avion);
        hangar.setNombreAerolinea(nomAerolinea);
        listHangar.edit(hangar);

    }

    public void RegistrarVuelos() {

        Hangar[] hang;
        String nombre;
        int opcion;
        vuelo = new Vuelo();

        System.out.println("******Registrar Vuelo******");
        System.out.print("Origen: ");
        nombre = texto.nextLine();
        vuelo.setOrigen(nombre);
        System.out.print("Destino: ");
        nombre = texto.nextLine();
        vuelo.setDestino(nombre);
        System.out.print("Fecha: ");
        nombre = texto.nextLine();
        vuelo.setFecha(nombre);

        hang = HangaresAsignados();

        System.out.println("Elija Una Aerolinea");

        for (int i = 0; i < listAerolinea.getListaAeropuerto().size(); i++) {
            aerolinea = (Aerolinea) listAerolinea.getListaAeropuerto().get(i);
            System.out.println((i + 1) + " " + aerolinea.getNombreAero());
        }

        opcion = numero.nextInt();

        aerolinea = (Aerolinea) listAerolinea.getListaAeropuerto().get(opcion - 1);

        System.out.println("Elija el Avion");
        for (int i = 0; i < hang.length; i++) {
            if (hang[i].getNombreAerolinea().equals(aerolinea.getNombreAero())) {
                System.out.println((i + 1) + " " + hang[i].getAvion().getNombreAvion());
            }
        }

        opcion = numero.nextInt();

        hangar = hang[opcion - 1];

        vuelo.setHangar(hangar);

        listVuelo.AddAeropuerto(vuelo);

//        System.out.println("******* Aviones ******");
//
//        System.out.println(hangar.getAvion().getNombreAvion());
    }

    private Hangar[] HangaresAsignados() {
        Hangar[] hang;
        int n = 0, tamaño = 0;

        for (int j = 0; j < listHangar.getListaAeropuerto().size(); j++) {
            hangar = (Hangar) listHangar.getListaAeropuerto().get(j);
            if (hangar.getAvion() != null) {
                tamaño++;
            }
        }

        hang = new Hangar[tamaño];

        for (int j = 0; j < tamaño; j++) {
            hangar = (Hangar) listHangar.getListaAeropuerto().get(j);
            if (hangar.getAvion() != null) {
                hang[n] = hangar;
                n++;
            }
        }

        return hang;
    }

    public void MostrarHangares() {

        for (int i = 0; i < listHangar.getListaAeropuerto().size(); i++) {
            hangar = (Hangar) listHangar.getListaAeropuerto().get(i);
            System.out.println(hangar.getNombreHang() + " ");

        }
    }

    public void Escribir() {
        
        archAerolinea.setListaNumero(listAerolinea.getListaAeropuerto());
        archAerolinea.escribir();
//        archHangar.setListaNumero(listHangar.getListaAeropuerto());
//        archHangar.escribir();
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
//        principal.RegistrarAerolineaPrueba();
//        for (int i = 0; i < 3; i++) {
//            principal.RegistrarAerolinea();
//        }
//        principal.RegistrarHangaresPrueba();
//        principal.AsignarHangar();
//        for (int i = 0; i < 3; i++) {
//            principal.AsignarHangar();
//        }
//        principal.Escribir();
        principal.MostrarAerolineas();
//        principal.MostrarHangares();
//        principal.MostrarHangaresAsignados();

    }

}
