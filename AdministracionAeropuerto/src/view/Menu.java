/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Aeropuerto;
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
public class Menu {

    private Aeropuerto aeropuerto;
    Scanner numero, texto;

    public Menu() {
        numero = new Scanner(System.in);
        texto = new Scanner(System.in);
        aeropuerto = new Aeropuerto();
    }

    public void Menu() {

        int opcion;
        do {
            System.out.println("###############################");
            System.out.println("--PROGRAMAS AEROPUERTO: " + "\n");
            System.out.println("1. Aerolineas");
            System.out.println("2. Hangares");
            System.out.println("3. Vuelos");
            System.out.println("4. Reservar vuelos");
            System.out.println("5. Salir y guardar");
            System.out.print("\nIngresar opcion: ");

            opcion = numero.nextInt();

            switch (opcion) {
                
                case 1:
                    MenuAerolinea();
                    break;
                case 2:
                    MenuHangares();
                    break;
                case 3:
                    MenuVuelos();
                    break;
                case 4:
                    MenuReservaVuelos();
                    break;
                case 5:
                    aeropuerto.Escribir();
                    break;

            }
        } while (opcion !=5);

    }

    public void MenuAerolinea() {
        int opcion;
        do {
            System.out.println("###############################");
            System.out.println("-- MENU AEROLINEA: " + "\n");
            System.out.println("1. Agregar Aerolinea ");
            System.out.println("2. Modificar aerolineas");
            System.out.println("3. Eliminar Aerolineas");
            System.out.println("4. Mostrar Aerolineas");
            System.out.println("5. Atras");
            System.out.print("\nIngresar opcion: ");

            opcion = numero.nextInt();

            switch (opcion) {
                case 1:
                    RegistrarAerolinea();
                    break;
                case 2:

                    modificarAerolineas();
                    break;
                case 3:
                    ModificarAerolineas();
                    break;
                case 4:
                    MostrarAerolineas();
                    break;
                case 5:
                    Menu();
                    break;

            }
        } while (true);
    }

    public void modificarAerolineas() {

    }

    public void ModificarAerolineas() {

    }

    public void MenuHangares() {
        int opcion;
        do {
            System.out.println("###############################");
            System.out.println("-- MENU HANGAR  : " + "\n");
            System.out.println("1. Agregar hangar ");
            System.out.println("2. Asignar Avion");
            System.out.println("3. Eliminar hangar");
            System.out.println("4. Modificar hangar");
            System.out.println("5. atras");
            System.out.print("\nIngresar opcion: ");

            opcion = numero.nextInt();

            switch (opcion) {
                case 1:
                    RegistrarHangares();
                    break;
                case 2:
                    AsignarHangar();
                    break;
                case 3:
                    EliminarHangar();
                    break;
                case 4:
                    ModificarHangar();
                    break;
                case 5:
                    Menu();
                    break;

            }
        } while (true);
    }

    public void EliminarHangar() {

    }

    public void ModificarHangar() {

    }

    public void MenuVuelos() {
        int opcion;
        do {
            System.out.println("###############################");
            System.out.println("-- MENU VUELOS: " + "\n");
            System.out.println("1. Asignar Vuelo ");
            System.out.println("2. Mostrar Vuelos");
            System.out.println("3. Moddificar Vuelo");
            System.out.println("4. Eliminar Vuelo");
            System.out.println("5. Atras");
            System.out.print("\nIngresar opcion: ");

            opcion = numero.nextInt();

            switch (opcion) {
                case 1:
                    RegistrarVuelos();
                    break;
                case 2:
                    aeropuerto.MostrarVuelosDisponibles();
                    break;
                case 3:
                    ModificarVuelo();
                    break;
                case 4:
                    EliminarVuelo();
                    break;

                case 5:
                    Menu();
                    break;

            }
        } while (true);
    }
    
    public void ModificarVuelo(){
        
    }
    
    public void EliminarVuelo(){
        
    }

    public void MenuReservaVuelos() {
        
        int opcion;
        do {
        
            System.out.println("###############################");
            System.out.println("-- RESERVAR VUELO: " + "\n");
            System.out.println("1. Reservar Vuelo");
            System.out.println("2. Modificar Reserva");
            System.out.println("3. Eliminar Reserva");
            System.out.println("5. Atras");
            System.out.print("\nIngresar opcion: ");

            opcion = numero.nextInt();

            switch (opcion) {
                case 1:

                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    break;

            }
        } while (true);
    }

    public void RegistrarAerolinea() {
        int numAero, capacidad;
        Avion[] aviones;
        String nombre, avi;
        System.out.print("Nombre Aerolinea: ");
        nombre = texto.nextLine();
        System.out.print("Numero de Aviones: ");
        numAero = numero.nextInt();
        System.out.println("********** Aviones ******");

        Avion avion;
        aviones = new Avion[numAero];
        Aerolinea aerolinea = new Aerolinea();

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

        aeropuerto.getListAerolinea().AddAeropuerto(aerolinea);

//        System.out.println(String.format("%-15s%-15s%-15s%-15s\n", "Fecha", "Hora", "Destino", "Cantidad"));
    }

    public void MostrarAerolineas() {
        Avion[] aviones;

        for (int i = 0; i < aeropuerto.getListAerolinea().getListaAeropuerto().size(); i++) {
            Aerolinea aerolinea = (Aerolinea) aeropuerto.getListAerolinea().getListaAeropuerto().get(i);
            System.out.println(aerolinea.getNombreAero());

            aviones = aerolinea.getAvion();
            for (int j = 0; j < aviones.length; j++) {
                System.out.println(aviones[j].getNombreAvion() + "  " + aviones[j].getCapacidad());

            }
            System.out.println("");

        }
    }

    public void RegistrarHangares() {
        Hangar hangar;
        String nombre;
        System.out.print("Nombre Hangar: ");
        nombre = texto.nextLine();

        hangar = new Hangar();

        hangar.setNombreHang(nombre);
        hangar.setAvion(null);

        aeropuerto.getListHangar().AddAeropuerto(hangar);

    }

    public void AsignarHangar() {
        int opcion, indice;
        String[] aux;
        String aerol;
        String avi, hangar;

        Avion avion;

        System.out.println("Elija la Aerolinea");
        aux = aeropuerto.ObtenerAerolinea();
        for (int i = 0; i < aeropuerto.ObtenerAerolinea().length; i++) {
            System.out.println((i + 1) + " " + aux[i]);
        }

        opcion = numero.nextInt();
        aerol = aux[opcion - 1];
        indice = opcion;

        System.out.println("Elija el Avion que desea guardar");
        aux = aeropuerto.MostrarAvionesDisponibles(indice);
        for (int i = 0; i < aux.length; i++) {
            System.out.println((i + 1) + " " + aux[i]);

        }

        opcion = numero.nextInt();

        avi = aux[opcion - 1];
        avion = aeropuerto.ObtenerAvion(avi, indice);

        System.out.println("Lista de Hangares Disponibles");
        aux = aeropuerto.MostrarHangarDisponibles();
        for (int i = 0; i < aux.length; i++) {
            System.out.println((i + 1) + " " + aux[i]);

        }

        opcion = numero.nextInt();
        hangar = aux[opcion - 1];

        aeropuerto.AsignarHangar(aerol, avion, hangar);

    }

    public void ReservarVuelo() {
        Vuelo[] vuelo;
        int opcion, cedula;
        String nombre;
        String[] aux;

        System.out.println("****** Reservar vuelos ******");

        System.out.println("Elija la Aerolinea");
        aux = aeropuerto.ObtenerAerolinea();
        for (int i = 0; i < aeropuerto.ObtenerAerolinea().length; i++) {
            System.out.println((i + 1) + " " + aux[i]);
        }

        opcion = numero.nextInt();
        nombre = aux[opcion - 1];

        vuelo = aeropuerto.ObtenerVuelosDisponibles(nombre);

        for (int i = 0; i < aux.length; i++) {
            System.out.println((i + 1) + " " + vuelo[i].getDestino() + " " + vuelo[i].getFecha() + " "
                    + " " + vuelo[i].getHangar().getAvion().getNombreAvion());
        }

        opcion = numero.nextInt();

        System.out.print("Nombre Cliente: ");
        nombre = texto.nextLine();
        System.out.print("Cedula Cliente: ");
        cedula = numero.nextInt();

        aeropuerto.ReservarVuelo(nombre, cedula, vuelo[opcion]);

    }

    public void RegistrarVuelos() {

        Hangar hang;
        String origen, destino, fecha;
        int opcion, aerol;
        String[] aux;

        System.out.println("******Registrar Vuelo******");
        System.out.print("Origen: ");
        origen = texto.nextLine();

        System.out.print("Destino: ");
        destino = texto.nextLine();

        System.out.print("Fecha: ");
        fecha = texto.nextLine();

        System.out.println("Elija la Aerolinea");
        aux = aeropuerto.ObtenerAerolinea();
        for (int i = 0; i < aeropuerto.ObtenerAerolinea().length; i++) {
            System.out.println((i + 1) + " " + aux[i]);
        }

        opcion = numero.nextInt();
        aerol = opcion - 1;

        aeropuerto.HangaresAsignados();

        System.out.println("Elija el Avion que desea guardar");
        aux = aeropuerto.HangarOcupados();
        for (int i = 0; i < aux.length; i++) {
            System.out.println((i + 1) + " " + aux[i]);
        }

        opcion = numero.nextInt();

        hang = aeropuerto.obtnerHangarVuelo(aerol, aux[opcion - 1]);

        aeropuerto.RegistrarVuelos(origen, destino, fecha, hang);

    }

}
