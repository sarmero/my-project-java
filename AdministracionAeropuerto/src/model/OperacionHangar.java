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
public interface OperacionHangar {
    
    void setListaAeropuerto(Hangar hangar);     
    
    ArrayList<Hangar> getListaAeropuerto();

    void AddAeropuerto(Hangar hangar);

    void edit(Hangar hangar);

    void remove(Hangar hangar);
}
