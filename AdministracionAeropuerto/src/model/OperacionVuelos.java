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
public interface OperacionVuelos {
    ArrayList<Vuelo> getListaAeropuerto();

    void AddAeropuerto(Vuelo vuelo);

    void edit(Vuelo vuelo);

    void remove(Vuelo vuelo);
}
