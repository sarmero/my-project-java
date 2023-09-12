/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ListaAerolinea;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface OperacionAerolinea {

    ArrayList<Aerolinea> getListaAeropuerto();
    
    void setListaAeropuerto(ArrayList<Aerolinea> aerolinea);  

    void AddAeropuerto(Aerolinea aerolinea);

    void edit(Aerolinea aerolinea);

    void remove(Aerolinea aerolinea);

}
