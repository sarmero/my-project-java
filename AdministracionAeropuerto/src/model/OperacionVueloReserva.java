/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface OperacionVueloReserva {
     public void setListaAeropuerto(ReservaVuelos vueloRese);     
    
    ArrayList<ReservaVuelos> getListaAeropuerto();

    void AddAeropuerto( ReservaVuelos vueloRese);

    void edit( ReservaVuelos vueloRese);

    void remove( ReservaVuelos vueloRese);
}
