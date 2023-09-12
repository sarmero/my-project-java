/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Hangar;
import model.OperacionHangar;

/**
 *
 * @author USER
 */
public class ListaHangar extends ListaAeropuerto implements OperacionHangar {

    @Override
    public void AddAeropuerto(Hangar hangar) {
        listaAeropuerto.add(hangar);
    }

    @Override
    public void edit(Hangar hangar) {
        Hangar aux;
        for (int i = 0; i < listaAeropuerto.size(); i++) {
            aux = (Hangar) listaAeropuerto.get(i);
            if (hangar.equals(aux)) {
                listaAeropuerto.set(i, hangar);
                break;
            }
        }

    }

    @Override
    public void remove(Hangar hangar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setListaAeropuerto(Hangar hangar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
