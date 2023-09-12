/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Aerolinea;
import model.Avion;
import model.OperacionAerolinea;

/**
 *
 * @author USER
 */
public class ListaAerolinea extends ListaAeropuerto implements OperacionAerolinea {

    @Override
    public void AddAeropuerto(Aerolinea Aerolinea) {
        listaAeropuerto.add(Aerolinea);
    }

    @Override
    public void edit(Aerolinea Aerolinea) {

    }

    @Override
    public void remove(Aerolinea Aerolinea) {

    }

    @Override
    public void setListaAeropuerto(ArrayList aerolinea) {
        listaAeropuerto = aerolinea;
    }

}
