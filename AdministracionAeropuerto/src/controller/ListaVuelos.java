/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.OperacionVuelos;
import model.Vuelo;

/**
 *
 * @author USER
 */
public class ListaVuelos extends ListaAeropuerto implements OperacionVuelos {

    @Override
    public void AddAeropuerto(Vuelo vuelo) {
        listaAeropuerto.add(vuelo);
    }

    @Override
    public void edit(Vuelo vuelo) {
        
    }

    @Override
    public void remove(Vuelo vuelo) {
        
    }
    
}
