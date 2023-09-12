/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class Aeropuerto {

    private Vuelo vuelo;
    private Hangar hangar;
    private Aerolinea aerolinea;
    private ReservaVuelos reseVuelo;

    private ListaAerolinea listAerolinea;
    private ListaHangar listHangar;
    private ListaVuelos listVuelo;
    private ListaVueloReserva listReseVuelos;
    private ArchivoAeropuerto archAerolinea;
    private ArchivoAeropuerto archHangar;
    private ArchivoAeropuerto archVuelos;
    private ArchivoAeropuerto archReseVuelos;

    public Aeropuerto() {

        vuelo = new Vuelo();
        hangar = new Hangar();
        aerolinea = new Aerolinea();
        listAerolinea = new ListaAerolinea();
        listHangar = new ListaHangar();
        listVuelo = new ListaVuelos();
        listReseVuelos = new ListaVueloReserva();
        
        archAerolinea = new ArchivoAeropuerto("Aerolinea.dat");
        archHangar = new ArchivoAeropuerto("Hangar.dat");
        archVuelos = new ArchivoAeropuerto("Vuelos.dat");
        archReseVuelos = new ArchivoAeropuerto("ReseVuelos.dat");
        
        archAerolinea.leer();
        archHangar.leer();
        archVuelos.leer();
        archReseVuelos.leer();
        
        listReseVuelos.setListaAeropuerto(archReseVuelos.getListaNumero());
        listAerolinea.setListaAeropuerto(archAerolinea.getListaNumero());
        listHangar.setListaAeropuerto(archHangar.getListaNumero());
        listVuelo.setListaAeropuerto(archVuelos.getListaNumero());
        

    }
    
    

    public ListaAerolinea getListAerolinea() {
        return listAerolinea;
    }

    public ListaHangar getListHangar() {
        return listHangar;
    }

    public ListaVuelos getListVuelo() {
        return listVuelo;
    }

    public ListaVueloReserva getListReseVuelos() {
        return listReseVuelos;
    }

    public void AsignarHangar(String aerolin, Avion avion,String hangarA) {
        
        hangar.setNombreHang(hangarA);
        hangar.setAvion(avion);
        hangar.setNombreAerolinea(aerolin);
        listHangar.edit(hangar);

    }

    public String[] ObtenerAerolinea() {
        String[] aeroli = new String[listAerolinea.getListaAeropuerto().size()];
        for (int i = 0; i < listAerolinea.getListaAeropuerto().size(); i++) {
            aerolinea = (Aerolinea) listAerolinea.getListaAeropuerto().get(i);
            aeroli[i] = aerolinea.getNombreAero();

        }
        return aeroli;
    }
    
    public String[] MostrarAvionesDisponibles(int indice){
        String[] avionDisponible ;
        boolean ban;
        Avion[] aviones;
        int n =0;
        aerolinea = (Aerolinea) listAerolinea.getListaAeropuerto().get(indice);
        avionDisponible = new String[aerolinea.getAvion().length];
        aviones = aerolinea.getAvion();
         
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
        return avionDisponible;
    }
    
    public String[] MostrarHangarDisponibles(){
        String[] hangares = new String[listHangar.getListaAeropuerto().size()];
       
        for (int i = 0; i < listHangar.getListaAeropuerto().size(); i++) {
            hangar = (Hangar) listHangar.getListaAeropuerto().get(i);
            if (hangar.getAvion() == null) {
                hangares[i] = hangar.getNombreHang();
            }
        }
        

        
        return hangares;
    }
    
    public Avion ObtenerAvion(String Avi,int indice){
        Avion[]aux = null;
        Avion avi = null;
        aux = aerolinea.getAvion();
        aerolinea = (Aerolinea) listAerolinea.getListaAeropuerto().get(indice);
        
        for (int i = 0; i < aerolinea.getAvion().length; i++){
            if (Avi.equals(aux[i].getNombreAvion())) {
                avi = aux[i];
                break;
            }
        }
        
    return avi;    
    }

    public void ReservarVuelo(String client,int cedula, Vuelo vuelo) {
        Cliente cliente = new Cliente();
        cliente.setNombre(client);
        cliente.setCedula(cedula);
        
       
        reseVuelo.setCliente(cliente);
        reseVuelo.setVuelo(vuelo);
       
        listReseVuelos.AddAeropuerto(reseVuelo);

    }
    
    public void RegistrarVuelos(String origen,String destino,String fecha,Hangar hanga) {

        vuelo = new Vuelo();
       
        vuelo.setOrigen(origen);
          
        vuelo.setDestino(destino);
        
        vuelo.setFecha(fecha);

        vuelo.setHangar(hanga);

        listVuelo.AddAeropuerto(vuelo);


    }
    
    public Hangar[] HangaresAsignados() {
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
    
    public Hangar obtnerHangarVuelo(int indice,String Avion){
         aerolinea = (Aerolinea) listAerolinea.getListaAeropuerto().get(indice);
        Hangar[] hang = HangaresAsignados();
        Hangar hanga = null;
       
        for (int i = 0; i < hang.length; i++) {
            if (hang[i].getNombreAerolinea().equals(aerolinea.getNombreAero())) {
                if (Avion.equals(hang[i].getAvion().getNombreAvion())) {
                    hanga = hang[i];
                }
               
            }
        }
        return hanga;
    }
    
    public String[] HangarOcupados(){
        
        Hangar[] hang = HangaresAsignados();
        String[] aviones = new String[hang.length];
       
        for (int i = 0; i < hang.length; i++) {
           aviones[i] = hang[i].getAvion().getNombreAvion();
        }
        
        return aviones;
        
    }
    
    public String[] MostrarVuelosDisponibles(){
        String[] vuelos = new String[listVuelo.getListaAeropuerto().size()];
        
        for (int i = 0; i < listVuelo.getListaAeropuerto().size(); i++) {
            vuelo = (Vuelo) listVuelo.getListaAeropuerto().get(i);
            if (vuelo != null) {
                vuelos[i] = vuelo.getDestino()+" "+vuelo.getFecha()+" "
                    +vuelo.getHangar().getNombreAerolinea()+" "+vuelo.getHangar().getAvion().getNombreAvion();
            }
            
        }
        
        return vuelos;
        
    }
    
    public Vuelo[] ObtenerVuelosDisponibles(String aerolinea){
        Vuelo[] vuelos = new Vuelo[listVuelo.getListaAeropuerto().size()];
        
        for (int i = 0; i < listVuelo.getListaAeropuerto().size(); i++) {
            vuelo = (Vuelo) listVuelo.getListaAeropuerto().get(i);
            
            if (aerolinea.equals(vuelo.getHangar().getNombreAerolinea())) {
                vuelos[i] = vuelo;
            }
        }
        
        return vuelos;
        
    }
    
    public void Escribir() {
        
        archAerolinea.setListaNumero(listAerolinea.getListaAeropuerto());
        archAerolinea.escribir();
        archHangar.setListaNumero(listHangar.getListaAeropuerto());
        archHangar.escribir();
        archReseVuelos.setListaNumero(listReseVuelos.getListaAeropuerto());
        archReseVuelos.escribir();
        archVuelos.setListaNumero(listVuelo.getListaAeropuerto());
        archVuelos.escribir();
    }

}
