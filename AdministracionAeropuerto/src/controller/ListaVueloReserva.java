/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.OperacionVueloReserva;
import model.ReservaVuelos;

/**
 *
 * @author USER
 */
public class ListaVueloReserva extends ListaAeropuerto implements OperacionVueloReserva{
    
    @Override
    public void setListaAeropuerto(ReservaVuelos vueloRese) {
        
    }

    @Override
    public void AddAeropuerto(ReservaVuelos vueloRese) {
        listaAeropuerto.add(vueloRese);
    }

    @Override
    public void edit(ReservaVuelos vueloRese) {
        
    }

    @Override
    public void remove(ReservaVuelos vueloRese) {
        
    }
    
}
